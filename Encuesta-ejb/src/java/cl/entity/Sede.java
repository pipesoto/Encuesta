/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joseg
 */
@Entity
@Table(name = "SEDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")
    , @NamedQuery(name = "Sede.findBySedCod", query = "SELECT s FROM Sede s WHERE s.sedCod = :sedCod")
    , @NamedQuery(name = "Sede.findBySedNombre", query = "SELECT s FROM Sede s WHERE s.sedNombre = :sedNombre")
    , @NamedQuery(name = "Sede.findBySedCiudad", query = "SELECT s FROM Sede s WHERE s.sedCiudad = :sedCiudad")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SED_COD")
    private Long sedCod;
    @Size(max = 50)
    @Column(name = "SED_NOMBRE")
    private String sedNombre;
    @Size(max = 20)
    @Column(name = "SED_CIUDAD")
    private String sedCiudad;

    public Sede() {
    }

    public Sede(Long sedCod) {
        this.sedCod = sedCod;
    }

    public Long getSedCod() {
        return sedCod;
    }

    public void setSedCod(Long sedCod) {
        this.sedCod = sedCod;
    }

    public String getSedNombre() {
        return sedNombre;
    }

    public void setSedNombre(String sedNombre) {
        this.sedNombre = sedNombre;
    }

    public String getSedCiudad() {
        return sedCiudad;
    }

    public void setSedCiudad(String sedCiudad) {
        this.sedCiudad = sedCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sedCod != null ? sedCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.sedCod == null && other.sedCod != null) || (this.sedCod != null && !this.sedCod.equals(other.sedCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Sede[ sedCod=" + sedCod + " ]";
    }
    
}
