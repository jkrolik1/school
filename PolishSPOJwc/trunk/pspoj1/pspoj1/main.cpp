#include <iostream>
constexpr auto T_SIZE = 1001;

char* string_merge(char*, char*);

int main()
{ 
	char S1[T_SIZE], S2[T_SIZE], *S;

	int amount;
	std::cin >> amount;

	for (int i = 0; i < amount; ++i)
	{
		std::cin.getline(S1, T_SIZE, ' ');
		std::cin.getline(S2, T_SIZE);
		S = string_merge(S1, S2);
		std::cout << S << std::endl;
		delete[] S;
	}
	return 0; 
}

char* string_merge(char* x, char* y)
{
	char* i;
	int xSize=0, ySize=0, allSize=0;

	for (; *x; x++)
		xSize += 1;

	for (; *y; y++)
		ySize += 1;

	for (int l = xSize; l>0; x--,--l) 
	{
	}
	for (int l = ySize; l>0; y--,--l)
	{
	}

	if (xSize <= ySize)
	{
		allSize = 2 * xSize;
		i = new char[allSize];
		for (; *x; x++,y++)
		{
			*i = *x;
			i++;
			*i = *y;
			i++;
		}
	}
	else
	{
		allSize = 2 * ySize;
		i = new char[allSize];
		for (; *y; y++,x++)
		{
			*i = *x;
			i++;
			*i = *y;
			i++;
		}
	}

	*i = '\0';

	for (; allSize > 0; --allSize, i--)
	{
	}
	
	return i;
}