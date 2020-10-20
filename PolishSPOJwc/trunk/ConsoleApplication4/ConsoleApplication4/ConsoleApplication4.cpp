#include <iostream>
#include <string>

int main()
{
    int x = 0;
    int am = 0;
    std::string am2 = "";

    std::cin >> x;

    std::string str = "", newstr = "";

    for (int i = 0; i < x; ++i)
    {
        std::cin >> str;
        for (int j = 0; j < str.size(); ++j)
        {
            if ((j + 2) < str.size())
            {
                if ((str[j] == str[j + 1]) && (str[j + 1] == str[j + 2]))
                {
                    for (int o = j; (str[j] == str[o]) && (o < str.size()); ++o)
                    {
                        if (o == j)
                            newstr += str[j];
                        am += 1;
                    }
                    newstr += std::to_string(am);
                    j = j + am - 1;
                    am = 0;
                }
                else
                {
                    newstr += str[j];
                }
            }
            else
            {
                newstr += str[j];
            }

        }
        std::cout << newstr << '\n';
        newstr = "";
    }
}
