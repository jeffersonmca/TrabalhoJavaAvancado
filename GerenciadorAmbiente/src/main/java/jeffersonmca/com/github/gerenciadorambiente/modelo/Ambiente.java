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
public class Ambiente {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_NOME = 40;
    
    @Transient
    private final int TAMANHO_ENUM = 20;
    
    @Transient
    private final int TAMANHO_LOCALIZACAO = 600;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amb_codigo")
    private Integer codigo;

    @Column(name = "amb_nome", nullable = false, length = TAMANHO_NOME)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "amb_tipCodigo", length = TAMANHO_ENUM)
    private EnumTipoAmbiente tipoAmbiente;
    
    @Column(name = "amb_capacidade")
    private Integer capacidade;
    
    @Column(name = "amb_localizacao", length = TAMANHO_LOCALIZACAO)
    private String localizacao;

    public Ambiente() {
        
    }

    public Ambiente(Integer codigo, String nome, EnumTipoAmbiente tipoAmbiente, Integer capacidade, String localizacao) {
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

    public EnumTipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(EnumTipoAmbiente tipoAmbiente) {
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
        if (!(obj instanceof Ambiente))
                return false;
        Ambiente other = (Ambiente) obj;
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