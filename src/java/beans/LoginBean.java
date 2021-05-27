/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author Dmrv2
 */
import app.Produtos;
import app.Utilizadores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean {

    @PersistenceContext(unitName = "SDProject2PU")
    private EntityManager em;
    
    public boolean login(Utilizadores u){
        Utilizadores o = em.find(Utilizadores.class, u.getUName());
        if(o != null && (u.getUPwd() == o.getUPwd())){
            return true;
        }
            
        return false;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
