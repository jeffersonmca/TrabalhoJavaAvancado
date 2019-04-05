package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOCurso {
    
    private EntityManager em;

    public DAOCurso() {
       em = Conexao.getConexao();
    }

    public void salvar(Curso entidade) {
        
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public List<Curso> getAll() {
        return em.createQuery("Select c from Curso c", Curso.class).getResultList();
    }
    
    public Curso getCurso(Integer codigo) {
        return em.find(Curso.class, codigo);
    }
    
    
    public Curso remover(Integer codigo) {
        
        Curso aux = getCurso(codigo);
        
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();
        
        return aux;
    }
}