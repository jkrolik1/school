	 ORG 800H ;---------START OD KOMORKI 800  
;--------------------D7 - RST 2     
;--------------------FE - CPI     
;--------------------21 - !     
;--------------------CA - JZ     
;--------------------CF - RST 1     
BEGIN ;--------------DODANIE ETYKIETY BEGIN GDY NIE PODA !+-  
	 RST 2 ;------------WCZYTANIE Z KLAWY DO AKU RODZAJU OPERACJI  
	 CPI '!' ;----------CZY W AKU JEST !  
	 JZ NEG ;-----------JESLI TAK SKOK DO 'NEG' (IF FLAG Z=1!!!!!)  
	 CPI '+' ;----------CZY W AKU JEST +  
	 JZ ADDITION ;------JESLI W AKU JEST + TO SKOK DO 'ADDITION'  
	 CPI '-' ;----------CZY W AKU JEST -  
	 JZ SUBTRACTION ;---JEZELI W AKU JEST - SKOK DO SUBTRACTION  
	 JMP BEGIN ;--------SKOK BEZWARUNKOWY JEZELI W AKU NIE MA !+-  
ADDITION ;-----------START ETYKIETY JEZELI W AKU BYL +  
	 MVI A,':' ;--------WPISANIE ZNAKU : DO AKU  
;---(WPIS DANYCH Z 2 BAJTU INSTRUKCJI DO WSKAZANEGO REJESTRU)             
	 RST 1 ;------------WYPISANIE ZNAKU Z AKUMULATORA NA EKRAN  
	 MVI A,' ' ;--------WPIS SPACJI DO AKU  
	 RST 1 ;------------WYPISANIE ZNAKU Z AKU NA EKRAN  
	 RST 2 ;------------WPISANIE BAJTU Z KLAWIATURY DO AKU  
	 MOV B,A ;----------PRZESLANIE ZAW AKU DO REJ B  
	 MVI A,'+' ;--------WPISANIE ZNAKU + DO AKU  
	 RST 1 ;------------WYPISANIE ZNAKU Z AKU NA EKRAN  
	 RST 2 ;------------WCZYTANIE ZNAKU Z KLAWIATURY DO AKU  
	 SUI 30H ;----------ODJECIE OD ZAW AKU 30H  
PROCESS ;------------WEJSCIE DO ETYKIETY PROCESS  
	 CPI 00H ;----------CZY W AKU ZNAJDUJE SIE 00  
	 JZ DIGIT ;---------JEZELI W AKU JEST 00 PRZEJSCIE DO DIGIT  
	 DCR A ;------------DECREMENTACJA A  
	 INR B ;------------INK B  
	 JMP PROCESS ;------SKOK BEZWARUNKOWY DO PROCESS  
;---DEKREMENTUJ A I INK B DOPOKI W AKU NIE POJAWI SIE 00       
SUBTRACTION  
	 MVI A,':'  
	 RST 1  
	 MVI A,' '  
	 RST 1  
	 RST 2  
	 MOV B,A  
	 MVI A,'-'  
	 RST 1  
	 RST 2  
	 MOV E,A  
	 MOV A,B  
	 SUB E ;------------ODJECIE OD AKU ZAW E  
	 JM NEGATIVE ;------JEZELI FLAGA S=1 TO DO NEGATIVE  
	 JP POSITIVE ;------FLAGA S=0  
POSITIVE ;-------------np 5-1  
	 MOV A,E ;------mniejsze do aku  
	 SUI 30H  
PROCESS2  
	 CPI 00H  
	 JZ DIGIT  
	 DCR A  
	 DCR B  
	 JMP PROCESS2  
NEGATIVE ;----------------------np 3-9  
	 MOV A,B ;------mniejsze do aku  
	 SUI 30H  
PROCESS3  
	 CPI 00H  
	 JZ SCORESUBTRACTION  
	 DCR A  
	 DCR E  
	 JMP PROCESS3  
NEG  
	 RST 2  
	 CPI '-'  
	 JZ NEGMINUS  
	 MOV B,A  
	 JMP SCORENEG  
NEGMINUS  
	 RST 2  
	 MOV B,A  
	 MVI A,'='  
	 RST 1  
	 MOV A,B  
	 RST 1  
	 HLT  
DIGIT  
	 MOV A,B  
	 CPI 3AH ;-----1 bajtowa  
	 JM SINGLE ;---MNIEJSZY OD 3AH (JEDNA CYFRA W WYNIKU)  
	 MVI C,3AH  
	 MVI H,30H ;---jednosci  
	 JMP DOUBLE  
SCORENEG  
	 MVI A,'='  
	 RST 1  
	 MVI A,'-'  
	 RST 1  
	 MOV A,B  
	 RST 1  
	 HLT  
SINGLE  
	 MOV B,A  
	 MVI A,'='  
	 RST 1  
	 MOV A,B  
	 RST 1  
	 HLT  
DOUBLE  
	 CMP C ;---------------porownaj rej c z aku //2 bajtowa  
	 JZ SCOREADDITION  
	 INR C  
	 INR H  
	 JMP DOUBLE  
SCOREADDITION  
	 MVI A,'='  
	 RST 1  
	 MVI A,'1'  
	 RST 1  
	 MOV A,H  
	 RST 1  
	 HLT  
SCORESUBTRACTION  
	 MVI A,'='  
	 RST 1  
	 MVI A,'-'  
	 RST 1  
	 MOV A,E  
	 RST 1  
	 HLT  
