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
    
    public Produtos editProduct(Produtos p){
        Produtos b = em.find(Produtos.class, p.getPId());
        if (b != null){
            b.setPStock(b.getPStock() + p.getPStock());
        }
        return b;
    }
    
   public List<app.Produtos> getPorId(int id) {
        return (List<app.Produtos>) em.createNamedQuery("Produtos.findByPId").setParameter("pId", id).getResultList();
    }
    
    public void removerProduto(int id){
        Produtos p = em.find(Produtos.class, id);
        if (p != null){
            em.remove(p);
        }
    }
    
    public Produtos comprarProduto(Produtos p){
        Produtos b = em.find(Produtos.class, p.getPId());
        if(b != null){
            if(b.getPStock() >= p.getPStock()){
                b.setPStock(b.getPStock() - p.getPStock());
            }
        }
        return b;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
