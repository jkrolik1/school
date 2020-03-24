import java.util.ArrayList;

public class Subject {
    public void addObserver(Observer o) { observers.add(o); }
    public void deleteObserver(Observer o) { observers.remove(o); }
    public void deleteObservers() { observers.clear(); }
    public void notifyObservers() { for(Observer o : observers) o.ustaw(this); }

    protected ArrayList<Observer> observers = new ArrayList();
}
