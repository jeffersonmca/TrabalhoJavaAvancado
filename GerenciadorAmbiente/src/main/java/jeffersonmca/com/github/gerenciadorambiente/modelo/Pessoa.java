package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.List;
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
import javax.persistence.Transient;

@Entity
public class Pessoa {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 50;
    
    @Transient
    private final int TAMANHO_EMAIL = 75;
    
    @Transient
    private final int TAMANHO_ENUM = 15;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private Integer codigo;
    
    @Column(name = "pes_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;
    
    @Column(name = "pes_email", nullable = false, length = TAMANHO_EMAIL)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "pes_tipoPessoa", nullable = false, length = TAMANHO_ENUM)
    private EnumTipoPessoa tipoPessoa;
    
    @ManyToMany
    @JoinTable(name = "aluno_turma",
                    joinColumns = @JoinColumn(name = "aluno_id"),
                    inverseJoinColumns = @JoinColumn(name = "turma_id"))
    private List<Turma> turmas;

    public Pessoa() {
        
    }

    public Pessoa(Integer codigo, String nome, String email, EnumTipoPessoa tipoPessoa) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.tipoPessoa = tipoPessoa;
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

    public EnumTipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
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
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}