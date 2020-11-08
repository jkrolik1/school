package Egzamin;
import java.util.Scanner;
public class Palindrom2 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String  s = user.nextLine();
        String odwr = new String();
        for(int i=0; i<s.length(); i++){
            odwr = s.charAt(i) + odwr;
        }
        System.out.print(odwr);
    }
}
