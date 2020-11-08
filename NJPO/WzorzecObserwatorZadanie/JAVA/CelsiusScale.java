public class CelsiusScale implements Observer{
    CelsiusScale(CzyjnikTemperatury temp) { subject = temp; }
    public void ustaw(Subject s){
        if(s == subject){
            System.out.print("\nTemperature in celsius: ");
            System.out.print(subject.getTemperature() * 1);
            System.out.println("C");
        }
    }

    private CzyjnikTemperatury subject = null;
}
