#include <iostream>
#include <memory>
#include <vector>

#include "classFile.h"

void samochody();       // ksiazka o samochodach
std::string apart(std::string str);

int counterRozdzial = 0, counterPodrozdzial = 0, counterPodpodrozdzial = 0;

int main(){
    samochody();

    return 0;
}

void samochody(){
            std::shared_ptr<OrganizationalUnit> ou4 = std::make_shared<OrganizationalUnit>("Gorna czesc dolu silnika","Podpodrozdzial pierwszy");
            std::shared_ptr<OrganizationalUnit> ou6 = std::make_shared<OrganizationalUnit>("Dolna czesc dolu silnika","Podpodrozdzial drugi");
            std::shared_ptr<OrganizationalUnit> ou7 = std::make_shared<OrganizationalUnit>("Gorna czesc gory silnika","Podpodrozdzial pierwszy");
            std::shared_ptr<OrganizationalUnit> ou8 = std::make_shared<OrganizationalUnit>("Dolna czesc gory silnika","Podpodrozdzial drugi");
            std::shared_ptr<OrganizationalUnit> ou3 = std::make_shared<OrganizationalUnit>("Dol silnika","Podrozdzial pierwszy");
            std::shared_ptr<OrganizationalUnit> ou5 = std::make_shared<OrganizationalUnit>("Gora silnika","Podrozdzial drugi");
            std::shared_ptr<OrganizationalUnit> ou10 = std::make_shared<OrganizationalUnit>("Przod spodu samochodu","Podrozdzial pierwszy");
            std::shared_ptr<OrganizationalUnit> ou11 = std::make_shared<OrganizationalUnit>("Tyl spodu samochodu","Podrozdzial drugi");
                ou3->add(ou4);
                ou3->add(ou6);
                ou5->add(ou7);
                ou5->add(ou8);
                    ou4->add(std::make_shared<BaseUnit>("Walek rozrzadu","Akapit pierwszy"));
                    ou4->add(std::make_shared<BaseUnit>("Wal korbowy","Akapit drugi"));
                    ou6->add(std::make_shared<BaseUnit>("Korbowod","Akapit pierwszy"));
                    ou6->add(std::make_shared<BaseUnit>("Pompa olejowa","Akapit drugi"));
                    ou6->add(std::make_shared<BaseUnit>("Misa olejowa","Akapit trzeci"));
                    ou8->add(std::make_shared<BaseUnit>("Kolo zamachowe","Akapit pierwszy"));
                    ou8->add(std::make_shared<BaseUnit>("Tlok","Akapit drugi"));
                    ou7->add(std::make_shared<BaseUnit>("Zawory","Akapit pierwszy"));
                    ou7->add(std::make_shared<BaseUnit>("Pompa wody","Akapit drugi"));
                    ou7->add(std::make_shared<BaseUnit>("Wtryskiwacz","Akapit trzeci"));
                    ou7->add(std::make_shared<BaseUnit>("Termostat","Akapit czwarty"));
                    ou10->add(std::make_shared<BaseUnit>("Filtr oleju","Akapit pierwszy"));
                    ou10->add(std::make_shared<BaseUnit>("Katalizator","Akapit drugi"));
                    ou10->add(std::make_shared<BaseUnit>("Skrzynia biegow","Akapit trzeci"));
                    ou11->add(std::make_shared<BaseUnit>("Przewody hamulcowe","Akapit pierwszy"));
                    ou11->add(std::make_shared<BaseUnit>("Tlumnik koncowy","Akapit drugi"));
                    ou11->add(std::make_shared<BaseUnit>("Linki hamulca recznego","Akapit trzeci"));
                    ou11->add(std::make_shared<BaseUnit>("Zbiornik paliwa","Akapit czwarty"));
        std::shared_ptr<OrganizationalUnit> ou2 = std::make_shared<OrganizationalUnit>("Silnik","Rozdzial pierwszy");
        std::shared_ptr<OrganizationalUnit> ou9 = std::make_shared<OrganizationalUnit>("Spod samochodu","Rozdzial drugi");
            ou2->add(ou3);
            ou2->add(ou5);
            ou9->add(ou10);
            ou9->add(ou11);
    std::shared_ptr<OrganizationalUnit> ou1 = std::make_shared<OrganizationalUnit>("Samochody","Ksiazka");
        ou1->add(ou2);
        ou1->add(ou9);

    ou1->showInfo(counterRozdzial,counterPodrozdzial,counterPodpodrozdzial);
}

ReferenceUnit::ReferenceUnit(std::string tit, std::string typ) : title(tit),type(typ){};

BaseUnit::BaseUnit(std::string tit, std::string typ) : ReferenceUnit(tit,typ){};

void BaseUnit::showInfo(int& counterRozdzial,int& counterPodrozdzial,int& counterPodpodrozdzial){std::cout << " " << type << ": " << title << std::endl;}

OrganizationalUnit::OrganizationalUnit(std::string tit, std::string typ) : ReferenceUnit(tit,typ){};

void OrganizationalUnit::add(std::shared_ptr<ReferenceUnit> x) {components.push_back(x);}

void OrganizationalUnit::showInfo(int& counterRozdzial,int& counterPodrozdzial,int& counterPodpodrozdzial){
    std::string takenType,firstPart,spaces="";

    std::cout << type << ": " << title << std::endl;
    for(auto x : components){
        takenType = (x->getType());
        firstPart = apart(takenType);
        if(firstPart == "Podpodrozdzial"){
            counterPodpodrozdzial += 1;
            std::cout << "     ";
            std::cout << counterRozdzial << ".";
            std::cout << counterPodrozdzial << ".";
            std::cout << counterPodpodrozdzial << ". ";
            x->showInfo(counterRozdzial,counterPodrozdzial,counterPodpodrozdzial);
        }
        if(firstPart == "Podrozdzial"){
            counterPodrozdzial += 1;
            std::cout << "   ";
            std::cout << counterRozdzial << ".";
            std::cout << counterPodrozdzial << ". ";
            counterPodpodrozdzial = 0;
            x->showInfo(counterRozdzial,counterPodrozdzial,counterPodpodrozdzial);
        }
        if(firstPart == "Rozdzial"){
            counterRozdzial += 1;
            std::cout << " ";
            std::cout << counterRozdzial << ". ";
            counterPodrozdzial = 0;
            counterPodpodrozdzial = 0;
            x->showInfo(counterRozdzial,counterPodrozdzial,counterPodpodrozdzial);
        }
        if(firstPart == "Akapit"){
            if(counterRozdzial > 0)
                spaces += "   ";
                if(counterPodrozdzial > 0)
                    spaces += "    ";
                    if(counterPodpodrozdzial > 0)
                        spaces += "     ";

            std::cout << spaces;
            spaces = "";
            x->showInfo(counterRozdzial,counterPodrozdzial,counterPodpodrozdzial);
        }
    }
}

std::string apart(std::string str){
    std::string retStr="";
    int it=0;

    do{
        retStr += str.at(it);
        it += 1;
    }while(str.at(it)!=' ');

    return retStr;
}

