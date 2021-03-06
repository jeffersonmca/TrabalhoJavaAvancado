package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;

public class DAOCurso extends DAOGenerico<Curso, Integer> {

    public List<Curso> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select c from Curso c "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and c.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and c.nome like '%" + dado + "%'";
                }else if (opcao.equals("ID PERIODO")) {
                    sql += " and c.fkPeriodo.codigo = " + dado;
                }
            }
            
            return em.createQuery(sql, Curso.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}