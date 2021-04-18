package package1.webApp.controller;

import package1.webApp.persistence.userDAOimpl;
import package1.webApp.persistence.userDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.User;

@WebServlet("/loginRegister")
public class MainServlet extends HttpServlet {
    
    private userDAO usr;
    
    @Override
    public void init() {
        usr = new userDAOimpl();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
           
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String submit = request.getParameter("submit");
        
        User user = new User();

        switch (submit) {
            case "logowanie":
                user = usr.getUser(login, password);
                if ((user != null) && (user.getName() != null)){
                    // tankDAO tnk = new tankDAOimpl();
                    // LinkedList myTanks = tnk.getMyTanks(login);
                    request.setAttribute("myName",user.getName());
                    // request.setAttribute("myTanks",myTanks);
                    
                    javax.servlet.http.HttpSession userSession = null;
                    userSession = request.getSession(false);
                    userSession.setAttribute("usrObj",user);
                    userSession.setMaxInactiveInterval(0);
                    
                    ApplicationLogic1.messageOperation(request, response, "success", user.getName(), "main.jsp");
                }
                else
                    ApplicationLogic1.messageOperation(request, response, "message", "Nieprawidłowe dane!", "index.jsp");
                break;
            case "rejestracja":
                user = usr.getUser(login, password1);
                String newName = request.getParameter("name");
                if (ApplicationLogic1.checkIfRegistrationDataOk(login,password1,password2,newName)) {
                    user.setLogin(login);
                    user.setPassword(password1);
                    user.setName(newName);
                    usr.insertUser(user);
                    ApplicationLogic1.messageOperation(request, response, "success", "Rejestracja pomyślna!", "index.jsp");
                }
                else
                    ApplicationLogic1.messageOperation(request, response, "message", "Hasła nie są takie same lub któreś pole jest puste!", "index.jsp");
                break;
            default:
                ApplicationLogic1.messageOperation(request, response, "message", "Nieprawidłowe dane!", "index.jsp");
                break;
        }
    }

    
}


