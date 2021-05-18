package package1.webApp.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.Tank;
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
                Tank tank = new Tank(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                tanksList.add(tank);
            }
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return (LinkedList) tanksList;
    }
    
    @Override
    public LinkedList getAllTanksNames(){
       String SELECT_TANKS_QUERY = "SELECT tankId, tankName, Userlogin FROM tank";
        List tanksList = new LinkedList();
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_TANKS_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Tank tank = new Tank(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                tanksList.add(tank);
            }
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return (LinkedList) tanksList; 
    }
    
    @Override
    public LinkedList getIdTankList(String login){
        String SELECT_ID_QUERY = "SELECT tankId FROM tank WHERE UserLogin = ?";
        List idTankList = new LinkedList();
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_ID_QUERY);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                idTankList.add(resultSet.getInt(1));
            }
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return (LinkedList) idTankList;
    }

    @Override
    public Tank getTank(int id) {
        String SELECT_TANKS_QUERY = "SELECT * FROM tank WHERE tankId = ?";
        Tank tank = null;
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(SELECT_TANKS_QUERY);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int tankId = resultSet.getInt("tankId");
                String name = resultSet.getString("tankName");
                int armor = resultSet.getInt("armorAmount");
                int caliber = resultSet.getInt("gunCaliber");
                tank = new Tank(tankId, name, armor, caliber);
            }
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return tank;
    }

    @Override
    public boolean updateTank(Tank tank){
        String UPDATE_TANKS_QUERY = "UPDATE tank SET tankName = ? WHERE tankId = ?";
        boolean updateSuccess = false;
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(UPDATE_TANKS_QUERY);
            preparedStatement.setString(1, tank.getName());
            preparedStatement.setInt(2, tank.getTankId());
            
            updateSuccess = preparedStatement.executeUpdate() > 0;

            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return updateSuccess;
    }

    @Override
    public boolean deleteTank(int id){
        String DEL_TANKS_QUERY = "DELETE FROM tank WHERE tankId = ?";
        String DEL_TANKS_QUERY2 = "DELETE FROM battlestat WHERE tankId = ?";
        boolean deleteSuccess = false;
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(DEL_TANKS_QUERY2);
            preparedStatement.setInt(1, id);

            deleteSuccess = preparedStatement.executeUpdate() > 0;
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(DEL_TANKS_QUERY);
            preparedStatement.setInt(1, id);

            deleteSuccess = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return deleteSuccess;
    }

    @Override
    public void addTank(Tank tank, String login){
        String ADD_TANK_QUERY = "INSERT INTO tank(tankName,armorAmount,gunCaliber,Userlogin) VALUES(?,?,?,?)";
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(ADD_TANK_QUERY);
            preparedStatement.setString(1, tank.getName());
            preparedStatement.setInt(2, tank.getArmorAmount());
            preparedStatement.setInt(3, tank.getGunCaliber());
            preparedStatement.setString(4, login);
            
            preparedStatement.execute();
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
    }

    
    @Override
    public Tank randomOponent(String login){
        String CHOOSE_OPONENT = "SELECT * FROM tank WHERE Userlogin != ?";
        Tank tank = null;
        List<Tank> tanks = new ArrayList<>();
        
        try {
            connection = ApplicationLogic1.makeNewConnection();  
         
            preparedStatement = connection.prepareStatement(CHOOSE_OPONENT);
            preparedStatement.setString(1, login);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int tankId = resultSet.getInt("tankId");
                String name = resultSet.getString("tankName");
                int armor = resultSet.getInt("armorAmount");
                int caliber = resultSet.getInt("gunCaliber");
                
                tank = new Tank(tankId, name, armor, caliber);
                
                tanks.add(tank);
            }
            
            Collections.shuffle(tanks);
            
            connection.close();
        }
        catch (SQLException e) {
            ApplicationLogic1.printSQLException(e);
        }
        
        return tanks.get(0);
    }

}
