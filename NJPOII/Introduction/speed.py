# zadanie 1: Prześledź szybkość dodawania elementów do tablicy.

from random import Random
import time

elements = 2000000

rand = Random()
listOfNums = []

def addElementsToListByInsert(amountOfElements):
    for i in range(amountOfElements):
        listOfNums.insert(i,rand.randint(0,100))

def addElementsToListByAppend(amountOfElements):
    for i in range(amountOfElements):
        listOfNums.append(rand.randint(0,100))

start = time.time()
addElementsToListByInsert(elements)
end = time.time()
print("For insert function: ",end - start,"s")

start = time.time()
addElementsToListByAppend(elements)
end = time.time()
print("For append function: ",end - start,"s")