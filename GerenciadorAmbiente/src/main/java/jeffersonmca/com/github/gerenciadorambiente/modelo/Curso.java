package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Curso {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_codigo")
    private Integer codigo;
    
    @Column(name = "cur_codigo")
    private String nome;
    
    @JoinColumn(name = "cur_perCodigo")
    private Periodo fkPeriodo;

    public Curso() {
        
    }
    
    public Curso(Integer codigo, String nome, Periodo fkPeriodo) {
        this.codigo = codigo;
        this.nome = nome;
        this.fkPeriodo = fkPeriodo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Periodo getFkPeriodo() {
        return fkPeriodo;
    }

    public void setFkPeriodo(Periodo fkPeriodo) {
        this.fkPeriodo = fkPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.fkPeriodo);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fkPeriodo, other.fkPeriodo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\tfkPeriodo=" + fkPeriodo + "\n}";
    }
}