public class FahrenheitScale implements Observer{
    FahrenheitScale(CzyjnikTemperatury temp) { subject = temp; }
    public void ustaw(Subject s){
        if(s == subject){
            System.out.print("Temperature in fahrenheits: ");
            System.out.print(subject.getTemperature() * 1.8 + 32);
            System.out.println("F");
        }
    }

    private CzyjnikTemperatury subject = null;
}
