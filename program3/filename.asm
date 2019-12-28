;uzyskanie nazwy parametru w buforze
;https://stackoverflow.com/questions/42920244/assembler-save-arguments-from-psp-dosbox

bufor   db  300 dup('$')



    mov di, 82h                 ; SI = pointer to the first character of parameters
    xor cx, cx                  ; Loop counter
    mov cl, byte ptr es:[80h]   ; Number of bytes of the command line (is one to big)
    sub cx, 1                   ; Decrement the number of bytes
p1: mov al,byte ptr es:[di]     ; Load one character from PSP...
    mov byte ptr ds:[si],al     ;     ...and store it in bufor
    inc si                      ; Increment the pointer to bufor
    inc di                      ; Increment the pointer to PSP
    loop p1                     ; Repeat CX times
