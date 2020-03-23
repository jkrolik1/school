#include <string>
#include <memory>

class ConfigFile{
public:
    std::string getType();
    std::string getNextType();
};

class Choice{
public:
    virtual std::string execTag(std::string) = 0;
};

class PTag : public Choice{
public:
    std::string execTag(std::string);
};

class StrongTag : public Choice{
public:
    std::string execTag(std::string);
};

class EmTag : public Choice{
public:
    std::string execTag(std::string);
};

class MarkTag : public Choice{
public:
    std::string execTag(std::string);
};

class NoneTag : public Choice{
public:
    std::string execTag(std::string);
};

class TagFactory{
public:
    std::shared_ptr<Choice> createTag(std::shared_ptr<ConfigFile>);
};

class TagFactoryClient{
    std::shared_ptr<ConfigFile> cnF = std::make_shared<ConfigFile>();
public:
    std::string createAndUseTag(std::string);

};
