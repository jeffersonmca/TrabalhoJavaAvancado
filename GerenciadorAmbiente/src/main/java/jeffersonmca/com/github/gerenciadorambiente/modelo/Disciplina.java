package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Id;

public class Disciplina {
    
    @Id
    private Integer codigo;
    private String nome;
    private Integer cargaHoraria;
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cargaHoraria);
        hash = 97 * hash + Objects.hashCode(this.fkCurso);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cargaHoraria, other.cargaHoraria)) {
            return false;
        }
        if (!Objects.equals(this.fkCurso, other.fkCurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\tcargaHoraria=" + cargaHoraria + ",\n\tfkCurso=" + fkCurso + "\n}";
    }
}