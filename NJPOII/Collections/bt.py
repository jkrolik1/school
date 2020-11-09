# zadanie 4

# Drzewo binarne przy użyciu listy

x = input("Enter number of elements: ")
listL = x.split()
listL = list(map(int, listL))
listL.sort()
total = 2**((len(listL)-1).bit_length())
 
binaryTree = []
binaryTree.extend([0]*(total-1))
binaryTree.extend(listL)
binaryTree.extend([0]*(total-len(listL)))
 
total -= 2
stop = False

while not stop:
    if(total < 0):
        break
    binaryTree[total] = binaryTree[2*total+1] + binaryTree[2*total+2]
    total -= 1
 
print(binaryTree)