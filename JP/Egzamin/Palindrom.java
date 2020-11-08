package Egzamin;
import java.util.Scanner;
public class Palindrom {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String  s = user.nextLine();
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String s2 = sb.toString();
        System.out.println(s);
        System.out.print(s2);
    }
    
}
