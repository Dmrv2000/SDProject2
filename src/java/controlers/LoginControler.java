/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import app.Utilizadores;
import beans.LoginBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Dmrv2
 */
@Named (value = "loginControler")
@RequestScoped
public class LoginControler {

    @EJB
    private LoginBean loginBean;
    
    Utilizadores u = new Utilizadores();

    public Utilizadores getU() {
        return u;
    }

    public void setU(Utilizadores u) {
        this.u = u;
    }
    
    public String login(){
        
        boolean b = loginBean.login(u);
        if(b)
            return "admin";
        else
            return "/";
    }
    
}
