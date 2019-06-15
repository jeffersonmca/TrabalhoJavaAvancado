package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;

public class DAOLogin extends DAOGenerico<Login, Integer> {

    public List<Login> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select l from Login l "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and l.codigo = " + dado;
                }else if (opcao.equals("ID")) {
                    sql += " and l.id like '%" + dado + "%'";
                }else if (opcao.equals("ID USUARIO")) {
                    sql += " and l.usuario.codigo = " + dado;
                }
            }
            
            return em.createQuery(sql, Login.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }

    public Login buscarPorId(String id) throws ExcecaoDAO {
        
        try {            
            String sql = "select l from Login l "
                    + " where (1 = 1) "
                    + " and l.id like '" + id + "'";
            
            return em.createQuery(sql, Login.class).getSingleResult();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar o registro!");
        }
    }
}