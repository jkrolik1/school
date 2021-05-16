package package1.webApp.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import package1.webApp.persistence.battlestatDAO;
import package1.webApp.persistence.battlestatDAOimpl;
import package1.webApp.persistence.tankDAO;
import package1.webApp.persistence.tankDAOimpl;
import package1.webApp.persistence.userDAO;
import package1.webApp.persistence.userDAOimpl;

@WebServlet("/")
public class GameServlet extends HttpServlet {

    private tankDAO tank;
    private battlestatDAO battlestat;
    private HttpSession session;
    private String currentUser;
    private userDAO usr;
    
    @Override
    public void init() {
        tank = new tankDAOimpl();
        battlestat = new battlestatDAOimpl();
        usr = new userDAOimpl();
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
            currentUser = (String)session.getAttribute("usrLogin");
            
            session.removeAttribute("messageError");
            session.removeAttribute("messageSuccess");
            session.setAttribute("crudMessage", " ");
            
            
            String action = request.getServletPath();
            
            switch (action) {
                case "/logout":
                    session.setAttribute("messageSuccess", "Wylogowano!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    session.invalidate();
                    break;
                case "/list":
                    ApplicationLogic1.listTanks(request,response);
                    break;
                case "/award":
                    ApplicationLogic1.awardBelt(request,response);
                    break;
                case "/edit":
                    ApplicationLogic1.editForm(request,response);
                    break;
                case "/update":
                    ApplicationLogic1.updateTankName(request,response);
                    break;
                case "/delete":
                    ApplicationLogic1.deleteOption(request,response);
                    break;
                case "/add":
                    ApplicationLogic1.addOption(request,response);
                    break;
                case "/add2":
                    ApplicationLogic1.add2Option(request,response);
                    break;
                case "/play":
                    ApplicationLogic1.selectTank(request,response);
                    break;
                case "/war":
                    ApplicationLogic1.warTank(request,response);
                    break;
                case "/battles":
                    ApplicationLogic1.setBattleNumber(battlestat.battleNumber());
                    try {
                        request.getRequestDispatcher("websocket.jsp").forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "/back":
                    try {
                        request.getRequestDispatcher("main.jsp").forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    try {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
