public class CzyjnikTemperatury extends Subject{
    public double getTemperature() { return temperatura; }
    public void setTemperature(double nowaWartosc) {
        temperatura = nowaWartosc;
        notifyObservers();
    }

    private double temperatura;
}
