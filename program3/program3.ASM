							;podzielniki czestotliwosci	;1193180Hz = 1.19MHz to czestotliwosc wysylana do licznikow (czestotliwosc zegara licznikow (clk))
DzC 	equ 570						;1193180Hz/2093Hz		;2093Hz to Hz C w oktawie 7
DzD 	equ 507						;1193180Hz/2349Hz		;2349Hz to Hz D w oktawie 7		
DzE 	equ 452						;1193180Hz/2637Hz		;2637Hz to Hz E w oktawie 7	
DzF 	equ 427						;1193180Hz/2794Hz		;2794Hz to Hz F w oktawie 7	
DzG 	equ 380						;1193180Hz/3139Hz		;3139Hz to Hz G w oktawie 7	
DzA 	equ 339						;1193180Hz/3520Hz		;3520Hz to Hz A w oktawie 7	
DzH 	equ 302						;1193180Hz/3951Hz		;3951Hz to Hz H w oktawie 7	
DzP 	equ 100						;1193180Hz/11931.80Hz --- dzwiek bardzo wysoki, glosnik go nie zagra, dlatego bd cisza-pauza (PAUZA MA BYĆ POSTACI P7x, gdzie x to jej dlugosc tak jak nut)
DzCis	equ 538						;1193180Hz/2217Hz		;2217Hz to Hz Cis w oktawie 7
DzDis	equ 479						;1193180Hz/2489Hz		;2489Hz to Hz Dis w oktawie 7
DzEis	equ 437						;1193180Hz/2714Hz		;2714Hz to Hz Eis w oktawie 7
DzFis	equ 403						;1193180Hz/2960Hz		;2960Hz to Hz Fis w oktawie 7 
DzGis	equ 359						;1193180Hz/3322Hz		;3322Hz to Hz Gis w oktawie 7
DzAis	equ 320						;1193180Hz/3729Hz		;3729Hz to Hz Ais w oktawie 7
							;equ - deklarowanie stalej // equ jest pseudooperacją, która służy do przypisania nazw fizycznym danym
							;1znak: C D E F G A H c d e f g a (p)(nazwa dzwieku)
							;2znak: 1 2 3 4 5 6 7 (oktawa)
Progr   segment						;3znak: 1 (cala nuta) 2 (pol nuta) 4 (cwierc nuta) 8 (osemka)	  (dlugosc) {nie użyłem kropki(przedłużenie o polowe), ktorą da się wywołać przez ponowne wywołanie polowy danego dźwięku - wtedy powstaje 1,5 danego dźwięku} 
	assume cs:Progr,ds:dane,ss:stosik


