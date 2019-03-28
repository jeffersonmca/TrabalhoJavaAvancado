package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class PessoaDAO {
    
    private EntityManager em;

    public PessoaDAO() {
       em = Conexao.getConexao();
    }

    public void salvar(Pessoa entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Pessoa> getAll() {
        return em.createQuery("Select p from Pessoa p", Pessoa.class).getResultList();
    }
    
    public Pessoa getPessoa(Integer codigo) {
        return em.find(Pessoa.class, codigo);
    }
    
    
    public Pessoa remover(Integer codigo) {
        
        Pessoa aux = getPessoa(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}