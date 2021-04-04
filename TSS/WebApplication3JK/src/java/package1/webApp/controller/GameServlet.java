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
import package1.webApp.persistence.tankDAO;
import package1.webApp.persistence.tankDAOimpl;

@WebServlet("/")
public class GameServlet extends HttpServlet {

    private tankDAO tank;
    private HttpSession session;
    private User currentUser;
    
    
    @Override
    public void init() {
        tank = new tankDAOimpl();
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
        } catch (ServletException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationLogic1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
