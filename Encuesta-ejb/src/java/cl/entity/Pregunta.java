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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PREGUNTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByPreCod", query = "SELECT p FROM Pregunta p WHERE p.preCod = :preCod")
    , @NamedQuery(name = "Pregunta.findByPreDesc", query = "SELECT p FROM Pregunta p WHERE p.preDesc = :preDesc")
    , @NamedQuery(name = "Pregunta.findByEncCod", query = "SELECT p FROM Pregunta p WHERE p.encCod = :encCod")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRE_COD")
    private Long preCod;
    @Size(max = 200)
    @Column(name = "PRE_DESC")
    private String preDesc;
    @JoinColumn(name = "ENC_COD", referencedColumnName = "ENC_COD")
    @ManyToOne
    private Encuesta encCod;
    @OneToMany(mappedBy = "preCod")
    private List<Opcion> opcionList;

    public Pregunta() {
    }

    public Pregunta(Long preCod) {
        this.preCod = preCod;
    }

    public Long getPreCod() {
        return preCod;
    }

    public void setPreCod(Long preCod) {
        this.preCod = preCod;
    }

    public String getPreDesc() {
        return preDesc;
    }

    public void setPreDesc(String preDesc) {
        this.preDesc = preDesc;
    }

    public Encuesta getEncCod() {
        return encCod;
    }

    public void setEncCod(Encuesta encCod) {
        this.encCod = encCod;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preCod != null ? preCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preCod == null && other.preCod != null) || (this.preCod != null && !this.preCod.equals(other.preCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Pregunta[ preCod=" + preCod + " ]";
    }
    
}
