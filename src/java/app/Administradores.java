/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author txavi
 */
@Entity
@Table(name = "ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a")
    , @NamedQuery(name = "Administradores.findByUId", query = "SELECT a FROM Administradores a WHERE a.uId = :uId")})
public class Administradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_ID")
    private Integer uId;
    @JoinColumn(name = "U_ID", referencedColumnName = "U_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilizadores utilizadores;

    public Administradores() {
    }

    public Administradores(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Utilizadores getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(Utilizadores utilizadores) {
        this.utilizadores = utilizadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Administradores[ uId=" + uId + " ]";
    }
    
}
