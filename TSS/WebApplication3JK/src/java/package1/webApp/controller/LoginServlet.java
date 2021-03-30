/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1.webApp.controller;

import package1.webApp.persistence.DAOUzytkownik;
import package1.webApp.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import package1.webApp.model.User;

/**
 *
 * @author Jakub
 */



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private DAOUzytkownik userDao;

    String page;
    
@Override
    public void init() {
        userDao = new DAOUzytkownik();
    }

    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        try {
            int resultX = userDao.loginUser(user);
            if (resultX != 0)
                 page = "main.jsp";
            else
                page = "loginError.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(page);
    }


}
