/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import app.Produtos;
import beans.ProdBean;
import java.util.ArrayList;
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
    
    Produtos novoProduto = new Produtos(); 
    
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
}
