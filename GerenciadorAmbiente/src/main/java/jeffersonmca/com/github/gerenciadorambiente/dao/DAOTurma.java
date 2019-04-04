package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class TurmaDAO {
    
    private EntityManager em;

    public TurmaDAO() {
       em = Conexao.getConexao();
    }

    public void salvar(Turma entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Turma> getAll() {
        return em.createQuery("Select p from Turma p", Turma.class).getResultList();
    }
    
    public Turma getTurma(Integer codigo) {
        return em.find(Turma.class, codigo);
    }
    
    
    public Turma remover(Integer codigo) {
        
        Turma aux = getTurma(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}