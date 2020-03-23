#include <iostream>
#include <string>
#include <memory>

#include "classFile.h"


// HEADERS OF FUNCTIONS

std::string getText();



int main(){
    std::string line = getText();

    std::unique_ptr<TagFactoryClient> client = std::make_unique<TagFactoryClient>();
    std::string s = client->createAndUseTag(line);


    return 0;
}


// FUNCTIONS BODIES

std::string getText(){
    std::string line = "";
    std::cout << "Enter line of text: ";
    getline(std::cin, line);
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
    std::cout << "> ";

    getline(std::cin,line);

    return line;
}

std::string ConfigFile::nextType(std::string){
    std::string line("");

    std::cout << std::endl;
    std::cout << "Select tag: " << std::endl;
    std::cout << "- p" << std::endl;
    std::cout << "- strong" << std::endl;
    std::cout << "- em" << std::endl;
    std::cout << "- mark" << std::endl;
    std::cout << std::endl;
    std::cout << "> ";

    getline(std::cin,line);

    return line;
}

std::string PTag::execTag(std::string content){
    std::cout << std::endl;
    std::string ret("");
    ret += "<p>";
    ret += content;
    ret += "</p>";
    std::cout << ret << std::endl;
    return ret;
}

std::string StrongTag::execTag(std::string content){
    std::cout << std::endl;
    std::string ret("");
    ret += "<strong>";
    ret += content;
    ret += "</strong>";
    std::cout << ret << std::endl;
    return ret;
}

std::string EmTag::execTag(std::string content){
    std::cout << std::endl;
    std::string ret("");
    ret += "<em>";
    ret += content;
    ret += "</em>";
    std::cout << ret << std::endl;
    return ret;
}

std::string MarkTag::execTag(std::string content){
    std::cout << std::endl;
    std::string ret("");
    ret += "<mark>";
    ret += content;
    ret += "</mark>";
    std::cout << ret << std::endl;
    return ret;
}

std::unique_ptr<Choice> TagFactory::createTag(std::unique_ptr<ConfigFile> cf){
    std::string type = cf->getType();

    if(type == "p")
        return std::make_unique<PTag>();
    if(type == "strong")
        return std::make_unique<StrongTag>();
    if(type == "em")
        return std::make_unique<EmTag>();
    if(type == "mark")
        return std::make_unique<MarkTag>();

    return nullptr;
}

std::string TagFactoryClient::createAndUseTag(std::string line){
    std::unique_ptr<TagFactory> tagF = std::make_unique<TagFactory>();

    std::unique_ptr<Choice> choice = tagF->createTag(std::move(cnF));

    std::string str = choice->execTag(line); //!

    return str;
}


