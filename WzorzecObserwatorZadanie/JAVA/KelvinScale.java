public class KelvinScale implements Observer{
    KelvinScale(CzyjnikTemperatury temp) { subject = temp; }
    public void ustaw(Subject s){
        if(s == subject){
            System.out.print("Temperature in kelvins: ");
            System.out.print(subject.getTemperature() + 273.15);
            System.out.println("K");
        }
    }

    private CzyjnikTemperatury subject = null;
}
