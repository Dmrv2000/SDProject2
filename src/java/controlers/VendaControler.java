/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import app.Vendas;
import beans.VendasBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Dmrv2
 */

@Named (value = "VendaControler")
@RequestScoped
public class VendaControler {


    @EJB
    private VendasBean VBean;
    
    Vendas novaVenda = new Vendas(); 
    List<app.Vendas> VendaList = new ArrayList<>();
    

    public List<app.Vendas> getVendaList() {
        VendaList = VBean.getVendas();
        return VendaList;
    }

    public Vendas getNovaVenda() {
        return novaVenda;
    }

    public void setNovaVenda(Vendas novaVenda) {
        this.novaVenda = novaVenda;
    }
    
   
    
    public  String addNewVenda(){
        VBean.addVendas(novaVenda);
        VendaList = VBean.getVendas();
        return "admin.xhtml";
    }
    
   
    
  
    
   
}
