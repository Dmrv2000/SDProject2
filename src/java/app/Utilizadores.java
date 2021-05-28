/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author txavi
 */
@Entity
@Table(name = "UTILIZADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizadores.findAll", query = "SELECT u FROM Utilizadores u")
    , @NamedQuery(name = "Utilizadores.findByUId", query = "SELECT u FROM Utilizadores u WHERE u.uId = :uId")
    , @NamedQuery(name = "Utilizadores.findByUName", query = "SELECT u FROM Utilizadores u WHERE u.uName = :uName")
    , @NamedQuery(name = "Utilizadores.findByUPwd", query = "SELECT u FROM Utilizadores u WHERE u.uPwd = :uPwd")})
public class Utilizadores implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "U_PWD")
    private String uPwd;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "U_ID")
    private Integer uId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "U_NAME")
    private String uName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilizadores")
    private Administradores administradores;

    public Utilizadores() {
    }

    public Utilizadores(Integer uId) {
        this.uId = uId;
    }

    public Utilizadores(Integer uId, String uName, String uPwd) {
        this.uId = uId;
        this.uName = uName;
        this.uPwd = uPwd;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPwd() {
        return uPwd;
    }

    public void setUPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public Administradores getAdministradores() {
        return administradores;
    }

    public void setAdministradores(Administradores administradores) {
        this.administradores = administradores;
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
        if (!(object instanceof Utilizadores)) {
            return false;
        }
        Utilizadores other = (Utilizadores) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Utilizadores[ uId=" + uId + " ]";
    }
    
}
