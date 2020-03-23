#include <string>
#include <memory>

class ConfigFile{
public:
    std::string getType();
    std::string nextType(std::string);
};

class Choice{
public:
    virtual void execTag(std::string) = 0;
};

class PTag : public Choice{
public:
    void execTag(std::string);
};

class StrongTag : public Choice{
public:
    void execTag(std::string);
};

class EmTag : public Choice{
public:
    void execTag(std::string);
};

class MarkTag : public Choice{
public:
    void execTag(std::string);
};

class TagFactory{
public:
    std::unique_ptr<Choice> createTag(std::unique_ptr<ConfigFile>);
};

class TagFactoryClient{
    std::unique_ptr<ConfigFile> cnF = std::make_unique<ConfigFile>();
public:
    void createAndUseTag(std::string);

};
