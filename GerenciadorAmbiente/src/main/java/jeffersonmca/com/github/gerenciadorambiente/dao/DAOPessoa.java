package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOPessoa {

	private EntityManager em;

	public DAOPessoa() throws ExcecaoConexao {
		em = Conexao.getConexao();
	}

	public void salvar(Pessoa instancia) throws ExcecaoDAO {
		try {

			em.getTransaction().begin();
			em.merge(instancia);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao salvar o Pessoa!");
		}
	}

	public List<Pessoa> getAll() throws ExcecaoDAO {
		try {
			return em.createQuery("Select c from Pessoa c", Pessoa.class).getResultList();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar todos os Pessoas!");
		}
	}

	public Pessoa getPessoa(Integer codigo) throws ExcecaoDAO {
		try {
			return em.find(Pessoa.class, codigo);
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar um Pessoa!");
		}
	}

	public Pessoa remover(Integer codigo) throws ExcecaoDAO {
		try {

			Pessoa aux = getPessoa(codigo);

			em.getTransaction().begin();
			em.remove(aux);
			em.getTransaction().commit();

			return aux;
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao remover um Pessoa!");
		}
	}
}

