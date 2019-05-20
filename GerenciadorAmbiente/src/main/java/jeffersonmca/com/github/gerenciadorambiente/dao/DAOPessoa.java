package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;

public class DAOPessoa extends DAOGenerico<Pessoa, Integer> {

    public List<Pessoa> buscarTodosProfessores() throws ExcecaoDAO {
        try {         
            
            String sql = "select p from Pessoa p "
                    + " where (1 = 1)"
                    + " and p.tipoPessoa like '%PROFESSOR%' ";
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar todos os professores!");
        }
    }
}