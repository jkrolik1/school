Progr           segment
                assume  cs:Progr, ds:dane, ss:stosik

start:          mov     ax,dane                 ;start zawsze taki sam
                mov     ds,ax
                mov     ax,stosik
                mov     ss,ax
                mov     sp,offset szczyt


                mov     dx,offset star
                mov     ah,09h
                int     21h

                mov     dx,offset welcome       ;powitanie
                mov     ah,09h
                int     21h


again:
                mov     dx,offset lancuch       ;podaj lancuch
                mov     ah,09h
                int     21h

                mov     ah,0ah                  ;podanie lancucha przez usera
                mov     dx,offset max
                int     21h


                mov     dl,len                  ;spr, czy wprowadzono cos w ogole
                cmp     dl,0
                jz      zero                    ;lub je - jesli rowne


                mov     dx,offset enter         ;offset-adres w pamieci, adres w ds (na dole)
                mov     ah,09h
                int     21h

                mov     cl,len                  ;len - dlugosc lancucha wpisana przez uzytk
                mov     bx,offset znaki

                xor     ax,ax


dziesietny:
                mul     dziesiec;               ;suma=suma*10
                jc      zaduzaliczba

                xor     dx,dx
                mov     dl,ds:[bx]              ;wybierz i-ty wpisany znak, adresacja posrednia, wybrany ity znak wpisz do dl

                sub     dl,'0'                  ;i-ty znak odjac 0, wynik w dl
                jc      nieliczba               ;jezeli i-ty znak < od 0 to nizej od 0 w ascii - nie moze byc
                                                ;w dl jest wart ze schematu blokowego, z mapowania wart:=znak-'0'
                cmp     dl,9                    ;porownuje nie odejmuje, nie zmienia zaw rejestrow
                ja      nieliczba               ;j above, wieksze od 9 w ascii
                                                ;ax to wynik (suma)

                add     ax,dx                   ;suma=suma+wart
                jc      zaduzaliczba

                inc     bx                      ;i=i+1 (znak:=znaki[i])
                        loop    dziesietny


                jmp     outofrange              ;out of range - to blad ktory wyskakuje jezeli damy te etykiety na samym dole

                        zaduzaliczba:

                                      mov       dx,offset error2
                                      mov       ah,09h
                                      int       21h
                                      jmp       again

                        nieliczba:

                                      mov       dx,offset error3
                                      mov       ah,09h
                                      int       21h
                                      jmp       again

                        zero:
                                      mov       dx,offset error1
                                      mov       ah,09h
                                      int       21h
                                      jmp       again



outofrange:


		mov 	suma,ax


;wyswietlenie w systemie dwojkowym

                xor     dx,dx
                mov     cx,16                           ;l iteracji petli, poniewaz l moze byc zapisana max na 16bitach
                mov     bx,offset znaki                 ;w rej bx jest offset znaki
                mov     ax,suma


binarny:
                shl     ax,1                            ;"obrot sumy o 1bit", przesuwanie binarne w lewo tj. mnozenie *2, ax=ax*2
                jc      jedenbinarnie
                mov     byte ptr ds:[bx],'0'
                inc     bx
                        loop    binarny                 ;zmniejsza cx z 16 do 0



                jmp     ominjedenbinarnie


jedenbinarnie:
                mov     byte ptr ds:[bx],'1'
                inc     bx
                        loop    binarny


ominjedenbinarnie:

                mov     byte ptr ds:[bx],' '
                mov     byte ptr ds:[bx]+1,10
                mov     byte ptr ds:[bx]+2,13
                mov     byte ptr ds:[bx]+3,'$'


                mov     dx,offset bin
                mov     ah,9
                int     21h

                ;mov     ah,9
                mov     dx,offset znaki                 ;wypisanie binarne
                int     21h

                mov     ax,suma


;wyswietlenie w systemie heksadecymalnym


                mov     bx,offset znaki
                mov     bp,bx

                mov     cx,4                            ;na tylu bitach bd zapisana liczba hex
                mov     ax,suma
heksadecymalny:
                mov     dx,ax                           ;suma do dx
                and     dh,11110000b                    ;maska ktora zeruje czesc liczby wieksza od 15
                shr     dx,12
                shl     ax,4
                mov     si,dx
                mov     dl,hexa[si]
                mov     byte ptr ds:[bx],dl
                inc     bx
                        loop    heksadecymalny

                mov     byte ptr ds:[bx],' '
                mov     byte ptr ds:[bx]+1,10
                mov     byte ptr ds:[bx]+2,13
                mov     byte ptr ds:[bx]+3,'$'


                mov     dx,offset hex
                mov     ah,09h
                int     21h

                mov     ah,9
                mov     dx,offset znaki
                int     21h

czekaj:
                mov     ah,0bh
                int     21h
                cmp     al,0
                je      czekaj


                mov     ah,4ch
                xor     al,al
                int     21h
Progr           ends

dane            segment

                max             db 6                            ;ile max mozna wpisac (5),bo 6 ENTER
                len             db ?                            ;ile user wpisal
                znaki           db 20 dup(0)                    ;lancuch
                suma            dw ?                            ;wynik

                dziesiec        dw 10                           ;po prostu wpisane 10 dziesietnie
                hexa            db '0123456789ABCDEF$'


                welcome         db 'Witaj! Wypisz swoj lancuch w roznych systemach liczbowych.',10,10,13,'$'
                lancuch         db 10,13,'Podaj lancuch znakow: $'
                error1          db 'Nie wprowadzono lancucha!',10,13,'$'
                error2          db 'Przekroczono zakres 65535! Wpisz poprawny lancuch.',10,13,'$'
                error3          db 'To nie jest prawidlowy zakres! Wpisz liczby od 0 do 9.',10,13,'$'
                enter           db 10,13,'$'

                hex             db 'Notacja heksadecymalna: $'
                bin             db 'Liczba w systemie dwojkowym: $'

                star            db 10,13,'---------------------------------------------------------',10,13,'$'

dane            ends

stosik          segment
                dw    100h dup(0)
szczyt          Label word
stosik          ends

end start