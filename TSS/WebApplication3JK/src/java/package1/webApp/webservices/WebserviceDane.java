/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1.webApp.webservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import java.util.List;
import javax.servlet.http.HttpSession;
import package1.webApp.model.Tank;
import package1.webApp.persistence.tankDAO;
import package1.webApp.persistence.tankDAOimpl;

/**
 * REST Web Service
 *
 * @author Jakub
 */
@Path("websources")
public class WebserviceDane {

    @Context
    private UriInfo context;

    private HttpSession session;
    private String currentUser;
    
    /**
     * Creates a new instance of WebserviceDane
     */
    public WebserviceDane() {
    }

    /**
     * Retrieves representation of an instance of package1.webApp.webservices.WebserviceDane
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tank> getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        tankDAO tank = new tankDAOimpl();
        
        return tank.getAllTanksNames();
    }

    /**
     * PUT method for updating or creating an instance of WebserviceDane
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
