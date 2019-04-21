package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOAula {

    private EntityManager em;

    public DAOAula() throws ExcecaoConexao {
        em = Conexao.getConexao();
    }

    public void salvar(Aula instancia) throws ExcecaoDAO {

        try {

            em.getTransaction().begin();
            em.merge(instancia);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao salvar a aula!");
        }
    }

    public List<Aula> getAll() throws ExcecaoDAO {

        try {

            return em.createQuery("Select a from Aula a", Aula.class).getResultList();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar todas as aulas!");
        }
    }

    public Aula getAula(Integer codigo) throws ExcecaoDAO {

        try {

            return em.find(Aula.class, codigo);

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar uma aula!");
        }
    }

    public Aula remover(Integer codigo) throws ExcecaoDAO {

        try {

            Aula aux = getAula(codigo);

            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();

            return aux;

        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao remover a aula!");
        }
    }
}