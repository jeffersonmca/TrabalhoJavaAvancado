package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAOTurma {

	private EntityManager em;

	public DAOTurma() throws ExcecaoConexao {
		em = Conexao.getConexao();
	}

	public void salvar(Turma instancia) throws ExcecaoDAO {
		try {

			em.getTransaction().begin();
			em.merge(instancia);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao salvar o Turma!");
		}
	}

	public List<Turma> getAll() throws ExcecaoDAO {
		try {
			return em.createQuery("Select c from Turma c", Turma.class).getResultList();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar todos os Turmas!");
		}
	}

	public Turma getTurma(Integer codigo) throws ExcecaoDAO {
		try {
			return em.find(Turma.class, codigo);
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar um Turma!");
		}
	}

	public Turma remover(Integer codigo) throws ExcecaoDAO {
		try {

			Turma aux = getTurma(codigo);

			em.getTransaction().begin();
			em.remove(aux);
			em.getTransaction().commit();

			return aux;
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao remover um Turma!");
		}
	}
}

