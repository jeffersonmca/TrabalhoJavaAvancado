package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAODisciplina {
    
    private EntityManager em;

    public DAODisciplina() {
       em = Conexao.getConexao();
    }

    public void salvar(Disciplina entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Disciplina> getAll() {
        return em.createQuery("Select d from Disciplina d", Disciplina.class).getResultList();
    }
    
    public Disciplina getDisciplina(Integer codigo) {
        return em.find(Disciplina.class, codigo);
    }
    
    
    public Disciplina remover(Integer codigo) {
        
        Disciplina aux = getDisciplina(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}