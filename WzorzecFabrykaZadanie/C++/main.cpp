#include <iostream>
#include <string>
#include <memory>

#include "classFile.h"


// HEADERS OF FUNCTIONS
void task();
std::string getText();
bool getNextText();


int main(){
    task();
    return 0;
}


// FUNCTIONS BODIES
void task(){
    std::string s = "";
    std::string line = getText();

    std::shared_ptr<TagFactoryClient> client = std::make_shared<TagFactoryClient>();
    s = client->createAndUseTag(line);

    while(getNextText()){
        std::shared_ptr<ConfigFile> cg = std::make_shared<ConfigFile>();
        std::string type = cg->getNextType();
        std::shared_ptr<TagFactoryClient> client2 = std::make_shared<TagFactoryClient>();
        s = client2->createAndUseTag(s);
    }

}
std::string getText(){
    std::string line = "";
    std::cout << "Enter line of text: ";
    getline(std::cin, line);
    return line;
}
bool getNextText(){
    bool line = 0;
    std::cout << std::endl << "\n-----------------------------------------";
    std::cout << std::endl << "Do you want to add next tag? 1-Yes, 0-No";
    std::cout << std::endl << ">";
    std::cin >> line;
    return line;
}


// CLASSES BODIES
std::string ConfigFile::getType(){
    std::string line("");

    std::cout << std::endl;
    std::cout << "Select tag: " << std::endl;
    std::cout << "- p" << std::endl;
    std::cout << "- strong" << std::endl;
    std::cout << "- em" << std::endl;
    std::cout << "- mark" << std::endl;
    std::cout << std::endl;
    std::cout << ">";

    getline(std::cin,line);

    return line;
}
std::string ConfigFile::getNextType(){
    std::string line("");

    getline(std::cin,line);

    return line;
}
std::string PTag::execTag(std::string content){
    std::cout << "\n" << std::endl;
    std::string ret("");
    ret += "<p>";
    ret += content;
    ret += "</p>";
    std::cout << ret << std::endl;
    return ret;
}
std::string StrongTag::execTag(std::string content){
    std::cout << "\n" << std::endl;
    std::string ret("");
    ret += "<strong>";
    ret += content;
    ret += "</strong>";
    std::cout << ret << std::endl;
    return ret;
}
std::string EmTag::execTag(std::string content){
    std::cout << "\n" << std::endl;
    std::string ret("");
    ret += "<em>";
    ret += content;
    ret += "</em>";
    std::cout << ret << std::endl;
    return ret;
}
std::string MarkTag::execTag(std::string content){
    std::cout << "\n" << std::endl;
    std::string ret("");
    ret += "<mark>";
    ret += content;
    ret += "</mark>";
    std::cout << ret << std::endl;
    return ret;
}
std::string NoneTag::execTag(std::string content){
    std::cout << "\n" << std::endl;
    std::string ret("");
    ret += content;
    std::cout << ret << std::endl;
    return ret;
}
std::shared_ptr<Choice> TagFactory::createTag(std::shared_ptr<ConfigFile> cf){
    std::string type = cf->getType();

    if(type == "p")
        return std::make_shared<PTag>();
    else if(type == "strong")
        return std::make_shared<StrongTag>();
    else if(type == "em")
        return std::make_shared<EmTag>();
    else if(type == "mark")
        return std::make_shared<MarkTag>();
    else
        return std::make_shared<NoneTag>();
}
std::string TagFactoryClient::createAndUseTag(std::string line){
    std::shared_ptr<TagFactory> tagF = std::make_shared<TagFactory>();

    std::shared_ptr<Choice> choice = tagF->createTag(std::move(cnF));

    std::string str = choice->execTag(line);

    return str;
}


