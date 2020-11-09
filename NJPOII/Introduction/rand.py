# zadanie 3: Zmodyfikuj kod związany z losowaniem liczb z przedziału od 1 do 10, tak aby obliczał przybliżoną wartość oczekiwaną obliczoną jako średnią (z prób). Uśrednienie ma nastąpić 1m razy (milion razy).

from random import Random

rand = Random()
loopCount=1
randSum=0
amountOfDraws = 1000000
while True:
    if(loopCount == x):
        break
    loopCount = loopCount+1
    randSum = randSum + rand.randint(1, 10)
print("Avg:",randSum/amountOfDraws)