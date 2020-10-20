#include <iostream>
#include <string>

int main()
{
	int x = 0, y = 0, strong = 1;
	std::string strongStr = "";


	std::cin >> x;

	for (int i = 0; i < x; ++i)
	{
		std::cin >> y;
		if (y >= 10)
		{
			strongStr = "0 0";
			std::cout << strongStr << '\n';
			strongStr = "";
			continue;
		}
		for (int u = 1; u < y+1; ++u)
			strong *= u;
		if (strong < 10)
		{
			strongStr += '0';
			strongStr += std::to_string(strong);
		}
		else
			strongStr = std::to_string(strong);

		strong = 1;
		std::cout << strongStr[strongStr.size() - 2] << ' ';
		std::cout << strongStr[strongStr.size() - 1] << '\n';
		strongStr = "";
	}
}