start:  mov ax,dane					;adresacja segmentow
        mov ds,ax
        mov ax,stosik
        mov ss,ax
        mov sp,offset szczyt

        mov ah,62h					;pobranie adresu PSP (pobieranie zawartości wiersza poleceń)-program segment prefix
        int 21h						;in BX the address of the PSP for the program that is currently running
        mov es,bx

        xor bx,bx					;sprawdzenie dlugosci parametru		//http://fysnet.net/cmndline.htm
        mov bl,es:[80h]					;80h w PSP to długość 			//https://en.wikipedia.org/wiki/Program_Segment_Prefix
        cmp bx,0					;sprawdzenie czy wpisano parametr
        jz error                                        ;https://stackoverflow.com/questions/42920244/assembler-save-arguments-from-psp-dosbox
        add bx,81h					;dodanie 81h do dlugosci - dostajemy sie na koniec psp. 81h - command tail 
        mov byte ptr es:[bx],0				;dopisanie 0 na koncu lancucha (zeby wiadomo bylo gdzie koniec - tak jak w jezyku C)
			
						;3Dh otwieranie :: INT21h			//http://spike.scu.edu.au/~barry/interrupts.html#ah3d
        mov ah,3Dh   					;otwarcie pliku (DS:DX adres sciezki//nazwa pliku) (file handle w AX)
        mov al,0     					;acces mode (0=read, 1=write, 2=rw)
        mov dx,82h					;nazwa pliku od 82h w PSP, DS:DX points to an ASCIIZ string in the form "d:\path\filespec"
         push ds
          mov cx,es
          mov ds,cx					;z es do ds, poniewaz int21h ah3Dh dziala dla DS:DX
          int 21h					;tutaj otwiera sie plik
         pop ds

	mov filehandle,ax				;zapisujemy filehandle do osobnej zmiennej, poniewaz bd nam potem potrzebna do zamkniecia pliku
							;When you open a file, DOS passes back a 16-bit value called a file handle.  Thereafter, when you read, write, seek a position, or close the file, you refer to it by its handle

	graj:					       ;petla 'graj' - gra dany dźwięk (kolejne trzy znaki z pliku)
		call czytanie				;wywaloanie procedury, ktorej zadaniem jest czytanie z pliku trzech znaków
        	  xor ax,ax
							
		mov al,bufor(0)				;wpisanie do al pierwszego znaku bufora - literka
        	  jmp sprnazwedzwieku  			;sprawdzenie pierwszych znaków każdego dźwięku - literki	
	          grajdalej:				
        	    xor ax,ax

        	mov al,bufor(1)      			;drugi znak bufora - nr oktawy				
        	  sub ax,30h				;"mapowanie" tego znaku. Odejmujemy to co wczytaliśmy od 0 i dostajemy cyfrę. sub :: ax = ax - 30h				
		  jmp sproktawy				;walidacja oktawy
		  wyliczenie:				
        	    shl bx,cl				;przesuwanie binarne w lewo - mnożenie razy 2. Mnożymy nasz podzielnik z początku programu tyle razy pzez 2 ile razy jest w cl			       	  
		    mov podzielnik,bx			;otrzymany finalny podzielnik wpisujemy do zadeklarowanej (16bitowej) zmiennej, ponieważ będziemy go umieszczać w OUT L2
        	    xor ax,ax	

        	mov al,bufor(2)        			;wczytanie ostatniego znaku z dźwięku	
        	  sub ax,30h				;mapowanie aby otrzymać cyfrę
        	  mov dlugosc,ax			
        	  
		  call wgraniepodzielnika		
		  call speaker				;wlaczenie glosnika

		  cmp dlugosc,1				;porownanie 3 znakow kazdego dzwieku (dlugosc) z 1
		  je cala
		  cmp dlugosc,2
		  je pol
		  cmp dlugosc,4
		  je cwierc
		  cmp dlugosc,8
		  je osemka  			
		  jmp error4				;jesli inna dlugosc
		
		inna:
		  call speaker2				;wylaczenie glosnika

        jmp graj


	error:  
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad
	        int 21h
		jmp czekaj

	koniec: 			
		call zamkpliku

		xor ax,ax				;zakonczenie poprawne
	        mov ah,4ch 
		mov al,1
	        int 21h

	koniec2:					;zakonczenie bledne bez parametru wywolania // tutaj nie trzebaq zamykac pliku, bo go nie otworzono
	        mov al,1				;w al jest exit code
	        mov ah,4ch 
	        int 21h

	czekaj:						;jesli jest komunikat o bledzie czeka na wcisniecie klawisza
                mov ah,0bh				;usluga 0bh przerwania dosowego 21h - dostanie to co wpisano aktualnie // 0 - nic nie wpisano
                int 21h					
                cmp al,0				;wynik funkcji w al (0 - no character available)
                je  czekaj
		jmp koniec2

	cala:						
		push dx					;odlozenie dx i cx na stosie
		push cx
		mov cx,16				;szesnascie interwalow - wywolan int 15h uslugi 86h. 
		mov dx,65535				;zatrzymanie programu na dany czas (przy czym glosnik jest wlaczony i gra)
		mov ah,86h				;usługa 86h przerwania int 15h - odmierzenie czzsu w programie
		int 15h
		pop cx					;sciaganie cx i dx ze stosu / odwrotna kolejnosc niz przy odkladaniu
		pop dx
		jmp inna				;powrot do glownej petli 'graj'
	pol:
		push dx
		push cx
		mov cx,8				;opóźnienie ok 500ms (0,5s)
		mov dx,65535				;CX is high word, DX is low word
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna
	cwierc:						;opóźnienie 262ms
		push dx
		push cx
		mov cx,4
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna
	osemka:						;opóźnienie 131ms
		push dx
		push cx
		mov cx,2
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna

	sprnazwedzwieku:  
		cmp al,'^'				;wymyslony koniec melodii (nut)
		je koniec
		cmp al,'C'
		je do
		cmp al,'D'
		je re
		cmp al,'E'
		je mi
		cmp al,'F'
		je fa
		cmp al,'G'
		je soll
		cmp al,'A'
		je la
		cmp al,'H'
		je sii

		cmp al,'c'
		je cis
		cmp al,'d'
		je dis
		cmp al,'e'
		je eis
		cmp al,'f'
		je fis
		cmp al,'g'
		je gis
		cmp al,'a'
		je ais

		cmp al,'P'
		je pauza

		jmp error2


	do: 
		mov bx,DzC				;wpisuje podzielniki z 7 oktaw z poczatku programu
		jmp grajdalej
	re: 
		mov bx,DzD
		jmp grajdalej
	mi: 
		mov bx,DzE
		jmp grajdalej
	fa: 
		mov bx,DzF
		jmp grajdalej
	soll: 
		mov bx,DzG
		jmp grajdalej
	la: 
		mov bx,DzA
		jmp grajdalej
	sii: 
		mov bx,DzH
		jmp grajdalej

	cis: 
		mov bx,DzCis
		jmp grajdalej
	dis: 
		mov bx,DzDis
		jmp grajdalej
	eis: 
		mov bx,DzEis
		jmp grajdalej
	fis: 
		mov bx,DzFis
		jmp grajdalej
	gis: 
		mov bx,DzGis
		jmp grajdalej
	ais: 
		mov bx,DzAis
		jmp grajdalej

	pauza: 
		mov bx,DzP
		jmp grajdalej



	sproktawy:					;przechodzimy tutaj, aby utworzyc odpowiedni podzielnik na podstawie zmiennych z poczatku programu
		cmp ax,7 
		je oktawa7				;je - equals, sa rowne, cmp to odejmowanie, ktore nie zmienia flag
		cmp ax,6
		je oktawa6	
		cmp ax,5
		je oktawa5
		cmp ax,4
		je oktawa4
		cmp ax,3
		je oktawa3
		cmp ax,2
		je oktawa2
		cmp ax,1
		je oktawa1

		jmp error3				; jezeli to jakis inny znak/numer


	oktawa7:
		mov cl,0				; !!! do cl wpisujemy wartość ile razy ma mnożyć podzilnik razy 2, żeby wyszedł nam podzielnik dla danej oktawy !!!
		jmp wyliczenie				; dla 7mej oktawy nie musimy mnożyć bo mamy ten podzielnik już domyślnie wyliczony na początku programu
	oktawa6:
		mov cl,1				; aby przejść do oktawy 6 należy nasz podzielnik pomnożyć razy 2 tylko jeden raz
		jmp wyliczenie
	oktawa5:
		mov cl,2				;np mamy C61 to 6 to nr oktawy. Wtedy dostaniemy w cl jedynke. Oznacza to ze raz mnozymy DzC razy 2 i dostajemy oktawe 6. 570 * 2 = 1140. Spr: 1193180Hz/1047Hz tj. 1139.6, czyli 1140!!!       	  
		jmp wyliczenie
	oktawa4:
		mov cl,3
		jmp wyliczenie
	oktawa3:
		mov cl,4
		jmp wyliczenie
	oktawa2:
		mov cl,5
		jmp wyliczenie
	oktawa1:
		mov cl,6
		jmp wyliczenie
	

	error2: 
		call zamkpliku

		xor ax,ax
		xor dx,dx 
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad2
	        int 21h
		jmp czekaj

	error3: 
		call zamkpliku

		xor ax,ax
		xor dx,dx 
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad3
	        int 21h
		jmp czekaj

	error4: 
		call speaker2
		call zamkpliku

		xor ax,ax
		xor dx,dx 
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad4
	        int 21h
		jmp czekaj


	speaker proc					;wlaczenie glosnika
       	 						;61hz adres rejestru wł i wył głośnika PORT B (adres bazowy protow A,B,C - 60hz)
        	  in al,61h				 ;przeczytanie stanu portu B do akumulatora
		  or al,00000011b			 ;ustawienie dwoch najmlodszych bitow na 1 (OR dodawanie); 00000011 (jedynkami muszą być B0 i B1)
		  out 61h,al				 ;wpisanie do adresu portu B - al
		ret					;powrot z procedury
		speaker endp


	wgraniepodzielnika proc
		  xor ax,ax
		  mov ax,podzielnik			;utworzony podzielnik wpisujemy do akumulatora
		  out 42h,al				;wgrywamy młodszą część podzielnika do licznika L2 (adres licznika L2 - 42H). Wpisanie przez instrukcję OUT x,y , która potrzebuje adres pod który ma wpisać(x) i co ma wpisać(y) 
		  mov al,ah				;przepisujemy starszą ax do młoszej (al). Operacja OUT tylko AL!
		  out 42h,al				;wgranie starszej części podzielnika do licznika L2
		ret					;Powrót z procedury do tego samego miejsca, co została wywołana
		wgraniepodzielnika endp

	
	speaker2 proc					;wylaczenie glosnika
		  in al,61h				 ;przeczytanie stanu portuB
		  and al,11111100b			 ;maskowanie, mnozenie (and). Tam gdzie 0 to ustawia 0, tam gdzie 1 zostawia // B0 i B1 osyawia na 0 - wył głośnik
		  out 61h,al				 ;zapisanie stanu do portu B
		ret
		speaker2 endp
	

	zamkpliku proc
		  xor ax,ax				;ZAMKNIECIE PLIKU!!!
		  mov bx,filehandle		
		  mov ah,3Eh
		  int 21h
		ret					;powrot z procedury
		zamkpliku endp

	czytanie proc					;czytanie kolejnych elementow pliku
 		  mov bx,filehandle				;file handle (A file handle is an integer value which is used to address an open file)
        	  mov dx,offset bufor				;odczyt z pliku // w buforze bedzie linia pliku // DS:DX (addres of buffer to receive data)
        	  mov ah,3Fh   					;czyta cx bajtow z pliku ktorego handle jest w BX
        	  mov cx,3
        	  int 21h

		ret
		czytanie endp


Progr   ends

dane    segment

	bufor		db	3 dup(0)			;tutaj sa kazdorazowe 3 znaki przeczytane z pliku			
	blad 		db 	'Cos poszlo nie tak! Sprobuj ponownie z nazwa: program.exe dzwiek.txt$'
	blad2		db	'Nieprawidlowa nazwa dzwieku w pliku tekstowym!!! Dozwolone C D E F G A H c d e f g a p na pierwszym miejscu kazdej notacji.$'
	blad3		db	'Nieprawidlowy numer oktawy!!! Dozwolony od 1 do 7 na drugim miejscu kazdej notacji.$'
	blad4		db	'Nieprawidlowa dlugosc dzwieku! Nalezy wpisac 1, 2, 4 lub 8 na trzecim miejscu kazdej notacji.$'
	filehandle 	dw 	0
	podzielnik      dw      0
	dlugosc		dw	0

dane    ends

stosik  segment

        dw 100h dup(?)
szczyt  dw 0

stosik  ends
        end start


; OPISY
;
; 3Dh - otwarcie pliu		// int 21h
; 3Eh - zamkniecie pliku	// int 21h
; 3Fh - czytanie pliku		// int 21h
;
; wykorzystuje dwa układy: transmisji równoległej - 8255
;			   zegara-licznika 8253 (licznik 2, tryb 2 - dzwięk z beepera (programowalny dzielnik częstotliwości), tryb 3 - generowanie fali prostokątnej - tutaj chcemy o wypełnieniu 1/2 - 50% 1 logiczna 50% 0 logiczne)
; dźwięk - wibrujące powietrze docierające do aparatu słuchu i pobudzające z odp częstotliwością
; membrana głośnika musi wydać odpowiednią częstotliwość. Uzyskanie ciśnienia akustycznego o odpowiedniej częstotliwości
; kształt przebiegu u nas - sinusoidalny, nie mamy na niego wpływu
; człowiek słyszy częstotliwości ~ 25Hz do 16kHz (zależy od wieku) 10kHz to 10 000 Hz
; beeper do 5-6kHz
; zastosowanie beepera: sygnalizacja błędów, które sygnalizowały procedury POST - power on self test - spr prawidłowości działania komponentów komputera
; notacja melodii - pięciolinia. Określony nazwy dźwięków c d e f g a h -> zapis muzyczny
; pełne tony c d e f g a h pół tony cis dis ... półtony - czarne klawisze - średnia hz sąsiegnich dźwięków
; długości: cała nuta, pół nuta, ćwierć nuta, ósemka...
; .exe - motor wygrywający melodię. Jego parametr .txt - zapis melodii
; paramtry dźwięku w .txt - 1znak to nazwa dźwięku, 2znak to numer oktawy, 3znak to długość dźwięku
; u nas znak końca melodii '^'
;
; połącznie beep sound - https://stackoverflow.com/questions/43996835/assembly-8086-dosbox-how-to-produce-beep-sound
; 8255 - czytanie konfiguracji plyty glownej, zamiana informacji szeregowej z klawiatury na rownolegla - port A
; 8255 ma 24 wyjscia, 3 porty
;	tryb 0 - 3 porty - A B C
;	tryb 1, 2 - wykorzystuje bramy (port a + 4 bity portu c)
; na plycie glownej pracuja wszytstkie 3 porty 8255. Porty mają po 8 bitów (razem 24 wyjścia)
; port A - wyjście 
; port B - port wyjściowy - ustawianie 
; port C - wejściowy
;
; 8253 - ma 3 liczniki, kazdy z osobna mozna tak samo programować
; oznaczenia liczników L0, L1, L2. Każde z liczników ma wyjście OUT, na którym po określonej l impulsów zmienia się stan lub na stale generowane jest przerwanie
; każdy z liczników może być 4 pozycyjnym licznikiem BCD - odlicza w dół do 0 LUB może być licznikiem 16bitowym (poj 65535 - max) odliczającym w dół
; tryb 3 - tryb fali prostokątnej
; wejścia wszystkich trzech liczników CLK 0 1 i 2 zasilane są tą samą częstotliwością 1.19MhZ ~ 1193180Hz
; zastosowanie liczników 8253:
; 	licznik L0 - odświeżanie pamięci, impulsy odświeżania pamięci dynamicznej
; 	licznik L1 - odmierzanie interwałów czasowych dla zegara czasu rzeczywistego
; 	licznik L2 - obsluga beepera
;
; połączenie całego układu:
;	- wejścia clk liczników z 8253 są podłączone do 1.19Mhz
;	- !!! OUT2 Licznika L2 jest podłączony do bramki AND (wej)
;	- !!! port B układu 8255 podłączony jest do wejścia bramki AND (jedynka logiczna tutaj włącza dźwięk --- BIT B0)
;	- !!! port B BIT B1 - GATE2 zatrzymanie, nie wygeneryjemy częstotliwości dla 0 logicznego, musi byc 1 logiczna aby grało
;	- 	(dodatkowe / nieistotne) port C układu 8255 podłączony jest do wyjścia bramki przed układem wygładzającym. Ta linia odpytuje czy głośnik pracuje --- BIT C4
;	- wyjscie bramki AND - podłączony jest układ RC 'wygładzający' impulsy do sinusoidy oraz do tego układu podłączony jest GŁOŚNIK  
; naistotniejsze bity B0 i B1 i to, co wpiszemy do L2
; L2 standardowo po włączeniu zasilania zaprogramowany jest do generowania pisków z głośnika
; Możemy skonfigurować jeszcze raz L2 (8253), ale nie WOLNO ruszać portów A, B, C (8255)
; PODZIELNIK - służy do określenia częstotliwości wyjścia (OUT 2 !)
; Bity B0 i B1 trzeba ustawić na '0' logiczne na koniec programu - wyłącznie speakera
; 
; instrukcje IN, OUT są dla układów zewnętrznych (np: bity B0 i B1 portu B 8255)
; IN - przeczytanie stanu
; OUT - ustawienie stanu // zapisanie
; 
; dla licznika L2 posługujemy się instrukcją OUT - wprowadzenie wewnętrznego podzielnika, przez który będzie dzielona wewnętrzna częstotliwość 1.19MHz
; 
; wgrywanie podzielnika do L2:
; maskymalnie można osiągnąć 18Hz - dla nas za nisko!
; częstotliwość_dźwięku = 1193180Hz / podzielnik
; podzielnik = 1193180Hz / częstotliwość_dźwięku
; np jeśli chcemy uzyskać 1000Hz to podzielnik = 1193180Hz / 1000Hz. I podzielnik wpisujemy do licznika L2.
; wgranie podzielnika||wpisanie podzielnika do licznika: rozbicie na młodszy i starszy bajt
; adres bazowy układu zegara licznika (40H)
;	40H - adres L0
;	41H - adres L1
;	42H - adres L2
; np mamy C61 to 6 to nr oktawy. Wtedy dostaniemy w cl jedynke. Oznacza to ze raz mnozymy DzC razy 2 i dostajemy oktawe 6. 570 * 2 = 1140. Spr: 1193180Hz/1047Hz tj. 1139.6, czyli 1140!!!       	  
; 
; 60h - adres bazowy portów PA,PB,PC (8255)
; 61h - adres dla portu PB !!! - wł/wył głośnika
; 
; plik NUTY2.txt (moodle ak) - wypisane są wszystkie częstotliwości, które użyte są do wyliczania podzielników 
; dźwięki notowane z dokłądnością do 1Hz
; największa oktawa 7 posiada częstotliwości, które głośnik jeszcze jest w stanie przenieść (ostatnie)
; oktawa 7 jest najdokładnijesza - 4 miejsca rozwinięcia
; idealny dźwięk, używany do strojenia A
;
; 7 oktawa - oktawa odniesienie do liczenia innych dźwięków
; jesli chcemy oktawe 6 to podzielnik dla oktawy 7 trzeba pomnożyć razy 2, dla oktawy 5 - podzielnik = podzielnik * 2 * 2, dla 4 - podzielnik * 2 * 2 * 2
; 
; usługa 86h przerwania int 15h - odmierzenie czasu w programie
; 	po wpisaniu do cx, dx okreslonej liczby mikrosekund zatrzymuje dzialanie programu do odliczenia tej wartosci
;	potrzebujemy 1, 1/2, 1/4, 1/8
;	do dx maksymalna wartosc mov dx,65535 (mikro sekund)
;				 mov cx,0			//opoznienie okolo 65,5ms -> czas trwania nuty 1/16
;
;	mov dx,65535 || mov cx,1 --- czas trwania dla 1/8 nuty --- 65,5ms*2
;	półnuta 8 wywołań 86h int 15h
;
; włączenie głośnika:
; 	przeczytanie portu B: in al,61h
;	ustawienie bitów B0 i B1 na jedynki: or al,00000011b
;	wpisanie do portu B: out 61h,al
; wylaczenie glosnika:
;	przeczytanie stanu portu B: in al,61h
;	ustawienie B0 i B1 na 0 (wył): and al,11111100h
;	zapisanie spowrotem do portu B: out 61h,al
