package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_codigo")
    private Integer codigo;
    
    @Column(name = "tur_nome")
    private String nome;
    
    @OneToOne
    @JoinColumn(name = "tur_disCodigo", referencedColumnName = "dis_codigo")
    private Disciplina fkDisciplina;
    
    @ManyToOne
    @JoinColumn(name = "tur_perCodigo")
    private Periodo fkPeriodo;
    
    @ManyToOne
    @JoinColumn(name = "tur_proCodigo")
    private Pessoa fkProfessor;
    
    @OneToMany
    private List<Aula> aulas;
    
    @ManyToMany(mappedBy="turmas")
    private List<Pessoa> alunos;

    public Turma() {
        
    }

	public Turma(Integer codigo, String nome, Disciplina fkDisciplina, Periodo fkPeriodo, Pessoa fkProfessor,
			List<Aula> aulas, List<Pessoa> alunos) {
		this.codigo = codigo;
		this.nome = nome;
		this.fkDisciplina = fkDisciplina;
		this.fkPeriodo = fkPeriodo;
		this.fkProfessor = fkProfessor;
		this.aulas = aulas;
		this.alunos = alunos;
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

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Pessoa> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Pessoa> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fkDisciplina == null) ? 0 : fkDisciplina.hashCode());
		result = prime * result + ((fkPeriodo == null) ? 0 : fkPeriodo.hashCode());
		result = prime * result + ((fkProfessor == null) ? 0 : fkProfessor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Turma))
			return false;
		Turma other = (Turma) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fkDisciplina == null) {
			if (other.fkDisciplina != null)
				return false;
		} else if (!fkDisciplina.equals(other.fkDisciplina))
			return false;
		if (fkPeriodo == null) {
			if (other.fkPeriodo != null)
				return false;
		} else if (!fkPeriodo.equals(other.fkPeriodo))
			return false;
		if (fkProfessor == null) {
			if (other.fkProfessor != null)
				return false;
		} else if (!fkProfessor.equals(other.fkProfessor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", nome=" + nome + ", fkDisciplina=" + fkDisciplina + ", fkPeriodo="
				+ fkPeriodo + ", fkProfessor=" + fkProfessor + ", aulas=" + aulas + ", alunos=" + alunos + "]";
	}
}