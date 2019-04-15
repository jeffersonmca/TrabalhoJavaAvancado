package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOPeriodo {

	private EntityManager em;

	public DAOPeriodo() throws ExcecaoConexao {
		em = Conexao.getConexao();
	}

	public void salvar(Periodo instancia) throws ExcecaoDAO {
		try {

			em.getTransaction().begin();
			em.merge(instancia);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao salvar o Periodo!");
		}
	}

	public List<Periodo> getAll() throws ExcecaoDAO {
		try {
			return em.createQuery("Select c from Periodo c", Periodo.class).getResultList();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar todos os Periodos!");
		}
	}

	public Periodo getPeriodo(Integer codigo) throws ExcecaoDAO {
		try {
			return em.find(Periodo.class, codigo);
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar um Periodo!");
		}
	}

	public Periodo remover(Integer codigo) throws ExcecaoDAO {
		try {

			Periodo aux = getPeriodo(codigo);

			em.getTransaction().begin();
			em.remove(aux);
			em.getTransaction().commit();

			return aux;
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao remover um Periodo!");
		}
	}
}