package package1.webApp.persistence;

import java.sql.SQLException;


public interface DBProvider {
    String user = "root";
    String pass = "";
    String dbURL = "jdbc:mysql://localhost:3306/tanksbattle";
    String driver = "com.mysql.jdbc.Driver";
}
