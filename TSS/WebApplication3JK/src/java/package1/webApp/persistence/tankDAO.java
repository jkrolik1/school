package package1.webApp.persistence;
import java.util.List;
import package1.webApp.model.Tank;

public interface tankDAO {
    public List<Tank> getMyTanks(String login);
}
