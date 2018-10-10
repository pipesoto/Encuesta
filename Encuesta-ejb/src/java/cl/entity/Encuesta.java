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
@Table(name = "ENCUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByEncCod", query = "SELECT e FROM Encuesta e WHERE e.encCod = :encCod")
    , @NamedQuery(name = "Encuesta.findByEncTitle", query = "SELECT e FROM Encuesta e WHERE e.encTitle = :encTitle")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENC_COD")
    private Long encCod;
    @Size(max = 50)
    @Column(name = "ENC_TITLE")
    private String encTitle;
    @OneToMany(mappedBy = "encCod")
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "EST_COD", referencedColumnName = "EST_COD")
    @ManyToOne
    private Estado estCod;

    public Encuesta() {
    }

    public Encuesta(Long encCod) {
        this.encCod = encCod;
    }

    public Long getEncCod() {
        return encCod;
    }

    public void setEncCod(Long encCod) {
        this.encCod = encCod;
    }

    public String getEncTitle() {
        return encTitle;
    }

    public void setEncTitle(String encTitle) {
        this.encTitle = encTitle;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Estado getEstCod() {
        return estCod;
    }

    public void setEstCod(Estado estCod) {
        this.estCod = estCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encCod != null ? encCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.encCod == null && other.encCod != null) || (this.encCod != null && !this.encCod.equals(other.encCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Encuesta[ encCod=" + encCod + " ]";
    }
    
}
