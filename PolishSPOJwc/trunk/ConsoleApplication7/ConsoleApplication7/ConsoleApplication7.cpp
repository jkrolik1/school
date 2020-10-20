#include <iostream>
#include <string>
#include <map>
#include <vector>

std::map<char, int> fillMapLow();
std::map<char, int> fillMapHigh();

int main()
{
    std::string sentence = "",mergedSentences = "";
    int amount = 0;
    std::map<char, int> alphabetHigh = fillMapHigh();
    std::map<char, int> alphabetLow = fillMapLow();
    std::vector<std::string> sens;

    std::cin >> amount;

    for (int i = 0; i < amount; ++i)
    {
        std::cin.ignore();
        std::getline(std::cin, sentence);
        sens.emplace_back(sentence);
    }

    for (int y = 0; y < sens.size(); ++y)
    {
        mergedSentences = sens[y];
        for (int j = 0; j < mergedSentences.size(); ++j)
        {
            if ((mergedSentences[j] >= 'A') && (mergedSentences[j] <= 'Z'))
                alphabetHigh[mergedSentences[j]] += 1;
            else if ((mergedSentences[j] >= 'a') && (mergedSentences[j] <= 'z'))
                alphabetLow[mergedSentences[j]] += 1;
        }
    }

}

std::map<char, int> fillMapLow()
{
    std::map<char, int> alpha;

    for (char i = 'a'; i <= 'z'; ++i)
        alpha.emplace(std::pair<char, int>(i,0)); 

    return alpha;
}
std::map<char, int> fillMapHigh()
{
    std::map<char, int> alpha;

    for (char i = 'A'; i <= 'Z'; ++i)
        alpha.emplace(std::pair<char, int>(i,0));

    return alpha;
}
