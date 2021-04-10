package package1.webApp.controller;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        
    }
    
    private void drawAward(HttpServletRequest request, HttpServletResponse response, int warAmount){
        
        try(javax.servlet.ServletOutputStream out = response.getOutputStream()) {
            int width = warAmount*10;
            int height = 20;
            java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(width,height,java.awt.image.BufferedImage.TYPE_INT_RGB);
            java.awt.Graphics graph = image.getGraphics();
            graph.fillRect(20,20,warAmount,warAmount);
            javax.imageio.ImageIO.write(image,"jpg",out);
        }
        catch (IOException ioe){
            // 
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        javax.servlet.http.HttpSession session = null;
        session = request.getSession(false);
        
        drawAward(request,response, (int) session.getAttribute("warAmount"));
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}