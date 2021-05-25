/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author txavi
 */
@Entity
@Table(name = "VENDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v")
    , @NamedQuery(name = "Vendas.findByVId", query = "SELECT v FROM Vendas v WHERE v.vId = :vId")
    , @NamedQuery(name = "Vendas.findByVQuant", query = "SELECT v FROM Vendas v WHERE v.vQuant = :vQuant")
    , @NamedQuery(name = "Vendas.findByVData", query = "SELECT v FROM Vendas v WHERE v.vData = :vData")
    , @NamedQuery(name = "Vendas.findByVPrecototal", query = "SELECT v FROM Vendas v WHERE v.vPrecototal = :vPrecototal")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "V_ID")
    private Integer vId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "V_QUANT")
    private int vQuant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "V_DATA")
    @Temporal(TemporalType.DATE)
    private Date vData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "V_PRECOTOTAL")
    private double vPrecototal;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne(optional = false)
    private Produtos pId;

    public Vendas() {
    }

    public Vendas(Integer vId) {
        this.vId = vId;
    }

    public Vendas(Integer vId, int vQuant, Date vData, double vPrecototal) {
        this.vId = vId;
        this.vQuant = vQuant;
        this.vData = vData;
        this.vPrecototal = vPrecototal;
    }

    public Integer getVId() {
        return vId;
    }

    public void setVId(Integer vId) {
        this.vId = vId;
    }

    public int getVQuant() {
        return vQuant;
    }

    public void setVQuant(int vQuant) {
        this.vQuant = vQuant;
    }

    public Date getVData() {
        return vData;
    }

    public void setVData(Date vData) {
        this.vData = vData;
    }

    public double getVPrecototal() {
        return vPrecototal;
    }

    public void setVPrecototal(double vPrecototal) {
        this.vPrecototal = vPrecototal;
    }

    public Produtos getPId() {
        return pId;
    }

    public void setPId(Produtos pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vId != null ? vId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.vId == null && other.vId != null) || (this.vId != null && !this.vId.equals(other.vId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Vendas[ vId=" + vId + " ]";
    }
    
}
