# zadanie 3: Stwórz kolekcję książek zawierającą takie pola jak tytuł, gatunek, autor, isbn. Napisz trzy funkcje, (i) zapisującą kolekcję, (ii) odczytującą kolekcję, (iii) obliczająca statystykę wg. gatunku i autora.

# File :: "books.txt"


# Funkcja odczytująca kolekcje z pliku || użycie readBooks()
def readBooks():
    file = open("books.txt", "r")
    content = file.readlines()
    i = 1
    for x in content:
        print(i)
        words = x.split()
        print("  Title: ",words[0])
        print("  Genre: ",words[1])
        print("  Author: ",words[2])
        print("  ISBN: ",words[3])
        i += 1
    print('\n\n')
    
# Funkcja zapisująca (dopisująca) kolekcję do pliku || użycie addBook("xyz","abc","ijk",123)
def addBook(title,genre,author,isbn):
    file = open("books.txt", "r")
    content = file.readlines()
    stop = False
    for x in content:
        words = x.split()
        if(int(words[3]) == int(isbn)):
            stop = True
            break
    if not stop:
        file = open("books.txt", "a")
        file.write('\n')
        file.write(title.replace(" ", "_"))
        file.write(" ")
        file.write(genre.replace(" ", "_"))
        file.write(" ")
        file.write(author.replace(" ", "_"))
        file.write(" ")
        file.write(str(isbn))
        file.write(" ")
    if stop:
        print("Book with this ISBN already exists!")
    
# Funkcja wyświetlająca statystykę gatunków || użycie bookGenreStats()
def bookGenreStats():
    from collections import Counter
    deq = deque()
    file = open("books.txt", "r")
    content = file.readlines()
    for x in content:
        words = x.split()
        deq.append(words[1])
    counter = Counter(deq)
    print(sorted(counter.items(), key=lambda x: x[1]))
    print('\n\n')

# Funkcja wyświetlająca statystykę autorów || użycie bookAuthorStats()
def bookAuthorStats():
    from collections import OrderedDict
    d = {}
    file = open("books.txt", "r")
    content = file.readlines()
    for x in content:
        words = x.split()
        if words[2] in d:
            d[words[2]] += 1
        else:
            d[words[2]] = 1
    od = OrderedDict(sorted(d.items(), key=lambda x: x[1]))
    for i, (key, val) in enumerate(od.items()):
        print(f'{i+1}. {key:8} ----- {val}')
    print('\n\n')

readBooks()
bookGenreStats()
bookAuthorStats()