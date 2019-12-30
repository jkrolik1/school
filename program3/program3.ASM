							;podzielniki czestotliwosci	;1193180Hz = 1.19MHz to czestotliwosc wysylana do licznikow (czestotliwosc zegara licznikow (clk))
DzC 	equ 570						;1193180Hz/2093Hz		;2093Hz to Hz C w oktawie 7
DzD 	equ 507						;1193180Hz/2349Hz		;2349Hz to Hz D w oktawie 7		
DzE 	equ 452						;1193180Hz/2637Hz		;2637Hz to Hz E w oktawie 7	
DzF 	equ 427						;1193180Hz/2794Hz		;2794Hz to Hz F w oktawie 7	
DzG 	equ 380						;1193180Hz/3139Hz		;3139Hz to Hz G w oktawie 7	
DzA 	equ 339						;1193180Hz/3520Hz		;3520Hz to Hz A w oktawie 7	
DzH 	equ 302						;1193180Hz/3951Hz		;3951Hz to Hz H w oktawie 7	
DzP 	equ 100						;1193180Hz/11931.80Hz --- dzwiek bardzo wysoki, glosnik go nie zagra, dlatego bd cisza-pauza (PAUZA MA BYĆ POSTACI P7x, gdzie x to jej dlugosc tak jak nut)
DzCis	equ 538						;1193180Hz/2217Hz
DzDis	equ 479						;1193180Hz/2489Hz
DzEis	equ 437						;1193180Hz/2714Hz
DzFis	equ 403						;1193180Hz/2960Hz
DzGis	equ 359						;1193180Hz/3322Hz
DzAis	equ 320						;1193180Hz/3729Hz
							;1: C D E F G A H (nazwa dzwieku)
							;2: 1 2 3 4 5 6 7 (oktawa)
							;3: 1 (cala nuta) 2 (pol nuta) 4 (cwierc nuta) 8 (osemka)	  (dlugosc)	
Progr   segment
	assume cs:Progr,ds:dane,ss:stosik


