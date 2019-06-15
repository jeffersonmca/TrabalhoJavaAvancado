package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;

public class DAOPeriodo extends DAOGenerico<Periodo, Integer> {

    public List<Periodo> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Periodo p "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("ANO")) {
                    sql += " and p.ano = " + dado;
                }else if (opcao.equals("SEMESTRE")) {
                    sql += " and p.semestre like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Periodo.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}