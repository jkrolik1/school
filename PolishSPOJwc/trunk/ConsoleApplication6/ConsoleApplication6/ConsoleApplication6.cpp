#include <iostream>
#include <string>
#include <boost/algorithm/string.hpp>

int main()
{
    std::string zdanie = "", noweZdanie = "";

    while (std::getline(std::cin, zdanie))
    {
        for (int i = 0; i < zdanie.size(); ++i)
        {
            if (zdanie[i] == ' ')
            {
                while (zdanie[i] == ' ')
                    i++;
                if((zdanie[i] >= 'a') && (zdanie[i] <= 'z'))
                    noweZdanie += char((int)(zdanie[i]-32));
                else
                    noweZdanie += zdanie[i];
            }
            else
                noweZdanie += zdanie[i];
        }
        std::cout << noweZdanie << '\n';
        zdanie = noweZdanie = "";
    }
}