package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma {
    
	// Constantes contendo o tamanho das colunas no banco de dados
	private final int TAMANHO_NOME = 100;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_codigo")
    private Integer codigo;
    
    @Column(name = "tur_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;
    
    @OneToOne
    @JoinColumn(name = "tur_disCodigo", referencedColumnName = "dis_codigo", nullable = false)
    private Disciplina fkDisciplina;
    
    @ManyToOne
    @JoinColumn(name = "tur_perCodigo", nullable = false)
    private Periodo fkPeriodo;
    
    @ManyToOne
    @JoinColumn(name = "tur_proCodigo", nullable = false)
    private Pessoa fkProfessor;
    
    @ManyToMany
	@JoinTable(name = "aluno_turma",
			joinColumns = @JoinColumn(name = "turma_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Pessoa> alunos;
    
    @OneToMany(mappedBy = "turma")
    private List<Aula> aulas;

    public Turma() {
        
    }

	public Turma(Integer codigo, String nome, Disciplina fkDisciplina, Periodo fkPeriodo, Pessoa fkProfessor, List<Pessoa> alunos, List<Aula> aulas) {
		this.codigo = codigo;
		this.nome = nome;
		this.fkDisciplina = fkDisciplina;
		this.fkPeriodo = fkPeriodo;
		this.fkProfessor = fkProfessor;
		this.alunos = alunos;
		this.aulas = aulas;
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

	public List<Pessoa> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Pessoa> alunos) {
		this.alunos = alunos;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
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
		if (!(obj instanceof Turma))
			return false;
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", nome=" + nome + ", fkDisciplina=" + fkDisciplina + ", fkPeriodo="
				+ fkPeriodo + ", fkProfessor=" + fkProfessor + ", alunos=" + alunos + ", aulas=" + aulas + "]";
	}
}