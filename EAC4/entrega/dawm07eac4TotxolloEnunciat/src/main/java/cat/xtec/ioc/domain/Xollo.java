
package cat.xtec.ioc.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Germán Flores
 */
@Entity
@Table(name = "xollos")
public class Xollo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Size(max = 100)
    @Column(name = "codi")
    protected String codi;
    
    @NotNull
    @Column(name = "numeroUnitats")
    protected Integer numeroUnitats;
    
    @NotNull
    @Column(name = "numeroReserves")
    protected Integer numeroReserves;
    
    @NotNull
    @Size(max = 250)
    @Column(name = "titol")
    protected String titol;
    
    @NotNull
    @Size(max = 250)
    @Column(name = "descripcio")
    protected String descripcio;

    public Xollo(String codi, Integer numeroUnitats, Integer numeroReserves, String titol, String descripcio) {
        this.codi = codi;
        this.numeroUnitats = numeroUnitats;
        this.numeroReserves = numeroReserves;
        this.titol = titol;
        this.descripcio = descripcio;
    }

    public Xollo() {
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Integer getNumeroUnitats() {
        return numeroUnitats;
    }

    public void setNumeroUnitats(Integer numeroUnitats) {
        this.numeroUnitats = numeroUnitats;
    }

    public Integer getNumeroReserves() {
        return numeroReserves;
    }

    public void setNumeroReserves(Integer numeroReserves) {
        this.numeroReserves = numeroReserves;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

   
    
}
