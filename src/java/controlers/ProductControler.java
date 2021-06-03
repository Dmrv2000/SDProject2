/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import app.Produtos;
import app.Vendas;

import beans.ProdBean;
import beans.VendasBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Dmrv2
 */

@Named (value = "productControler")
@RequestScoped
public class ProductControler {


    @EJB
    private ProdBean prodBean;
    private VendasBean VBean;
     
    
    Produtos novoProduto = new Produtos(); 
Vendas nv = new Vendas();
    public Produtos getNovoProduto() {
        return novoProduto;
    }

    public void setNovoProduto(Produtos novoProduto) {
        this.novoProduto = novoProduto;
    }
    
    List<app.Produtos> productList = new ArrayList<>();
    public List<app.Produtos> getProductList() {
        productList = prodBean.getProducts();
        return productList;
    }
    
    public String addNewProduct(){
        prodBean.addProduct(novoProduto);
        productList = prodBean.getProducts();
        return "admin.xhtml";
    }
    
    public String deleteProduct(){
        
        prodBean.removerProduto(novoProduto.getPId());
        productList = prodBean.getProducts();
        return "admin.xhtml";
    }
    
    public String editProduct(){
        
        prodBean.editProduct(novoProduto);
        productList = prodBean.getProducts();
        
        return "admin.xhtml";
    }
    
    public String buyProduct(){
        prodBean.comprarProduto(novoProduto);
        productList = prodBean.getProducts();
        
        
       
        
        nv.setPId(novoProduto);
        nv.setVQuant(novoProduto.getPStock()); 
        nv.setVPrecototal(novoProduto.getPStock() * novoProduto.getPPrecovenda());
        Date date = new Date(); 
        nv.setVData(date);
        
        VBean.addVendas(nv);
        return "users.xhtml";
        
        
        
        
    }
}
