package package1.webApp.persistence;
import java.io.IOException;
import package1.webApp.model.User;
import package1.webApp.data.ApplicationLogic1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class userDAOimpl implements userDAO {
    
    static Connection connection;
    static PreparedStatement preparedStatement;
    
    @Override
    public int insertUser(User user, HttpServletRequest request, HttpServletResponse response) {
        String INSERT_QUERY = "INSERT INTO user(login, password, name) VALUES (?, ?, ?);";
        String INSERT_ROLE_QUERY = "INSERT INTO userrole(role, login) VALUES (?, ?);";

        int result1 = 0, result2 = 0;

        try {
            connection = ApplicationLogic1.makeNewConnection();
            
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            result1 = preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(INSERT_ROLE_QUERY);
            preparedStatement.setString(1, "user");
            preparedStatement.setString(2, user.getLogin());
            result2 = preparedStatement.executeUpdate();
            
            connection.close();
        }
        catch (SQLException e) {
            HttpSession session = request.getSession(false);
            session.setAttribute("messageError", "Konto o takim loginie już istnieje. Spróbuj zarejestrować się dla innych danych.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(userDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            ApplicationLogic1.printSQLException(e);
        }
        return result2;
    }

    @Override
    public User getUser(String login, String password) {
        User usr = new User();
        String SELECT_USERS_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";

        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_USERS_QUERY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                usr.setLogin(resultSet.getString(1));
                usr.setPassword(resultSet.getString(2));
                usr.setName(resultSet.getString(3));
            }
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return usr;
    }

}
