package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

public class DAOTurma extends DAOGenerico<Turma, Integer> {

    public List<Turma> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select t from Turma t "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and t.codigo = " + Integer.parseInt(dado);
                }else if (opcao.equals("NOME")) {
                    sql += " and t.nome like '%" + (String) dado + "%'";
                }else if (opcao.equals("ID DISCIPLINA")) {
                    sql += " and t.fkDisciplina = " + Integer.parseInt(dado);
                }else if (opcao.equals("ID PERIODO")) {
                    sql += " and t.fkPeriodo = " + Integer.parseInt(dado);
                }else if (opcao.equals("ID PROFESSOR")) {
                    sql += " and t.fkProfessor = " + Integer.parseInt(dado);
                }
            }
            
            return em.createQuery(sql).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}