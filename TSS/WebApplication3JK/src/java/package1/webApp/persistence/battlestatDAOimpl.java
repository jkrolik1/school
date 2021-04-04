package package1.webApp.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import package1.webApp.data.ApplicationLogic1;
import static package1.webApp.persistence.userDAOimpl.*;

public class battlestatDAOimpl implements battlestatDAO {
    @Override
    public int getWarAmount(List<Integer> idTankList){
        String SELECT_ID_QUERY = "SELECT COUNT(*) FROM battlestat WHERE tankId IN (?,?,?)";
        int warAmount = 0;
        
        
            
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_ID_QUERY);
            
            for (int i = 0; i < idTankList.size(); ++i){
                preparedStatement.setInt(i+1, idTankList.get(i));
            }
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                warAmount = resultSet.getInt(1);
            }
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return warAmount;
    }

}
