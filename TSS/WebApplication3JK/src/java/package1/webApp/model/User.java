/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1.webApp.model;

/**
 *
 * @author Jakub
 */
public class User {
    private String login;
    private String password;
    private String name;
    
    public User(){}
    
    public User(String login, String pass, String name){
        this.login = login;
        this.password = pass;
        this.name = name;
    }
    
    public String getLogin(){
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
        
    public void setPassword(String password){
        this.password = password;
    }   
    
    public void setName(String name){
        this.name = name;
    }
    
}
