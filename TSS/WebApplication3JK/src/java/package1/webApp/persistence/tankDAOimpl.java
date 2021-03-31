package package1.webApp.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import package1.webApp.model.Tank;
import package1.webApp.model.User;
import static package1.webApp.persistence.userDAOimpl.*;

public class tankDAOimpl implements tankDAO{

    @Override
    public List<Tank> getMyTanks(String login) {
        String SELECT_TANKS_QUERY = "SELECT * FROM tank WHERE UserLogin = ?";
        List<Tank> tanksList;
        
        try {
            //connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_TANKS_QUERY);
            //preparedStatement.setString(1, User.getLogin());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //tanksList.add(e)
                //usr.setLogin(resultSet.getString(1));
                //usr.setPassword(resultSet.getString(2));
                //usr.setName(resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            //printSQLException(e);
        }
        
        //return usr;
        return null;
    }
    
}
