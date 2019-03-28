package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Id;

public class Pessoa {
    
    @Id
    private Integer codigo;
    private String nome;
    private String email;
    private enumTipoPessoa tipoPessoa;

    public Pessoa() {
        
    }

    public Pessoa(Integer codigo, String nome, String email, enumTipoPessoa tipoPessoa) {
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

    public enumTipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(enumTipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.codigo);
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.tipoPessoa);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (this.tipoPessoa != other.tipoPessoa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\temail=" + email + ",\n\ttipoPessoa=" + tipoPessoa + "\n}";
    }
}