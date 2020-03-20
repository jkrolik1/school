#include <string>
#include <vector>

class ReferenceUnit{            // jednostka wzorcowa
    public:
        ReferenceUnit(std::string, std::string);
        virtual void showInfo() = 0;
        std::string getTitle(){return title;};
        std::string getType(){return type;};
    protected:
        std::string title;
        std::string type;
};

class BaseUnit : public ReferenceUnit{
    public:
        BaseUnit(std::string, std::string);
        void showInfo() override;
};

class OrganizationalUnit : public ReferenceUnit{
    public:
        OrganizationalUnit(std::string, std::string);
        void add(std::shared_ptr<ReferenceUnit>);
        void showInfo() override;
    protected:
        std::vector<std::shared_ptr<ReferenceUnit>> components;
};
