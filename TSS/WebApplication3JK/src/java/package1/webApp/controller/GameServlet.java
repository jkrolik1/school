package package1.webApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.Tank;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.User;
import package1.webApp.persistence.battlestatDAO;
import package1.webApp.persistence.battlestatDAOimpl;
import package1.webApp.persistence.tankDAO;
import package1.webApp.persistence.tankDAOimpl;

@WebServlet("/")
public class GameServlet extends HttpServlet {

    private tankDAO tank;
    private battlestatDAO battlestat;
    private HttpSession session;
    private User currentUser;
    
    
    @Override
    public void init() {
        tank = new tankDAOimpl();
        battlestat = new battlestatDAOimpl();
    }
    
    //protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    //        throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            session = request.getSession(false);
            currentUser = (User)session.getAttribute("usrObj");
            
            //String submit = request.getParameter("submit");
            
            String action = request.getServletPath();
            
            switch (action) {
                case "/list":
                    listTanks(request,response);
                    break;
                case "/award":
                    awardBelt(request,response);
                    break;
                case "/edit":
                    editForm(request,response);
                    break;
                case "/update":
                    updateTankName(request,response);
                    break;
                case "/back":
                    try {
                        request.getRequestDispatcher("main.jsp").forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    //ApplicationLogic1.messageOperation(request, response, "message", "Nieprawidłowe dane!", "index.jsp");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private void listTanks(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
	List<Tank> listTanks = tank.getMyTanks(currentUser.getLogin());
        request.setAttribute("listTanks",listTanks);
        try {
            request.getRequestDispatcher("tanksList.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void editForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
	Tank tankForChange = tankDAOimpl.getTank(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("tankForm.jsp");
	request.setAttribute("tank", tankForChange);
	dispatcher.forward(request, response);
    }

    private void awardBelt(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        List<Integer> idTankList = tank.getIdTankList(currentUser.getLogin());
        int warAmount = battlestat.getWarAmount(idTankList);
        //request.setAttribute("warAmount",warAmount);
        
        session = request.getSession(false);
        session.setAttribute("warAmount",warAmount);
        session.setMaxInactiveInterval(0);
        
        try {
            request.getRequestDispatcher("award.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTankName(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        
	int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("name");
        int armor = Integer.parseInt(request.getParameter("armor"));
        int gun = Integer.parseInt(request.getParameter("gun"));
        
        Tank tank = new Tank(id,newName,armor,gun);
        
        tankDAOimpl tankDAOimpl = new tankDAOimpl();
        
	tankDAOimpl.updateTank(tank);
        
        response.sendRedirect("list");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
