/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1.webApp.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jakub
 */
public class ApplicationLogic1 {
    public static Connection makeNewConnection(String sUrl,String sUsername, String sPassword) throws SQLException{
        
        // Połączenie z bazą mysqlową
        
        String sDriverMySQL = "com.mysql.jdbc.Driver";
        //String sDriverMSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String sDriver = sDriverMSSQL;
        String sDriver = sDriverMySQL;
        
        try{
            Class.forName(sDriver);
            Connection connection = DriverManager.getConnection(sUrl, sUsername, sPassword);
            return connection;
        } 
        catch(ClassNotFoundException failed){
            throw new SQLException("Nie znaleziono klasy dla sterownika: " + sDriver);
        }
        
    } 
}
