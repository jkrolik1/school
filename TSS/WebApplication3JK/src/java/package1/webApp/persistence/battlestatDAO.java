package package1.webApp.persistence;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface battlestatDAO {
    public int getWarAmount(List<Integer> idTankList);
    public void addBattle(HttpServletRequest request);
}
