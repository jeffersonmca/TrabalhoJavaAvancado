package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOAmbiente {
    
    private EntityManager em;

    public DAOAmbiente() {
       em = Conexao.getConexao();
    }

    public void salvar(Ambiente instancia) {
        
        em.getTransaction().begin();
        em.merge(instancia);
        em.getTransaction().commit();
    }

    public List<Ambiente> getAll() {
        return em.createQuery("Select a from Ambiente a", Ambiente.class).getResultList();
    }
    
    public Ambiente getAmbiente(Integer codigo) {
        return em.find(Ambiente.class, codigo);
    }
    
    
    public Ambiente remover(Integer codigo) {
        
        Ambiente aux = getAmbiente(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}