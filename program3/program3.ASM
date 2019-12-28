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

				;3Fh czytanie :: INT21h
        mov bx,ax			;file handle (A file handle is an integer value which is used to address an open file)
        mov dx,offset bufor		;odczyt z pliku // w buforze bedzie linia pliku // DS:DX (addres of buffer to receive data)
        mov ah,3Fh   			;czyta cx bajtow z pliku ktorego hendle jest w BX
        mov cx,100
        int 21h

        mov si,offset bufor		;mov ah,09h		;\
					;mov dx,offset bufor	;-| Wyswietlenie to, co napisane w pliku	
					;int 21h		;/
	graj:
        	xor ax,ax

        	lodsb			;wczytanie podzielnika (nuty)
        	sub ax,41h
        	cmp ax,23  		;sprawdzenie konca nut
        	jz koniec

        	mov bx,ax
        	shl bx,1
        	mov bx,nuty[bx]

        	xor ax,ax
        	lodsb       		;wczytanie otawy
        	sub ax,30h

        	mov cx,ax
        	shr bx,cl

        	mov ax,bx		;wpisuje odpowiedni podzielnik do L2
        	mov dx,0042h
        	out dx,al
        	mov al,ah
       	 	out dx,al

        	xor ax,ax
        	lodsb        		;wczytanie dlugosci
        	sub ax,30h
        	mov cx,ax
        	xor dx,dx

       	 	mov dx,0061h		;wlaczenie glosnika
        	in al,dx
        	or al,00000011b
        	out dx,al


       	 	mov ah,86h		;odegranie dzwieku
        	int 15h


        	mov dx,0061h		;wylaczenie glosnika
        	in al,dx
        	and al,11111100b
        	out dx,al

        jmp graj


	koniec: 			;zakonczenie poprawne
	        mov ah,4ch 
		mov al,zero
	        int 21h

	koniec2:			;zakonczenie bledne bez parametru wywolania
	        mov al,1
	        mov ah,4ch 
	        int 21h

	error:  mov ah,09h
	        mov dx,offset blad
	        int 21h
	        jmp koniec2

Progr   ends

dane    segment

	bufor db 100 dup(?)
	blad db 'Brak parametru wywolania programu !$'

	;       A    pauz  C     D    E     F    G     H
	nuty dw 21454,1,35757,31891,28780,26818,24081,19032

	zero equ 0

dane    ends

stosik  segment

        dw 100h dup(?)
szczyt  dw 0

stosik  ends
        end start
