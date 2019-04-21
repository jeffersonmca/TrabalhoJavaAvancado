package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Periodo {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_ENUM = 10;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_codigo")
    private Integer codigo;
    
    @Column(name = "per_ano", nullable = false)
    private Integer ano;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "per_semestre", nullable = false, length = TAMANHO_ENUM)
    private EnumSemestre semestre;

    public Periodo() {
        
    }

    public Periodo(Integer codigo, Integer ano, EnumSemestre semestre) {
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

    public EnumSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(EnumSemestre semestre) {
        this.semestre = semestre;
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
        if (!(obj instanceof Periodo))
                return false;
        Periodo other = (Periodo) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Periodo{\n" + "\tcodigo=" + codigo + ",\n\tano=" + ano + ",\n\tsemestre=" + semestre + "\n}";
    }
}