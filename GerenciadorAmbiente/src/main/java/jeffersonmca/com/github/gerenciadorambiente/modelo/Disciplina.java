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
public class Disciplina {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 70;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_codigo")
    private Integer codigo;
    
    @Column(name = "dis_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;
    
    @Column(name = "dis_cargaHoraria", nullable = false)
    private Integer cargaHoraria;
    
    @ManyToOne
    @JoinColumn(name = "dis_curCodigo", nullable = false)
    private Curso fkCurso;

    public Disciplina() {
        
    }
    
    public Disciplina(Integer codigo, String nome, Integer cargaHoraria, Curso fkCurso) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.fkCurso = fkCurso;
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
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
        if (!(obj instanceof Disciplina))
                return false;
        Disciplina other = (Disciplina) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return this.codigo + "-" + this.nome;
    }
}