	 ORG 800H  
	 LXI H,HELLOWORLD  
	 RST 3  
	 LXI H,OPERAND1  
	 RST 3  
	 RST 5  
BEGIN  
	 LXI H,OPERACJA  
	 RST 3  
	 RST 2  
	 CPI '+'  
	 JZ PLUS  
	 CPI '-'  
	 JZ MINUS  
	 CPI 'n'  
	 JZ NEG  
	 JMP ERROR  
ERROR  
	 LXI H,BLAD  
	 RST 3  
	 JMP BEGIN  
PLUS  
	 MOV B,D  
	 MOV C,E  
	 LXI H,OPERAND2  
	 RST 3  
	 RST 5  
	 MOV H,D  
	 MOV L,E  
	 DAD B  
	 JC PRZENIESIENIE  
	 MOV B,H  
	 MOV C,L  
	 LXI H,WYNIK  
	 RST 3  
	 MVI A,'0'  
	 RST 1  
	 MOV A,B  
	 RST 4  
	 MOV A,C  
	 RST 4  
	 HLT  
MINUS  
	 MOV B,D  
	 MOV C,E  
	 LXI H,OPERAND2  
	 RST 3  
	 RST 5  
	 MOV A,C  
	 SUB E  
	 JC NEGATIVE  
	 MOV C,A  
	 MOV A,B  
	 SUB D  
	 MOV B,A  
	 LXI H,WYNIK  
	 RST 3  
	 MOV A,B  
	 RST 4  
	 MOV A,C  
	 RST 4  
	 HLT  
PRZENIESIENIE  
	 MOV B,H  
	 MOV C,L  
	 LXI H,WYNIK  
	 RST 3  
	 MVI A,'1'  
	 RST 1  
	 MOV A,B  
	 RST 4  
	 MOV A,C  
	 RST 4  
	 HLT  
NEG  
	 MOV A,E  
	 CMA  
	 MOV E,A  
	 MOV A,D  
	 CMA  
	 MOV D,A  
	 LXI H,WYNIK  
	 RST 3  
	 MOV A,D  
	 RST 4  
	 MOV A,E  
	 RST 4  
	 HLT  
NEGATIVE  
	 MOV C,A  
	 MOV A,B  
	 SUB D  
	 SUI 01  
	 MOV B,A  
	 LXI H,WYNIK  
	 RST 3  
	 MOV A,B  
	 RST 4  
	 MOV A,C  
	 RST 4  
	 HLT  
HELLOWORLD 	 DB 'Witaj w kalkulatorze '        
	 DB 'Pawla i Kuby!',10,13,'@'        
OPERAND1 	 DB 10,13,'Podaj operand: ','@'        
OPERACJA 	 DB 10,13,'Podaj jaka operacje chcesz wykonac (+, -, n): ','@'        
OPERAND2 	 DB 10,13,'Podaj operand 2: ','@'        
BLAD 	 DB 10,13,'Podaj prawidlowy znak operacji (+, -, n)! ','@'        
WYNIK 	 DB 10,13,'Wynik: ','@'        
