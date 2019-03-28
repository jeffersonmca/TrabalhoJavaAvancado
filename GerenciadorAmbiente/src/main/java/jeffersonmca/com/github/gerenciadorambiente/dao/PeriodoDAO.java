package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class PeriodoDAO {
    
    private EntityManager em;

    public PeriodoDAO() {
       em = Conexao.getConexao();
    }

    public void salvar(Periodo entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Periodo> getAll() {
        return em.createQuery("Select p from Periodo p", Periodo.class).getResultList();
    }
    
    public Periodo getPeriodo(Integer codigo) {
        return em.find(Periodo.class, codigo);
    }
    
    
    public Periodo remover(Integer codigo) {
        
        Periodo aux = getPeriodo(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}