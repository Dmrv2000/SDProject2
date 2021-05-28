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
import app.Administradores;
import app.Utilizadores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean {

    @PersistenceContext(unitName = "SDProject2PU")
    private EntityManager em;
    private boolean session = false;
    public int login(Utilizadores u){
        List <Utilizadores> o = (List<Utilizadores>) em.createNamedQuery("Utilizadores.findByUName").setParameter("uName", u.getUName()).getResultList();
        if (o.isEmpty() || o == null){
            return 0;
        }
        boolean b1 = u.getUPwd().equals(o.get(0).getUPwd());
        List <Administradores> a = (List<Administradores>) em.createNamedQuery("Administradores.findByUId").setParameter("uId", o.get(0).getUId()).getResultList();
        if (a.isEmpty() || a == null){
            if(b1){
                session = true;
                return 1;
            }else{
                session = false;
                return 0;
            }
            
        }         
        return 2;
    }
    
    public boolean testAdmin(Utilizadores u){
        List <Utilizadores> o = (List<Utilizadores>) em.createNamedQuery("Utilizadores.findByUName").setParameter("uName", u.getUName()).getResultList();
        if (o.isEmpty() || o == null){
            return false;
        }
        if (u.getUPwd().equals(o.get(0).getUPwd())){
            session = true;
            return true;
        }
        return false;
    }
    
    public boolean logout(){
        session = false;
        return !session;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
