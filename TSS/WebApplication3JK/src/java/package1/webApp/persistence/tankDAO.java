package package1.webApp.persistence;
import java.util.LinkedList;
import package1.webApp.model.Tank;

public interface tankDAO {
    public LinkedList getMyTanks(String login);
    public LinkedList getIdTankList(String login);
    public Tank getTank(int id);
    public boolean updateTank(Tank tank);
    public boolean deleteTank(int id);
    public void addTank(Tank tank, String login);
}
