package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOAmbiente {

    private EntityManager em;

    public DAOAmbiente() throws ExcecaoConexao {
        em = Conexao.getConexao();
    }

    public void salvar(Ambiente instancia) throws ExcecaoDAO {

        try {

            em.getTransaction().begin();
            em.merge(instancia);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao salvar o ambiente!");
        }
    }

    public List<Ambiente> getAll() throws ExcecaoDAO {

        try {

            return em.createQuery("Select a from Ambiente a", Ambiente.class).getResultList();

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar todos os ambientes!");
        }
    }

    public Ambiente getAmbiente(Integer codigo) throws ExcecaoDAO {

        try {

            return em.find(Ambiente.class, codigo);

        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar um ambiente!");
        }
    }

    public Ambiente remover(Integer codigo) throws ExcecaoDAO {

        try {

            Ambiente aux = getAmbiente(codigo);

            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();

            return aux;

        } catch (ExcecaoDAO e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao remover o ambiente!");
        }
    }
}