package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;

public class DAODisciplina extends DAOGenerico<Disciplina, Integer> {

    public List<Disciplina> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select d from Disciplina d "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and d.codigo = " + Integer.parseInt(dado);
                }else if (opcao.equals("NOME")) {
                    sql += " and d.nome like '%" + (String) dado + "%'";
                }else if (opcao.equals("CARGA HORARIA")) {
                    sql += " and d.cargaHoraria = " + Integer.parseInt(dado);
                }else if (opcao.equals("ID CURSO")) {
                    sql += " and d.fkCurso = " + Integer.parseInt(dado);
                }
            }
            
            return em.createQuery(sql).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}