package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Login {
    
    // Constantes contendo o tamanho das colunas no banco de dados
    @Transient
    private final int TAMANHO_ID = 40;
    
    @Transient
    private final int TAMANHO_SENHA = 20;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_codigo")
    private Integer codigo;
    
    @Column(name = "log_id", nullable = false, length = TAMANHO_ID)
    private String id;
    
    @Column(name = "log_senha", nullable = false, length = TAMANHO_SENHA)
    private String senha;
    
    @ManyToOne
    @JoinColumn(name = "log_pesCodigo", nullable = false)
    private Pessoa usuario;

    public Login() {
        
    }    
    
    public Login(Integer codigo, String id, String senha, Pessoa usuario) {
        this.codigo = codigo;
        this.id = id;
        this.senha = senha;
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Login other = (Login) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id;
    }   
}