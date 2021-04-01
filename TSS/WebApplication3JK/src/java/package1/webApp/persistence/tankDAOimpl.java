package package1.webApp.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.Tank;
import package1.webApp.model.User;
import static package1.webApp.persistence.DBProvider.user;
import static package1.webApp.persistence.userDAOimpl.*;

public class tankDAOimpl implements tankDAO{

    @Override
    public LinkedList getMyTanks(String login) {
        String SELECT_TANKS_QUERY = "SELECT * FROM tank WHERE UserLogin = ?";
        List tanksList = new LinkedList();
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_TANKS_QUERY);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Tank tank = new Tank(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
                tanksList.add(tank);
            }
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return (LinkedList) tanksList;
    }
    
}
