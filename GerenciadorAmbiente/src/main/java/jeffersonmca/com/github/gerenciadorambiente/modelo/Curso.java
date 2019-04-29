package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Curso {
 
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 80;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_codigo")
    private Integer codigo;
    
    @Column(name = "cur_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "cur_perCodigo", nullable = false)
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
        if (!(obj instanceof Curso))
                return false;
        Curso other = (Curso) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Curso{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\tfkPeriodo=" + fkPeriodo + "\n}";
    }
}