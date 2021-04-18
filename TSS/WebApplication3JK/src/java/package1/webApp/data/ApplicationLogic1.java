package package1.webApp.data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import package1.webApp.model.Tank;
import package1.webApp.model.User;
import package1.webApp.persistence.tankDAO;

public class ApplicationLogic1{
    
    static Connection connection = null;
    
    public static Connection makeNewConnection() throws SQLException{

        try {
            javax.naming.Context initContext = new javax.naming.InitialContext();
            javax.naming.Context environmentContext = (javax.naming.Context) initContext.lookup("java:/comp/env");
            javax.sql.DataSource mysqlDatabase = (javax.sql.DataSource) environmentContext.lookup("jdbc/KugakmK1yZ");
           
            connection = mysqlDatabase.getConnection();
            
            return connection;
            
        } catch (SQLException ex1) {
            printSQLException(ex1);
        } catch (NamingException ex2) {
            System.out.print(ex2);
        }
        
        /*
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(dbURL,user,pass);
            return connection;
        } 
        catch(ClassNotFoundException failed){
            throw new SQLException("Nie znaleziono klasy dla sterownika: " + driver);
        }
        */
        return null;
    } 

    public static boolean checkIfRegistrationDataOk(String login, String password1, String password2, String name){
        if (name.equals("") || login.equals("") || password1.equals(""))
            return false;
        return password1.equals(password2);
    }

    public static void messageOperation(
            HttpServletRequest request, 
            HttpServletResponse response, 
            String name, 
            String message,
            String path){
        request.setAttribute(name,message);
        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printSQLException(SQLException ex) {
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
