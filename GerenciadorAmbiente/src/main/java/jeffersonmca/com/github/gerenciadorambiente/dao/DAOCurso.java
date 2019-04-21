package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOCurso {

    private EntityManager em;

    public DAOCurso() throws ExcecaoConexao {
        em = Conexao.getConexao();
    }

    public void salvar(Curso instancia) throws ExcecaoDAO {

        try {

            em.getTransaction().begin();
            em.merge(instancia);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao salvar o curso!");
        }
    }

    public List<Curso> getAll() throws ExcecaoDAO {

        try {

            return em.createQuery("Select c from Curso c", Curso.class).getResultList();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar todos os cursos!");
        }
    }

    public Curso getCurso(Integer codigo) throws ExcecaoDAO {

        try {

            return em.find(Curso.class, codigo);

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar um curso!");
        }
    }

    public Curso remover(Integer codigo) throws ExcecaoDAO {

        try {

            Curso aux = getCurso(codigo);

            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();

            return aux;

        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao remover o curso!");
        }
    }
}