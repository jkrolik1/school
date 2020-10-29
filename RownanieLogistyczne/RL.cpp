#include <iostream>
#include <cstdio>
#include <sstream>

#include "boost/lexical_cast.hpp"

double thisYear = 0,r = 0.0, score = 0;
std::string thisYear2 = " ",r2 = " ",choice2 = " ";
int i = 0, choice = 0, years = 1;

void start();
bool isSpace(std::string s);
void getValues();
void welcome();
double equation();
double equation2();
bool isNumeric(const std::string& s);

int main(){
    start();
    do{
        if(i != 0){
            do{
                std::cout << "\n\n  Co chcesz teraz zrobic?\n";
                std::cout << "  1. Umiesc wynik w rownaniu i popatrz na kolejny rok.\n";
                std::cout << "  2. Wykonaj program dla innych danych.\n";
                std::cout << "  3. Wyjdz z programu.\n";
                std::cout << "     Wybor (wpisz 1, 2 lub 3): ";
                std::cin >> choice2;
            }while(!isNumeric(choice2));

            choice = boost::lexical_cast<double>(choice2);

            if(choice == 1){
                years += 1;
                score = equation2();
            }
            if(choice == 2){
                thisYear = 0;
                r = 0.0;
                score = 0;
                years = 1;
                getValues();
                score = equation();
            }
            if(choice == 3) { break; }
            if((choice > 3) || (choice < 1)) {

            }
        }
        else{
            getValues();
            score = equation();
        }

        i += 1;

    }while(choice != 3);

    return 0;
}

bool isSpace(std::string s){
    for(int i=0; i<s.length(); ++i){
        if(s.at(i) == ' ')
            return true;
    }
    return false;
}
bool isNumeric(const std::string& s){
    for(int i=0; i<s.length(); ++i){
        if(((s.at(i) < '0')||(s.at(i) > '9'))&&(s.at(i)!='.'))
            return false;
    }
    return true;
}
double equation2(){
    score = r*score*(1-score);
    std::cout << "\n  Populacja wzrosnie w " << years << " roku o " << score*100 <<"%";
    return score;
}
double equation(){
    score = r*thisYear*(1-thisYear);
    std::cout << "  Populacja wzrosnie w " << years << " roku o " << score*100 <<"%";
    return score;
}
void welcome(){
    std::cout << std::endl << "  ---| WITAJ! Wylicz populacje w nastepnym roku. |------------------------\n\n";
}
void getValues(){
        std::cout << "\n  Podaj procent liczby osobnikow w tym roku \n";
        std::cout << "  (dozwolona wartosc x, ktora spelnia warunek 0<=x<=1 - np.: 0.4 - bez spacji): ";
        int q=0,j=0;
        do{
            do{
                if(q!=0){
                    std::cout << "  Dozwolona wartosc x, ktora spelnia warunek 0<=x<=1 - np.: 0.4 - bez spacji.\n";
                    std::cout << "  Podaj jeszcze raz: ";
                }
                std::cin >> thisYear2;
                ++q;
            }while((!isNumeric(thisYear2))&&(!(isSpace(thisYear2))));

            thisYear = boost::lexical_cast<double>(thisYear2);

        }while((thisYear < 0) || (thisYear > 1));

        std::cout << "  Podaj wspolczynnik wzrostu (dowolna liczba rzeczywista - np: 2.6 - bez spacji): ";

        do{
            if(j!=0)
                std::cout << "  Dozwolona dowolna liczba rzeczywista - np: 2.6 - bez spacji. Podaj jeszcze raz: ";
            std::cin >> r2;
            ++j;
        }while((!isNumeric(r2))&&(!(isSpace(r2))));

        r = boost::lexical_cast<double>(r2);


}
void start(){
    welcome();
    std::cout << "  ---- POSTAC ROWNANIA: Xn+1 = R*Xn(1-Xn)\n";
    std::cout << "                        ^      ^      ^\n";
    std::cout << "                Populacja    Tempo    Procent populacji\n";
    std::cout << "              w nastepnym    wzrostu  w tym roku\n";
    std::cout << "                     roku\n";

}
