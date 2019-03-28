package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class AulaDAO {
    
    private EntityManager em;

    public AulaDAO() {
       em = Conexao.getConexao();
    }

    public void salvar(Aula entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Aula> getAll() {
        return em.createQuery("Select a from Aula a", Aula.class).getResultList();
    }
    
    public Aula getAula(Integer codigo) {
        return em.find(Aula.class, codigo);
    }
    
    
    public Aula remover(Integer codigo) {
        
        Aula aux = getAula(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}