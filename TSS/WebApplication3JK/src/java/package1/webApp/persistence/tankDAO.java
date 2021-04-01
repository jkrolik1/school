package package1.webApp.persistence;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import package1.webApp.model.Tank;

public interface tankDAO {
    public LinkedList getMyTanks(String login);
}
