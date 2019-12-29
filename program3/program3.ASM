					;podzielniki czestotliwosci	;1193180Hz = 1.19MHz to czestotliwosc wysylana do licznikow (czestotliwosc zegara licznikow (clk))
DzC equ 36156				;1193180Hz/33Hz			;33Hz to Hz C w oktawie 1
DzD equ 32248				;1193180Hz/37Hz			;37Hz to Hz D w oktawie 1
DzE equ 29101				;1193180Hz/41Hz			;41Hz to Hz E w oktawie 1
DzF equ 27117				;1193180Hz/44Hz			;44Hz to Hz F w oktawie 1
DzG equ 24350				;1193180Hz/49Hz			;49Hz to Hz G w oktawie 1
DzA equ 21694				;1193180Hz/55Hz			;55Hz to Hz A w oktawie 1
DzH equ 19244				;1193180Hz/62Hz			;62Hz to Hz H w oktawie 1
DzP equ 100				;dzwiek bardzo wysoki, glosnik go nie zagra, dlatego bd cisza-pauza (PAUZA MA BYĆ POSTACI P1x, gdzie x to jej dlugosc tak jak nut)



Progr   segment
	assume cs:Progr,ds:dane,ss:stosik


start:  mov ax,dane			;adresacja segmentow
        mov ds,ax
        mov ax,stosik
        mov ss,ax
        mov sp,offset szczyt

        mov ah,62h			;pobranie adresu PSP (pobieranie zawartości wiersza poleceń)
        int 21h
        mov es,bx

        xor bx,bx			;sprawdzenie dlugosci parametru		//http://fysnet.net/cmndline.htm
        mov bl,es:[80h]			;80h w PSP to długość 			//https://en.wikipedia.org/wiki/Program_Segment_Prefix
        cmp bx,0			;sprawdzenie czy wpisano parametr
        jz error
        add bx,81h			;dostanie się do parametru (Unformatted Parm Area) DOSfunctions>62h>PSP ?????
        mov byte ptr es:[bx],0		;dopisanie 0 na koncu lancucha
				
				;3Dh otwieranie :: INT21h			//http://spike.scu.edu.au/~barry/interrupts.html#ah3d
        mov ah,3Dh   			;otwarcie pliku (DS:DX adres sciezki//nazwa pliku) (file handle w AX)
        mov al,0     			;acces mode (0=read, 1=write, 2=rw)
        mov dx,82h			;nazwa pliku od 82h w PSP
         push ds
          mov cx,es
          mov ds,cx			;z es do ds, poniewaz int21h ah3Dh dziala dla DS:DX
        int 21h				;tutaj otwiera sie plik
         pop ds

	mov filehandle,ax

				;3Fh czytanie :: INT21h
        mov bx,filehandle		;file handle (A file handle is an integer value which is used to address an open file)
        mov dx,offset bufor		;odczyt z pliku // w buforze bedzie linia pliku // DS:DX (addres of buffer to receive data)
        mov ah,3Fh   			;czyta cx bajtow z pliku ktorego hendle jest w BX
        mov cx,300
        int 21h

        mov si,offset bufor		;mov ah,09h		;\
					;mov dx,offset bufor	;-| Wyswietlenie to, co napisane w pliku	
					;int 21h		;/
	graj:
        	  xor ax,ax
					;LODSB - transfers the byte from DS:SI into AL and increments or decrements SI), Si jest inkrementowany u nas o jeden, dlatego ze flaga kierunku = 0, LODSW/LODSB - odczytania parametrow dzwieku 
        	lodsb		        ;wczytanie podzielnika (nuty)
					;w AL znajduje sie dany (SI-ty) znak z bufora, czyli z linii pliku
        	  jmp sprnazwedzwieku  	;musi sprawdzic czy to jest c d e f g a h c itd..	


	       grajdalej:

        	  xor ax,ax


        	lodsb       		;wczytanie oktawy

        	  sub ax,30h		;mapujemy, zeby otrzymac numer oktawy, 30h to 0 hex

        	  mov cx,ax
        	  shr bx,cl		;tyle razy dzielimy przez 2 dany dzwiek z poczatku programu ile mamy wybrana oktawe, shr-przesuwanie binarne w prawo (dzielenie przez 2)
					;wpisuje odpowiedni podzielnik do L2
        	  mov ax,bx		
        	  mov dx,0042h		;42h to adres licznika L2 (40Hz to adres bazowy ukladu zegara licznika oraz adres rejestru L0 || 41Hz - adres L1)
        	  out dx,al		;za pomoca instrukcji OUT wpisujemy odpowiedni podzielnikdo L2; dx - adr licznika 2, al - mlodzy bajt podzielnik ;OUT TYLKO AL!!!
        	  mov al,ah
       	 	  out dx,al

        	  xor ax,ax

        	lodsb        		;wczytanie dlugosci

        	  sub ax,30h		;znowu mapowanie, aby uzyskac dlugosc w cyfrze
        	  mov dlugosc,al
        	  
		  jmp sprjakadlug


		inna:
        	  mov dx,0061h		;wylaczenie glosnika
        	  in al,dx
        	  and al,11111100b
        	  out dx,al

        jmp graj


	error:  
		mov ah,09h		;display string, w ds:dx musi byc adres lancucha zawierajacy znacznik konca $
	        mov dx,offset blad
	        int 21h
		jmp czekaj

	koniec: 			
		xor ax,ax		;ZAMKNIECIE PLIKU!!!
		mov bx,filehandle		
		mov ah,3Eh
		int 21h

		xor ax,ax		;zakonczenie poprawne
	        mov ah,4ch 
		mov al,1
	        int 21h

	koniec2:			;zakonczenie bledne bez parametru wywolania // tutaj nie trzebaq zamykac pliku, bo go nie otworzono
	        mov al,1		
	        mov ah,4ch 
	        int 21h

	czekaj:				;jesli jest komunikat o bledzie czeka na wcisniecie klawisza
                mov ah,0bh		;usluga 0bh przerwania dosowego 21h
                int 21h
                cmp al,0		;wynik funkcji w al (0 - no character available)
                je  czekaj
		jmp koniec2

	sprnazwedzwieku:  
		cmp al,'^'
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
		cmp al,'P'
		je pauza

	do: 
		mov bx,DzC
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
	pauza: 
		mov bx,DzP
		jmp grajdalej

	
	sprjakadlug:
		call speaker
		cmp dlugosc,1
		je cala
		cmp dlugosc,2
		je pol
		cmp dlugosc,4
		je cwierc
		cmp dlugosc,8
		je osemka
		jmp inna

	cala:	
		call speaker
		push dx
		push cx
		mov cx,16
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		loop cala
		jmp inna
	pol:
		call speaker
		push dx
		push cx
		mov cx,8
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		loop pol
		jmp inna
	cwierc:
		call speaker
		push dx
		push cx
		mov cx,4
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		loop cwierc
		jmp inna
	osemka:
		call speaker
		push dx
		push cx
		mov cx,2
		mov dx,65535
		mov ah,86h
		int 15h
		pop cx
		pop dx
		loop osemka
		jmp inna

	speaker proc
		xor dx,dx
					;wlaczenie glosnika
       	 	mov dx,0061h		;61hz adres rejestru wł i wył głośnika (adres bazowy protow A,B,C - 60hz)
        	in al,dx
        	or al,00000011b
        	out dx,al
	ret
	speaker endp



Progr   ends

dane    segment

	bufor		db 	300 dup(?)
	blad 		db 	'Cos poszlo nie tak! Sprobuj ponownie z nazwa: program.exe dzwiek.txt$'
	filehandle 	dw 	0
	dlugosc		db	0

dane    ends

stosik  segment

        dw 100h dup(?)
szczyt  dw 0

stosik  ends
        end start