start:  mov ax,dane					;adresacja segmentow
        mov ds,ax
        mov ax,stosik
        mov ss,ax
        mov sp,offset szczyt

        mov ah,62h					;pobranie adresu PSP (pobieranie zawartości wiersza poleceń)
        int 21h
        mov es,bx

        xor bx,bx					;sprawdzenie dlugosci parametru		//http://fysnet.net/cmndline.htm
        mov bl,es:[80h]					;80h w PSP to długość 			//https://en.wikipedia.org/wiki/Program_Segment_Prefix
        cmp bx,0					;sprawdzenie czy wpisano parametr
        jz error
        add bx,81h					;dostanie się do parametru (Unformatted Parm Area) DOSfunctions>62h>PSP ?????
        mov byte ptr es:[bx],0				;dopisanie 0 na koncu lancucha
				
						;3Dh otwieranie :: INT21h			//http://spike.scu.edu.au/~barry/interrupts.html#ah3d
        mov ah,3Dh   					;otwarcie pliku (DS:DX adres sciezki//nazwa pliku) (file handle w AX)
        mov al,0     					;acces mode (0=read, 1=write, 2=rw)
        mov dx,82h					;nazwa pliku od 82h w PSP
         push ds
          mov cx,es
          mov ds,cx					;z es do ds, poniewaz int21h ah3Dh dziala dla DS:DX
        int 21h						;tutaj otwiera sie plik
         pop ds

	mov filehandle,ax				;zapisujemy filehandle do osobnej zmiennej, poniewaz bd nam potem potrzebna do zamkniecia pliku

						;3Fh czytanie :: INT21h
        mov bx,filehandle				;file handle (A file handle is an integer value which is used to address an open file)
        mov dx,offset bufor				;odczyt z pliku // w buforze bedzie linia pliku // DS:DX (addres of buffer to receive data)
        mov ah,3Fh   					;czyta cx bajtow z pliku ktorego hendle jest w BX
        mov cx,300
        int 21h

        mov si,offset bufor				;mov ah,09h		;\
							;mov dx,offset bufor	;-| Wyswietlenie to, co napisane w pliku	
							;int 21h		;/
	graj:
        	  xor ax,ax
							;LODSB - transfers the byte from DS:SI into AL and increments or decrements SI), Si jest inkrementowany u nas o jeden, dlatego ze flaga kierunku = 0, LODSW/LODSB - odczytania parametrow dzwieku 
        	lodsb		        		;wczytanie podzielnika (nuty)
							;w AL znajduje sie dany (SI-ty) znak z bufora, czyli z linii pliku
        	  jmp sprnazwedzwieku  		;musi sprawdzic czy to jest c d e f g a h c itd..	


	          grajdalej:				;powrot z danej etykiety. W bx mamy podzielniki z poczatku programu, ktore trzeba przeksztalcic na prawidlowe oktawy
        	    xor ax,ax

        	lodsb       				;wczytanie oktawy, w al znajduje sie numer oktawy, czyli cyfra po kazdej literce w pliku (buforze)

        	  sub ax,30h				;mapujemy, zeby otrzymac numer oktawy - fizyczna cyfre, 30h to 0 hex
		  jmp sproktawy
		
		  wyliczenie:				;powrot z danej etykiety. Teraz w cl mamy cyfre, ktora mowi ile razy mamy pomnozyc przez 2 nasz podzielnik z poczatku programu

        	  shl bx,cl				;tyle razy mnozyc przez 2 dany dzwiek z poczatku programu ile mamy wybrana oktawe, shl-przesuwanie binarne w lewo (mnozenie przez 2)
							;np mamy C61 to 6 to nr oktawy. Wtedy dostaniemy w cl jedynke. Oznacza to ze raz mnozymy DzC razy 2 i dostajemy oktawe 6. 570 * 2 = 1140. Spr: 1193180Hz/1047Hz tj. 1139.6, czyli 1140!!!       	  
		  mov podzielnik,bx			;otrzymany FINALNY podzielnik wpisujemy do zmiennej	

        	  xor ax,ax	

        	lodsb        				;wczytanie dlugosci

        	  sub ax,30h				;znowu mapowanie, aby uzyskac dlugosc w cyfrze
        	  mov dlugosc,ax			
        	  
		  call wgraniepodzielnika
		  call speaker				;przejscie do procedury (call nie pokazuje nigdy kominikatu outofrange)

		  cmp dlugosc,1				;takie dlugosci trzeba podac na 3 miejscu w kazdej strukturze dzwieku
		  je cala
		  cmp dlugosc,2
		  je pol
		  cmp dlugosc,4
		  je cwierc
		  cmp dlugosc,8
		  je osemka  			

		inna:
		  call speaker2

        jmp graj


	error:  
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad
	        int 21h
		jmp czekaj

	koniec: 			
		xor ax,ax				;ZAMKNIECIE PLIKU!!!
		mov bx,filehandle		
		mov ah,3Eh
		int 21h

		xor ax,ax				;zakonczenie poprawne
	        mov ah,4ch 
		mov al,1
	        int 21h

	koniec2:					;zakonczenie bledne bez parametru wywolania // tutaj nie trzebaq zamykac pliku, bo go nie otworzono
	        mov al,1		
	        mov ah,4ch 
	        int 21h

	czekaj:						;jesli jest komunikat o bledzie czeka na wcisniecie klawisza
                mov ah,0bh				;usluga 0bh przerwania dosowego 21h
                int 21h	
                cmp al,0				;wynik funkcji w al (0 - no character available)
                je  czekaj
		jmp koniec2

	cala:
		push dx
		push cx
		mov cx,16
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna
	pol:
		push dx
		push cx
		mov cx,8
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna
	cwierc:
		push dx
		push cx
		mov cx,4
		mov dx,65535;
		mov ah,86h
		int 15h
		pop cx
		pop dx
		jmp inna
	osemka:
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

		;jmp error3	


	oktawa7:
		mov cl,0
		jmp wyliczenie
	oktawa6:
		mov cl,1
		jmp wyliczenie
	oktawa5:
		mov cl,2
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
		xor ax,ax				;ZAMKNIECIE PLIKU!!!
		mov bx,filehandle		
		mov ah,3Eh
		int 21h

		xor ax,ax
		xor dx,dx 
		mov ah,09h				;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad2
	        int 21h
		jmp czekaj


	speaker proc					;wlaczenie glosnika
       	 						;61hz adres rejestru wł i wył głośnika (adres bazowy protow A,B,C - 60hz)
        	  in al,61h;
		  or al,00000011b;
		  out 61h,al;
		ret					;powrot z procedury
		speaker endp


	wgraniepodzielnika proc
		  xor ax,ax
		  mov ax,podzielnik			;wgranie nuty (podzielnika)
		  out 42h,al
		  mov al,ah
		  out 42h,al
		ret
		wgraniepodzielnika endp

	
	speaker2 proc					;wylaczenie glosnika
		  in al,61h;
		  and al,11111100b;
		  out 61h,al;
		ret
		speaker2 endp
	


Progr   ends

dane    segment

	bufor		db 	300 dup(?)
	blad 		db 	'Cos poszlo nie tak! Sprobuj ponownie z nazwa: program.exe dzwiek.txt$'
	blad2		db	'Nieprawidlowa nazwa dzwieku w pliku tekstowym!!!$'
	filehandle 	dw 	0
	podzielnik      dw      0
	dlugosc		dw	0

dane    ends

stosik  segment

        dw 100h dup(?)
szczyt  dw 0

stosik  ends
        end start
