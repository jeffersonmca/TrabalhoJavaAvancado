package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private Integer codigo;
    
    @Column(name = "pes_nome")
    private String nome;
    
    @Column(name = "pes_email")
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "pes_tipoPessoa")
    private enumTipoPessoa tipoPessoa;
    
    @ManyToMany
	@JoinTable(name = "aluno_turma",
			joinColumns = @JoinColumn(name = "aluno_id"),
			inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas;

    public Pessoa() {
        
    }

	public Pessoa(Integer codigo, String nome, String email, enumTipoPessoa tipoPessoa, List<Turma> turmas) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.tipoPessoa = tipoPessoa;
		this.turmas = turmas;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public enumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(enumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
		result = prime * result + ((turmas == null) ? 0 : turmas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		if (turmas == null) {
			if (other.turmas != null)
				return false;
		} else if (!turmas.equals(other.turmas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", tipoPessoa=" + tipoPessoa
				+ ", turmas=" + turmas + "]";
	}
}