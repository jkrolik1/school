package package1.webApp.persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import package1.webApp.model.User;

public interface userDAO {
    public int insertUser(User user, HttpServletRequest request, HttpServletResponse response);
    public User getUser(String login, String password);
}
