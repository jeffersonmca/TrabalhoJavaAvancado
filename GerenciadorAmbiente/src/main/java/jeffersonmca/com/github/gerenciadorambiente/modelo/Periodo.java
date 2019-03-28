package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_codigo")
    private Integer codigo;
    
    @Column(name = "per_ano")
    private Integer ano;
    
    @Column(name = "per_semestre")
    private enumSemestre semestre;

    public Periodo() {
        
    }

    public Periodo(Integer codigo, Integer ano, enumSemestre semestre) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public enumSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(enumSemestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.ano);
        hash = 19 * hash + Objects.hashCode(this.semestre);
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
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Periodo{\n" + "\tcodigo=" + codigo + ",\n\tano=" + ano + ",\n\tsemestre=" + semestre + "\n}";
    }
}