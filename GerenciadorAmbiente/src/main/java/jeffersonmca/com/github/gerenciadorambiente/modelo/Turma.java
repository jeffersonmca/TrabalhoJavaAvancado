package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_codigo")
    private Integer codigo;
    
    @Column(name = "tur_nome")
    private String nome;
    
    @JoinColumn(name = "tur_disCodigo")
    private Disciplina fkDisciplina;
    
    @JoinColumn(name = "tur_perCodigo")
    private Periodo fkPeriodo;
    
    @JoinColumn(name = "tur_proCodigo")
    private Pessoa fkProfessor;
    
    @JoinColumn(name = "tur_aulCodigo")
    private Aula fkAula;
    
    @JoinColumn(name = "tur_aluCodigo")
    private Pessoa fkaluno;

    public Turma() {
        
    }

    public Turma(Integer codigo, String nome, Disciplina fkDisciplina, Periodo fkPeriodo, Pessoa fkProfessor, Aula fkAula, Pessoa fkaluno) {
        this.codigo = codigo;
        this.nome = nome;
        this.fkDisciplina = fkDisciplina;
        this.fkPeriodo = fkPeriodo;
        this.fkProfessor = fkProfessor;
        this.fkAula = fkAula;
        this.fkaluno = fkaluno;
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

    public Disciplina getFkDisciplina() {
        return fkDisciplina;
    }

    public void setFkDisciplina(Disciplina fkDisciplina) {
        this.fkDisciplina = fkDisciplina;
    }

    public Periodo getFkPeriodo() {
        return fkPeriodo;
    }

    public void setFkPeriodo(Periodo fkPeriodo) {
        this.fkPeriodo = fkPeriodo;
    }

    public Pessoa getFkProfessor() {
        return fkProfessor;
    }

    public void setFkProfessor(Pessoa fkProfessor) {
        this.fkProfessor = fkProfessor;
    }

    public Aula getFkAula() {
        return fkAula;
    }

    public void setFkAula(Aula fkAula) {
        this.fkAula = fkAula;
    }

    public Pessoa getFkaluno() {
        return fkaluno;
    }

    public void setFkaluno(Pessoa fkaluno) {
        this.fkaluno = fkaluno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.fkDisciplina);
        hash = 89 * hash + Objects.hashCode(this.fkPeriodo);
        hash = 89 * hash + Objects.hashCode(this.fkProfessor);
        hash = 89 * hash + Objects.hashCode(this.fkAula);
        hash = 89 * hash + Objects.hashCode(this.fkaluno);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fkDisciplina, other.fkDisciplina)) {
            return false;
        }
        if (!Objects.equals(this.fkPeriodo, other.fkPeriodo)) {
            return false;
        }
        if (!Objects.equals(this.fkProfessor, other.fkProfessor)) {
            return false;
        }
        if (!Objects.equals(this.fkAula, other.fkAula)) {
            return false;
        }
        if (!Objects.equals(this.fkaluno, other.fkaluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\tfkDisciplina=" + fkDisciplina + ",\n\tfkPeriodo=" + fkPeriodo + ",\n\tfkProfessor=" + fkProfessor + ",\n\tfkAula=" + fkAula + ",\n\tfkaluno=" + fkaluno + "\n}";
    }
}