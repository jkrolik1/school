/*
W kolejnych wierszach pliku wpisano iformacje o towarach przechowywanych na magazynie
Zapisano:
    nazwę, cenę i sztuki
Np:
    Laptop 2000 7
    Drukarka 500 10
    ...
Proszę napsiać program, który obliczy i wypisze na konsolę aktualną wartość magazynu (cena towaru x liczba x wszystkie towary)
 */
package sty3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class cwiczenie2 {

    public static void main(String[] args) {
        String s;
        double cena;
        int sztuk;
        double wartość=0;
        String tab[] = null;
        try{
            BufferedReader bf = new BufferedReader(new FileReader("magazyn.txt"));
            do{
                s = bf.readLine();
                if(s!=null)
                    tab = s.split(" ");
                    cena = Double.parseDouble(tab[1]);
                    sztuk = Integer.parseInt(tab[2]);
                    wartość = wartość + cena*sztuk;
            }while(s!=null);
            System.out.println(wartość);
            bf.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
