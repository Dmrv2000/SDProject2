/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


/**
 *
 * @author Dmrv2
 */
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
        List <Utilizadores> o = (List<Utilizadores>) em.createNamedQuery("Utilizadores.findByUName").setParameter("uName", u.getUName()).getResultList();
        if (o.isEmpty() || o == null){
            return false;
        }
        return ((u.getUPwd() == o.get(0).getUPwd()));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
