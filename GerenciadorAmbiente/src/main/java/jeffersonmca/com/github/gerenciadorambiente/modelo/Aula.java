package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Aula {
 
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_ENUM = 15;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aul_codigo")
    private Integer codigo;    
    
    @Temporal(TemporalType.TIME)
    @Column(name = "aul_horarioInicio", nullable = false)
    private Date horarioInicio;

    @Temporal(TemporalType.TIME)
    @Column(name = "aul_horarioTermino", nullable = false)
    private Date horarioTermino;

    @Enumerated(EnumType.STRING)
    @Column(name = "aul_enumDiaSemana", nullable = false, length = TAMANHO_ENUM)
    private EnumDiaSemana diaSemana;
    
    @ManyToOne
    @JoinColumn(name = "aul_ambCodigo", nullable = false)
    private Ambiente fkAmbiente;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Turma turma;

    public Aula() {
        
    }

    public Aula(Integer codigo, Date horarioInicio, Date horarioTermino, EnumDiaSemana diaSemana, Ambiente fkAmbiente, Turma turma) {
        this.codigo = codigo;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.diaSemana = diaSemana;
        this.fkAmbiente = fkAmbiente;
        this.turma = turma;
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

    public EnumDiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(EnumDiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Ambiente getFkAmbiente() {
        return fkAmbiente;
    }

    public void setFkAmbiente(Ambiente fkAmbiente) {
        this.fkAmbiente = fkAmbiente;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (!(obj instanceof Aula))
                return false;
        Aula other = (Aula) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aula [codigo=" + codigo + ", horarioInicio=" + horarioInicio + ", horarioTermino=" + horarioTermino
                        + ", diaSemana=" + diaSemana + ", fkAmbiente=" + fkAmbiente + ", turma=" + turma + "]";
    }
}