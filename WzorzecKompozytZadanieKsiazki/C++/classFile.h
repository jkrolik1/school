#include <string>
#include <vector>

class ReferenceUnit{            // jednostka wzorcowa
    public:
        ReferenceUnit(std::string, std::string);
        virtual void showInfo(int&,int&,int&) = 0;
        std::string getTitle(){return title;};
        std::string getType(){return type;};
    protected:
        std::string title;
        std::string type;
};

class BaseUnit : public ReferenceUnit{
    public:
        BaseUnit(std::string, std::string);
        void showInfo(int&,int&,int&) override;
};

class OrganizationalUnit : public ReferenceUnit{
    public:
        OrganizationalUnit(std::string, std::string);
        void add(std::shared_ptr<ReferenceUnit>);
        void showInfo(int&,int&,int&) override;
    protected:
        std::vector<std::shared_ptr<ReferenceUnit>> components;
};
