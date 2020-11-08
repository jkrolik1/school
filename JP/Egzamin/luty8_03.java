/*
    Napisać metodę przyjmującą jako parametr ścieżkę pliku
    tekstowego oraz znak, który ma zostać wyszukany. Ma
    ona zwracać krotność wystąpień - przekazanego znaku -
    we wskazanym pliku.
 */
package Egzamin;
import java.io.IOException;
import java.io.FileReader;
public class luty8_03 {
    public static void main(String[] args) {
        try{
            FileReader plik = new FileReader("a_moje1.txt");
            plik.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
