package package1.webApp.controller;

import package1.webApp.persistence.userDAOimpl;
import package1.webApp.persistence.userDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import package1.webApp.data.ApplicationLogic1;
import package1.webApp.model.User;
import javax.servlet.http.HttpSession;


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
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        User user = usr.getUser(login, password1);
        HttpSession session = request.getSession(false);
        
        String newName = request.getParameter("name");
        if (ApplicationLogic1.checkIfRegistrationDataOk(login,password1,password2,newName)) {
            user.setLogin(login);
            user.setPassword(password1);
            user.setName(newName);
            usr.insertUser(user,request,response);
            
            session.setAttribute("messageError", " ");
            session.setAttribute("messageSuccess", "Zostałeś zarejestrowany. Teraz zaloguj się na nowe konto.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        else{
            session.setAttribute("messageSuccess", " ");
            session.setAttribute("messageError", "Nie zostałeś zarejestrowany. Hasła nie są takie same lub podałeś nieprawidłowe dane.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    
}


