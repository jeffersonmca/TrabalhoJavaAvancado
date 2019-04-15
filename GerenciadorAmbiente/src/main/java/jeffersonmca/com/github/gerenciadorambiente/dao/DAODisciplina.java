package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import javax.persistence.EntityManager;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.util.Conexao;

public class DAODisciplina {

	private EntityManager em;

	public DAODisciplina() throws ExcecaoConexao {
		em = Conexao.getConexao();
	}

	public void salvar(Disciplina instancia) throws ExcecaoDAO {
		try {

			em.getTransaction().begin();
			em.merge(instancia);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao salvar o Disciplina!");
		}
	}

	public List<Disciplina> getAll() throws ExcecaoDAO {
		try {
			return em.createQuery("Select c from Disciplina c", Disciplina.class).getResultList();
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar todos os Disciplinas!");
		}
	}

	public Disciplina getDisciplina(Integer codigo) throws ExcecaoDAO {
		try {
			return em.find(Disciplina.class, codigo);
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao pegar um Disciplina!");
		}
	}

	public Disciplina remover(Integer codigo) throws ExcecaoDAO {
		try {

			Disciplina aux = getDisciplina(codigo);

			em.getTransaction().begin();
			em.remove(aux);
			em.getTransaction().commit();

			return aux;
		} catch (Exception e) {
			throw new ExcecaoDAO("Houve erro ao remover um Disciplina!");
		}
	}
}