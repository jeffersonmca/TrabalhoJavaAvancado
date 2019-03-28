package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Ambiente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amb_codigo")
    private Integer codigo;
    
    @Column(name = "amb_nome")
    private String nome;
    
    @Column(name = "amb_tipCodigo")
    private enumTipoAmbiente tipoAmbiente;
    
    @Column(name = "amb_capacidade")
    private Integer capacidade;
    
    @Column(name = "amb_localizacao")
    private String localizacao;

    public Ambiente() {
        
    }

    public Ambiente(Integer codigo, String nome, enumTipoAmbiente tipoAmbiente, Integer capacidade, String localizacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoAmbiente = tipoAmbiente;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
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

    public enumTipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(enumTipoAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.tipoAmbiente);
        hash = 67 * hash + Objects.hashCode(this.capacidade);
        hash = 67 * hash + Objects.hashCode(this.localizacao);
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
        final Ambiente other = (Ambiente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.localizacao, other.localizacao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (this.tipoAmbiente != other.tipoAmbiente) {
            return false;
        }
        if (!Objects.equals(this.capacidade, other.capacidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ambiente{\n" + "\tcodigo=" + codigo + ",\n\tnome=" + nome + ",\n\ttipoAmbiente=" + tipoAmbiente + ",\n\tcapacidade=" + capacidade + ",\n\tlocalizacao=" + localizacao + "\n}";
    }
}