# zadanie 6: Napisz program, który wyznacza odległość Levenshteina dla dwóch zadanych łańcuchów znaków.

def levenDist(s1,s2):
    if not s1: 
        return len(s2)
    if not s2:
        return len(s1)
    return min(levenDist(s1[1:], s2[1:]) + (s1[0] != s2[0]),
               levenDist(s1[1:], s2) + 1,
               levenDist(s1, s2[1:]) + 1)

str1 = input("Write first string: ")
str2 = input("Write second string: ")
print("Levenshtein distance for your strings: ", levenDist(str1,str2))