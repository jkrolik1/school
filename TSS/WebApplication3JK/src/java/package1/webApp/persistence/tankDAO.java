package package1.webApp.persistence;
import java.util.LinkedList;

public interface tankDAO {
    public LinkedList getMyTanks(String login);
    public LinkedList getIdTankList(String login);
}
