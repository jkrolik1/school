# zadanie 1 : Liczbę  𝜋  można obliczyć stosując metodę Monte Carlo. Polega ona na wielokrotnym obliczeniu nierówności: 𝑥2+𝑦2≤1

import random as rand
import math as m
    
def piMC(attempts):
    counter = fulfills = 0
    while not attempts==counter:
        x = rand.uniform(0,1)**2
        y = rand.uniform(0,1)**2
        if (m.sqrt(x + y) <= 1.0):
            fulfills += 1
        counter+=1
    return (fulfills*4) / attempts

print("Pi: ",m.pi)

score = piMC(250000);
print("For 250 000 attempts:")
print('\t',score)
print('\t',"Accuracy: ",(round(abs(score-m.pi),4)))

score = piMC(100000);
print("For 100 000 attempts:")
print('\t',score)
print('\t',"Accuracy: ",(round(abs(score-m.pi),4)))

score = piMC(10000);
print("For 10 000 attempts:")
print('\t',score)
print('\t',"Accuracy: ",(round(abs(score-m.pi),4)))

score = piMC(1000);
print("For 1 000 attempts:")
print('\t',score)
print('\t',"Accuracy: ",(round(abs(score-m.pi),4)))

score = piMC(100);
print("For 100 attempts:")
print('\t',score)
print('\t',"Accuracy: ",(round(abs(score-m.pi),4)))