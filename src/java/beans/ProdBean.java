/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import app.Produtos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dmrv2
 */
@Stateless
public class ProdBean {

    @PersistenceContext(unitName = "SDProject2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<app.Produtos> getProducts() {
        return (List<app.Produtos>) em.createNamedQuery("Produtos.findAll").getResultList();
    }
    
    public Produtos addProduct(Produtos prd) {
        em.persist(prd);
        return prd;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
