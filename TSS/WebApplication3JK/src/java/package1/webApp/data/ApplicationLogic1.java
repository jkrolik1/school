package package1.webApp.data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import package1.webApp.model.Tank;
import package1.webApp.persistence.battlestatDAO;
import package1.webApp.persistence.battlestatDAOimpl;
import package1.webApp.persistence.tankDAO;
import package1.webApp.persistence.tankDAOimpl;

public class ApplicationLogic1{
    
    static Connection connection = null;
    private static HttpSession session;
    private static String currentUser;
    private static tankDAO tank = new tankDAOimpl();
    private static battlestatDAO battlestat = new battlestatDAOimpl();
    private static int battleNumber;
    
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
    
    public static void listTanks(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
        
        session = request.getSession(false);
        currentUser = (String)session.getAttribute("usrLogin");
        
	List<Tank> listTanks = tank.getMyTanks(currentUser);
        request.setAttribute("listTanks",listTanks);
        try {
            request.getRequestDispatcher("tanksList.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void editForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        
        session.removeAttribute("tankBattleResult");
        
	int id = Integer.parseInt(request.getParameter("id"));
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
	Tank tankForChange = tankDAOimpl.getTank(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("tankForm.jsp");
	request.setAttribute("tank", tankForChange);
	dispatcher.forward(request, response);
    }
   
    public static void deleteOption(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
	tankDAOimpl.deleteTank(id);
        session = request.getSession(false);
        session.removeAttribute("tankBattleResult");
        session.setAttribute("crudMessage", "Usunięto czołg. Zobacz listę powyżej.");
        listTanks(request,response);
    }
    
    public static void awardBelt(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        List<Integer> idTankList = tank.getIdTankList(currentUser);
        int warAmount = battlestat.getWarAmount(idTankList);
        
        session = request.getSession(false);
        session.setAttribute("warAmount",warAmount);
        session.setMaxInactiveInterval(0);
        
        try {
            request.getRequestDispatcher("award.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateTankName(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        
	int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("name");
        int armor = Integer.parseInt(request.getParameter("armor"));
        int gun = Integer.parseInt(request.getParameter("gun"));
        
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
        
	tankDAOimpl.updateTank(new Tank(id,newName,armor,gun));
        
        session = request.getSession(false);
        session.removeAttribute("tankBattleResult");
        session.setAttribute("crudMessage", "Edytowano czołg. Zobacz listę powyżej.");
        
        listTanks(request,response);
    }

    public static void addOption(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
        
	RequestDispatcher dispatcher = request.getRequestDispatcher("tankAdd.jsp");
        dispatcher.forward(request, response);
    }

    public static void add2Option(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        
        String name = request.getParameter("name");
        
        Random rand = new Random();
        int armor = rand.nextInt(200);
        int gun = rand.nextInt(200);
        
        Tank tank = new Tank(name,armor+1,gun+1);
        
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
        
	tankDAOimpl.addTank(tank,currentUser);
        
        session = request.getSession(false);
        session.removeAttribute("tankBattleResult");
        session.setAttribute("crudMessage", "Dodano czołg. Zobacz listę powyżej.");
        
        listTanks(request,response);
    }
    
    public static void selectTank(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));

        tankDAOimpl tankDAOimpl = new tankDAOimpl();
        
        Tank oponent = tankDAOimpl.randomOponent(currentUser);
        Tank myTank = tankDAOimpl.getTank(id);
        
        session = request.getSession(false);
        session.setAttribute("tank1", oponent);
        session.setAttribute("tank2", myTank);

        RequestDispatcher dispatcher = request.getRequestDispatcher("tankWar.jsp");
        dispatcher.forward(request, response);
    }
    
    public static void warTank(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException{

        battlestatDAOimpl battlestatDAOimpl = new battlestatDAOimpl();
        
        session = request.getSession(false);
        Tank oponent = (Tank) session.getAttribute("tank1");
        Tank myTank = (Tank) session.getAttribute("tank2");
        
        String tankBattleResult = ApplicationData1.battleFight(oponent,myTank);
        
        session.setAttribute("tankBattleResult", tankBattleResult);
        
        String[] splited = tankBattleResult.split("\\s+");
        
        if (myTank.getName().equals(splited[2])){
            session.setAttribute("winner", myTank);
            session.setAttribute("loser", oponent);
            session.setAttribute("color", "green");
        } 
        else if (oponent.getName().equals(splited[2])){
            session.setAttribute("winner", oponent);
            session.setAttribute("loser", myTank);
            session.setAttribute("color", "red");
        }
        else{
            session.setAttribute("winner", oponent);
            session.setAttribute("loser", myTank);
            session.setAttribute("color", "black");
        }
            
        battlestatDAOimpl.addBattle(request);
        
        int battleNumberX = getBattleNumber();
        setBattleNumber(battleNumberX+1);
        
        listTanks(request,response);
    }
    
    public static void setBattleNumber(int x){
        battleNumber = x;
    }
    
    public static int getBattleNumber(){
        return battleNumber;
    }

}
