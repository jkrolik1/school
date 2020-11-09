# zadanie 4: Napisz algorytm obliczający kolejne liczby pierwsze dla zadanych wartości.

def primeNums(n,m):
    lista = []
    for i in range(n,m+1):
        prime = True
        for j in range(2,i):
            if i%j==0:
                prime = False
        if prime==True:
            lista.append(i)
    return lista
        
n = input("Prime numbers from: ")
m = input("Prime numbers to: ")
if (n.isnumeric() and m.isnumeric()):
    list2 = primeNums(int(n),int(m))              
    print(list2)
else:
    print("Run program again with correct numbers")