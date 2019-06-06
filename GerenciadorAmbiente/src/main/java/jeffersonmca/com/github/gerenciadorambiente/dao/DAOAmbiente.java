package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;

public class DAOAmbiente extends DAOGenerico<Ambiente, Integer> {

    public List<Ambiente> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select a from Ambiente a "
                    + " where (1 = 1) ";
            
            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and a.codigo = " + Integer.parseInt(dado);
                }else if (opcao.equals("NOME")) {
                    sql += " and a.nome like '%" + (String) dado + "%'";
                }else if (opcao.equals("TIPO AMBIENTE")) {
                    sql += " and a.tipoAmbiente like '%" + (String) dado + "%'";
                }else if (opcao.equals("CAPACIDADE")) {
                    sql += " and a.capacidade = " + Integer.parseInt(dado);
                }else if (opcao.equals("LOCALIZAÇÃO")) {
                    sql += " and a.localizacao like '%" + (String) dado + "%'";
                }
            }
            
            return em.createQuery(sql).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}