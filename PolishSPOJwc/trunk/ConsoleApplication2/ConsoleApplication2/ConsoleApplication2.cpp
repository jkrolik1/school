#include <iostream>

int main()
{
    int num = 0;
    std::string str,str2;

    std::cin >> num;

    for(int i = 0; i < num; ++i)
    {
        std::cin >> str;
        for (int j = 0; j < str.size() / 2; ++j)
        {
            str2.push_back(str[j]);
        }
        std::cout << str2 << '\n';
        str2 = "";
    }

}