# zadanie 2: Dla  𝑘  kolejek zaimplementuj karuzelowy algorytm przydziału zadań.

from collections import deque

deq1 = deque(['A','B','C'])
deq2 = deque(['D','E'])
deq3 = deque(['F','y','1','31'])
deq4 = deque(['p'])
deq5 = deque(['q','w','e','r','t'])

def calcMaxLen(*args):
    sumLen = 0
    for arg in args:
        sumLen += len(arg)
    return sumLen
  
def roundRobin(*args2):
    maxLen = calcMaxLen(args2)
    deqx = deque()
    for i in range(maxLen):
        for arg2 in args2:    
            if(arg2):
                deqx.append(arg2.popleft())
    return deqx

print("Deque after round-robin: ",roundRobin(deq1,deq2,deq3,deq4,deq5))