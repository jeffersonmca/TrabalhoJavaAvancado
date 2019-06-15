package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;

public class DAOAmbiente extends DAOGenerico<Ambiente, Integer> {

    public List<Ambiente> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select a from Ambiente a "
                    + " where (1 = 1) ";
            
            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and a.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and a.nome like '%" + dado + "%'";
                }else if (opcao.equals("TIPO AMBIENTE")) {
                    sql += " and a.tipoAmbiente like '%" + dado + "%'";
                }else if (opcao.equals("CAPACIDADE")) {
                    sql += " and a.capacidade = " + dado;
                }else if (opcao.equals("LOCALIZAÇÃO")) {
                    sql += " and a.localizacao like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Ambiente.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}