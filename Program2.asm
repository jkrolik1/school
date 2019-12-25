;zamazanie określonej linii w programie wybranym wzorcem 
Progr segment

assume  cs:Progr,ds:dane,ss:stosik

Start:
                mov ax,dane                             ;adresowanie segmentow
                mov ds,ax
                mov ax,stosik
                mov ss,ax
                mov sp,offset szczyt


                xor ax,ax
                xor dx,dx                               ;Funkcja 00H przerwania 1Ah odczytuje licznik zegara systemowego


                int 1ah                 ;przerwanie zegarowe ;impusly co 55 milisekund zliczane od poczatku uruchomienia komputera ;zegar jest odczytywany aby przy uruchomieniu programu aby wylosowac nr wiersza ktory zostanie jako pierwszy zasloniety
                mov czas,dl                                                     ;w/w zeby program zawsze zaczynal od innej lini, pozniej na przemian wylosowane wartosci w tablicy w sposob sekwencyjny


                xor ax,ax                                                       ;pozniej od tej lini ktora wylosowal zwiekszamy o 1
                xor dx,dx
                                                ;nieskonczona petla
        looop:
                xor ax,ax
                inc czas                                ;od tej lini ktora wylosowal zwiekszamy o 1
                mov al,czas
                mov si,ax
                mov dl,losuj[si]
                mov wybrany,dl
                xor dx,dx
                xor ax,ax

                mov ah,00
                mov al,160
                mul wybrany                     ;n*160 - n to wybrany;mnozenie jest 8 bitowe, poniewaz mnozenie zalezy od zmiennej, a zmienna jest 8bitowa      ; AL jest mnozony przez wybrany i wynik w AX
                mov bx,ax                               ;w BX znajduje sie adres poczatkowy liczby

                  cld                           ;kopiowanie pewnej linii programu do zadeklarowanego bufora
                  push ds                                       ;cld - wyzerowanie flagi kierunku, adresy sa dodawane a nie odejmowane
                  push ds
                  pop es
                  mov di,offset bufor
                  mov ax,0b800h                         ;pierwszy znak ;Adres konsoli
                  mov ds,ax
                  mov si,bx
                  mov cx,80                             ;80 znaków w jedym wierszu a kazdy znak ma 2bajty (1bajt kod znaku, 2bajt atrybut) 
                  rep movsw                             ;Operacja blokowa przeniesienia z konsoli do innego miejsca w pamieci ;kopiuje z segmentu danych i zrodla danych do segmentu dodatkowego i przeznaczenia danych
                  pop ds                                        ;przy si mamy segment danych, przy di w segmencie dodatkowym es
                                                                ;movsw - kopiuje do slowa adresowanego es:di slowo spod adesu ds:si, di+-2 i si+-2 (kolejny adres bloku)
                mov ax,0b800h
                mov es,ax

                mov di,bx

                  mov ah,10010000b                      ;kolor (tech->screen atributes), iiiioooo (i - z tylu, o - z przodu atrament), o - spacja jest pusta, ale dla jakiegos np znaku bylby to jego kolor, dla spacji obojetnie
                  mov al,32d                            ;kod znaku ascii spacji (wypelnienie belki)                                    pierwszy to rozjasnienie (1 to jasny-x) , 5 to miganie
                  mov cx,80                             ;ile razy sie wykonuje rep                                                     000-black,001-blue,010-green,011-cyan,100-red,101-magenta,110-brown,111-white
                  rep stosw            ;powtarzaj stosw ;stosw - istrukcja dotyczaca stringow. Do es:di zapisuje zawartosc ax. Tez modyfikuje adres miejsca zapisu


                xor dx,dx
                xor cx,cx
                mov cx,18                               ;"szybkosc". Im wieksza wartosc w cx tym wolniej, 18 (co 18 bajtow) to 1s
                mov ah,86h
                mov al,0
                int 15h                                 ;Przerwanie zawieszajace program na czas CX:DX (to co w cx)


                  mov si,offset bufor                   ;160bajtow, w si zapisany offset bufora
                  mov di,bx
                  mov cx,80
                  rep movsw               ;Powrót wczesniej pobranego wiersza na konsole ds:si -> es:di

                mov ax,0b00h
                int 21h
                cmp al,0
                jne koniec                      ;jesli zostal wcisniety klawisz to zakoncz
                jmp looop
                                                ;koniec nieskonczonej petli
        koniec:
                mov ah,4Ch
                xor al,al
                int 21h

Progr ends


dane segment

        bufor       db 160 dup(0)                       ;bufor 160 elementowy wypelniony przy starcie programu zerami
        wybrany     db 0
        czas        db 0
        losuj       db 4,7,8,14,5,24,12,23,16,14,6,21,8,11,2,17,24,0,10,20,11,22,8,5,8,10,15,5,7,21,16,5,3,15,4,12,21,12,10,4,3,19,15,2,12,10,20,5,8,12,14,14,19,3,10,12,19,19,7,7,3,1,0,4,22,7,22,14,11,24,23,12,13,0,16,0,4,0,17,6,14,10,15,13,12,24,19,22,4,5,20,21,20,19,3,9,1,4,21,5,14,0,14,4,14,19,2,6,3,9,3,9,7,13,15,19,0,17,14,10,22,1,19,11,0,17,5,5,1,8,3,20,9,13,20,0,9,9,8,18,21,2,8,22,23,24,23,2,15,18,8,17,24,21,1,24,19,2,17,24,5,20,9,18,15,18,5,7,5,19,16,17,21,22,20,0,23,12,5,7,8,13,5,0,11,14,11,21,4,14,10,6,16,22,16,19,9,2,20,19,15,15,18,9,24,16,15,22,16,6,20,21,24,10,21,3,16,13,8,20,11,5,10,8,18,5,12,0,19,3,7,14,15,1,3,20,2,18,18,1,14,3,5,24,10,13,17,18,20,0,4,9,15,20,16,10
                                                ;256 liczb z generatora (od 0 do 24) 25linii(w pionie max)
dane ends


stosik segment

                dw 100h dup(0)
        szczyt  label word

stosik ends

end start
