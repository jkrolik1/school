package package1.webApp.persistence;
import package1.webApp.model.User;
import package1.webApp.data.ApplicationLogic1;

import java.sql.*;

public class userDAOimpl implements userDAO {
    
    static Connection connection;
    static PreparedStatement preparedStatement;
    
    @Override
    public int insertUser(User user) {
        String INSERT_QUERY = "INSERT INTO user" +
            "(login, password, name) VALUES " +
            " (?, ?, ?);";

        int result = 0;

        try {
            connection = ApplicationLogic1.makeNewConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
            connection.close();
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return result;
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
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        
        return usr;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
