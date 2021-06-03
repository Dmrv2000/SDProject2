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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.sql.Date;
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
    
    public String buyProduct() throws ClassNotFoundException, SQLException{
        prodBean.comprarProduto(novoProduto);
        productList = prodBean.getProducts();
        List<Produtos> c = prodBean.getPorId(novoProduto.getPId());
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DBProject2");
        PreparedStatement s = con.prepareStatement("insert into vendas(p_id,v_quant,v_data,v_precototal) values (?,?,?,?) ");
       s.setInt(1,novoProduto.getPId());
       s.setInt(2,novoProduto.getPStock());
       Date sqlDate = new Date(System.currentTimeMillis());
       s.setDate(3, sqlDate);
       Double x = Double.valueOf(novoProduto.getPStock());
       Double total = c.get(0).getPPrecovenda() * x;
       s.setDouble(4, total);
        boolean result = s.execute();
        /*
        nv.setPId(novoProduto);
        nv.setVQuant(novoProduto.getPStock()); 
        nv.setVPrecototal(novoProduto.getPStock() * novoProduto.getPPrecovenda());
        
        nv.setVData(date);
        
        VBean.addVendas(nv);*/
        return "users.xhtml";
        
        
        
        
    }
}
