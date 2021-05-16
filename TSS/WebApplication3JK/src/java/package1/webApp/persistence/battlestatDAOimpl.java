package package1.webApp.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.Tank;
import static package1.webApp.persistence.userDAOimpl.*;

public class battlestatDAOimpl implements battlestatDAO {
    @Override
    public int getWarAmount(List<Integer> idTankList){
        String SELECT_ID_QUERY = "SELECT COUNT(*) FROM battlestat WHERE tankId IN (?)";
        int warAmount = 0;
        ResultSet resultSet;
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            for (int i = 0; i < idTankList.size(); ++i){
                preparedStatement = connection.prepareStatement(SELECT_ID_QUERY);
                preparedStatement.setInt(1, idTankList.get(i));
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                    warAmount += resultSet.getInt(1);
            }

        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return warAmount;
    }
    @Override
    public void addBattle(HttpServletRequest request){
        String ADD_TANK_QUERY = "INSERT INTO battle(battleCity) VALUES(?)";
        String LAST_ID_QUERY = "SELECT battleId FROM battle ORDER BY battleId desc limit 1";
        String BATTLESTAT_QUERY = "INSERT INTO battlestat(tankId,battlebattleId,durationInSec,winner) VALUES(?,?,?,?)";
        String BATTLESTAT_QUERY2 = "INSERT INTO battlestat(tankId,battlebattleId,durationInSec,winner) VALUES(?,?,?,?)";
        
        HttpSession session = request.getSession(false);
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
            
            preparedStatement = connection.prepareStatement(ADD_TANK_QUERY);
            preparedStatement.setString(1, " "); 
            preparedStatement.execute();
            
            preparedStatement = connection.prepareStatement(LAST_ID_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            int id = -1;
            while (resultSet.next())
                id = resultSet.getInt("battleId");
            
            Tank loser = (Tank) session.getAttribute("loser");
            Tank winner = (Tank) session.getAttribute("winner");
            
            preparedStatement = connection.prepareStatement(BATTLESTAT_QUERY);
            preparedStatement.setInt(1, loser.getTankId()); 
            preparedStatement.setInt(2, id); 
            preparedStatement.setInt(3, 2);
            preparedStatement.setInt(4, 0); 
            preparedStatement.execute();
            
            preparedStatement = connection.prepareStatement(BATTLESTAT_QUERY2); // winner
            preparedStatement.setInt(1, winner.getTankId()); 
            preparedStatement.setInt(2, id); 
            preparedStatement.setInt(3, 2);
            preparedStatement.setInt(4, 1); 
            preparedStatement.execute();
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
    }
    @Override
    public int battleNumber(){
        String QUERY = "SELECT COUNT(*) FROM battle";
        try {
            connection = ApplicationLogic1.makeNewConnection();  
            
            preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next())
                return resultSet.getInt(1);
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        return 0;
    }
}
