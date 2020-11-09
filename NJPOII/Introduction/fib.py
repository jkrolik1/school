# zadanie 5: Napisz program wyznaczający ciąg Fibonacciego dla 93 elementu (lub 93 iteracji) w najszybszym możliwym czasie.

def fib(n):
    a=0
    b=1
    for i in range(n):
        total = a+b
        b=a
        a=total
    return total

print(fib(93))