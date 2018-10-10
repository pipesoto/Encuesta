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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByOpcCod", query = "SELECT o FROM Opcion o WHERE o.opcCod = :opcCod")
    , @NamedQuery(name = "Opcion.findByOpcDesc", query = "SELECT o FROM Opcion o WHERE o.opcDesc = :opcDesc")
    , @NamedQuery(name = "Opcion.findByPreCod", query = "SELECT o FROM Opcion o WHERE o.preCod = :preCod")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPC_COD")
    private Long opcCod;
    @Size(max = 100)
    @Column(name = "OPC_DESC")
    private String opcDesc;
    @JoinColumn(name = "PRE_COD", referencedColumnName = "PRE_COD")
    @ManyToOne
    private Pregunta preCod;

    public Opcion() {
    }

    public Opcion(Long opcCod) {
        this.opcCod = opcCod;
    }

    public Long getOpcCod() {
        return opcCod;
    }

    public void setOpcCod(Long opcCod) {
        this.opcCod = opcCod;
    }

    public String getOpcDesc() {
        return opcDesc;
    }

    public void setOpcDesc(String opcDesc) {
        this.opcDesc = opcDesc;
    }

    public Pregunta getPreCod() {
        return preCod;
    }

    public void setPreCod(Pregunta preCod) {
        this.preCod = preCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcCod != null ? opcCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcCod == null && other.opcCod != null) || (this.opcCod != null && !this.opcCod.equals(other.opcCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entity.Opcion[ opcCod=" + opcCod + " ]";
    }
    
}
