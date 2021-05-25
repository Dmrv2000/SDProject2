/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author txavi
 */
@Entity
@Table(name = "PRODUTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findByPId", query = "SELECT p FROM Produtos p WHERE p.pId = :pId")
    , @NamedQuery(name = "Produtos.findByPName", query = "SELECT p FROM Produtos p WHERE p.pName = :pName")
    , @NamedQuery(name = "Produtos.findByPStock", query = "SELECT p FROM Produtos p WHERE p.pStock = :pStock")
    , @NamedQuery(name = "Produtos.findByPPrecovenda", query = "SELECT p FROM Produtos p WHERE p.pPrecovenda = :pPrecovenda")
    , @NamedQuery(name = "Produtos.findByPPrecocompra", query = "SELECT p FROM Produtos p WHERE p.pPrecocompra = :pPrecocompra")
    , @NamedQuery(name = "Produtos.findByPCategoria", query = "SELECT p FROM Produtos p WHERE p.pCategoria = :pCategoria")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_ID")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P_NAME")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_STOCK")
    private int pStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_PRECOVENDA")
    private double pPrecovenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "P_PRECOCOMPRA")
    private double pPrecocompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P_CATEGORIA")
    private String pCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Vendas> vendasCollection;

    public Produtos() {
    }

    public Produtos(Integer pId) {
        this.pId = pId;
    }

    public Produtos(Integer pId, String pName, int pStock, double pPrecovenda, double pPrecocompra, String pCategoria) {
        this.pId = pId;
        this.pName = pName;
        this.pStock = pStock;
        this.pPrecovenda = pPrecovenda;
        this.pPrecocompra = pPrecocompra;
        this.pCategoria = pCategoria;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getPStock() {
        return pStock;
    }

    public void setPStock(int pStock) {
        this.pStock = pStock;
    }

    public double getPPrecovenda() {
        return pPrecovenda;
    }

    public void setPPrecovenda(double pPrecovenda) {
        this.pPrecovenda = pPrecovenda;
    }

    public double getPPrecocompra() {
        return pPrecocompra;
    }

    public void setPPrecocompra(double pPrecocompra) {
        this.pPrecocompra = pPrecocompra;
    }

    public String getPCategoria() {
        return pCategoria;
    }

    public void setPCategoria(String pCategoria) {
        this.pCategoria = pCategoria;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Produtos[ pId=" + pId + " ]";
    }
    
}
