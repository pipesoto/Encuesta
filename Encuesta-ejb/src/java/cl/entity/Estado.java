/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
 * @author joseg
 */
@Entity
@Table(name = "ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByEstCod", query = "SELECT e FROM Estado e WHERE e.estCod = :estCod")
    , @NamedQuery(name = "Estado.findByEstDesc", query = "SELECT e FROM Estado e WHERE e.estDesc = :estDesc")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EST_COD")
    private Long estCod;
    @Size(max = 20)
    @Column(name = "EST_DESC")
    private String estDesc;
    @OneToMany(mappedBy = "estCod")
    private List<Encuesta> encuestaList;

    public Estado() {
    }

    public Estado(Long estCod) {
        this.estCod = estCod;
    }

    public Long getEstCod() {
        return estCod;
    }

    public void setEstCod(Long estCod) {
        this.estCod = estCod;
    }

    public String getEstDesc() {
        return estDesc;
    }

    public void setEstDesc(String estDesc) {
        this.estDesc = estDesc;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estCod != null ? estCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estCod == null && other.estCod != null) || (this.estCod != null && !this.estCod.equals(other.estCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Estado[ estCod=" + estCod + " ]";
    }
    
}
