/*
== porównanie int
nie porównaniestring
nowa metoda touppercase tworzy nowy obiekt
== porownanie referencyjne dla int nie string
Integer aa = new Integer(13);

obiekt to player. ...


___________________________________________________________________________



System.in strmien wejściowy podpięty pod klawiaturę
Czeka na ENTER - kończymy linię

NIE WOLNO!!!
    DRY nie powtarzaj się
    Aby działało player.getName() na PlayerHuman trzeba by skopiować
NIE WOLNO!!!

Dziedziczenie - dziedziczy wszystko - extends a (rozszerza klase a)
Dziedcziczy również private
    
name = "aaaa" przekazywanie, ale nie pozwala na dostęp

Należy dodawać ręcznie konstruktory w nowej klasie

super - wyżej - zastępuje (this) - instancja klasy nadrzędnej

new służy do stworzenia obiektu

super(name) - zmusenie do wykonania konstruktora z parametrem

Konstruktory służą do inicjacji pól
Konstruktor wskazanie obiektu


------------------------------------------
        
        Player player;
        if(true)
            player = new Player();
        else
            player = new PlayerHuman();
        
to
        
Player player = new PlayerHuman();

---------------------------------------------



Polimorfizm

Player rodzic, PlayerHuman i PlayerComp rodzeństwo

abstract nie ma ciała, tworzymy w rodzicu, nigdy nie ma sie wykonac (public abstract in guess();)
+ trzeba oznaczyc klase jako abstrakcyjna (public abstract class Player(){})

Nowy typ gracza <-> nowa klasa z extends player
albo musi byc abstrakcyjna albo musi mieć guess!!!
w tej klasie:

    @Override
    public int guess(){
        return 3;
    }

Trzeba jeszcze dodać konstruktory



________________________________________________________________________________



Jeżeli setName będzie null lub pusty -> try catch

Wyjątek jest obiektem
rzucenie obiektu wyjątku
Java exception hierarchy https://www.benchresources.net/wp-content/uploads/2017/02/exception-hierarchy-in-java.png
    indexoutofbounds wyjscie poza tablice
http://java5tutor.info/images/exceptionhierarchy.jpg
Runtime exception -> illegalargumentexception

c jest kompilowany do kodu maszynowego
java jest kompilowany...
throw wyjście z klasy - main - maszyny wirtualnej
wm konczy ten proces
rzucenie wyjatku - cos sie stalo nie tak
throw leci cala droge wywolan

walidacja imienia
REGEX wyrazenia regularne   regex101.com
.
+
* - dowolna
^[a-zA-Z0-9~\.]{3,}$ -> a-z A-Z 0-9 ~ .



________________________________________________________________________________

lista - powiązane ze sobą elementy
trzeba pamietac poczatek listy
koniec ustawiony na null
nowy element dolaczamy na strzalkach
x->x->x->null
dostep - za kazdym razem od poczatku

List list new ArrayList(); - tablica dynamiczna
polacenie tavlicy i listy 
lista jest obiektem.
list.add można dodać typ obiekt-klasa;
Object - baza dla wszystkich klas w Javie

List list = new ArrayList();
        list.add("raz");
        list.add("dwa");
        list.add("trzy");
        System.out.print(list.toString());
Trzeba dodać importy - ikonka żarówki w net beans
















*/


