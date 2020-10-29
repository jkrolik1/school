package Egzamin;
import java.util.Random;
import java.util.Scanner;
public class sty17_4 {
    public static void main(String[] args) {
        int[][] tab = null;
        int min=50;
        int max=100;
        int losowa,losowa2;
        boolean licz=true;
        int licz2=0;
        int a,b;
        int proporcja;
        int sp=0;
        Random r = new Random();
        Scanner user = new Scanner(System.in);
        do{
            losowa = r.nextInt(max-min+1)+min;
            losowa2 = r.nextInt(max-min+1)+min;
            if((losowa==losowa2)&&(losowa%4==0)&&(losowa2%4==0)) licz = false;
        }while(licz);
        tab = new int[losowa][losowa2];
        System.out.print("Podaj górny zakres: ");
        b = user.nextInt();
        System.out.print("Podaj dolny zakres: ");
        a = user.nextInt();
        for(int w=0; w<losowa; w++){
            for(int k=0; k<losowa; k++){
                if(w!=k){
                    tab[w][k] = r.nextInt((b-1)-a+1)+a;
                }
                if(w==k){
                    sp=(int)(losowa*0.25);
                    do{
                        proporcja = r.nextInt(losowa-sp+1)+sp;
                        tab[proporcja][proporcja] = 1; 
                        licz2++;
                    }while(licz2<=sp);
                    if(tab[w][k]==0){
                        tab[w][k] = -1;
                    }
                }
            }
        }
        for(int w=0; w<losowa; w++){
            for(int k=0; k<losowa; k++){
                System.out.print(tab[w][k]+" ");
            }
            System.out.println("");
        }
        
    }
    
}
