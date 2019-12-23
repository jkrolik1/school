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






























*/


