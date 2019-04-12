package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aula {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aul_codigo")
    private Integer codigo;
    
    @Column(name = "aul_horarioInicio")
    private Date horarioInicio;
    
    @Column(name = "aul_horarioTermino")
    private Date horarioTermino;
    
    @Column(name = "aul_enumDiaSemana")
    private enumDiaSemana diaSemana;
    
    @ManyToOne
    @JoinColumn(name = "aul_ambCodigo")
    private Ambiente fkAmbiente;

    public Aula() {
        
    }
    
    public Aula(Integer codigo, Date horarioInicio, Date horarioTermino, enumDiaSemana diaSemana, Ambiente fkAmbiente) {
        this.codigo = codigo;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.diaSemana = diaSemana;
        this.fkAmbiente = fkAmbiente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(Date horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public enumDiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(enumDiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Ambiente getFkAmbiente() {
        return fkAmbiente;
    }

    public void setFkAmbiente(Ambiente fkAmbiente) {
        this.fkAmbiente = fkAmbiente;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.horarioInicio);
        hash = 89 * hash + Objects.hashCode(this.horarioTermino);
        hash = 89 * hash + Objects.hashCode(this.diaSemana);
        hash = 89 * hash + Objects.hashCode(this.fkAmbiente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.horarioInicio, other.horarioInicio)) {
            return false;
        }
        if (!Objects.equals(this.horarioTermino, other.horarioTermino)) {
            return false;
        }
        if (this.diaSemana != other.diaSemana) {
            return false;
        }
        if (!Objects.equals(this.fkAmbiente, other.fkAmbiente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aula{\n" + "\tcodigo=" + codigo + ",\n\thorarioInicio=" + horarioInicio + ",\n\thorarioTermino=" + horarioTermino + ",\n\tdiaSemana=" + diaSemana + ",\n\tfkAmbiente=" + fkAmbiente + "\n}";
    }
}