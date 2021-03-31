package package1.webApp.persistence;
import package1.webApp.model.User;

public interface userDAO {
    public int insertUser(User user);
    public User getUser(String login, String password);
}
