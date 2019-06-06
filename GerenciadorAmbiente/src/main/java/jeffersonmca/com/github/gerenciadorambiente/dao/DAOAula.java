package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;

public class DAOAula extends DAOGenerico<Aula, Integer> {
    
    public List<Aula> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select a from Aula a "
                    + " where (1 = 1) ";
        
            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and a.codigo = " + Integer.parseInt(dado);
                }else if (opcao.equals("HORARIO INICIO")) {
                    sql += " and a.horarioInicio like '%" + (String) dado + "%'";
                }else if (opcao.equals("HORARIO TERMINO")) {
                    sql += " and a.horarioTermino like '%" + (String) dado + "%'";
                }else if (opcao.equals("DIA SEMANA")) {
                    sql += " and a.diaSemana like '%" + (String) dado + "%'";
                }else if (opcao.equals("ID AMBIENTE")) {
                    sql += " and a.fkAmbiente = " + Integer.parseInt(dado);
                }else if (opcao.equals("ID TURMA")) {
                    sql += " and a.turma = " + Integer.parseInt(dado);
                }
            }
            
            return em.createQuery(sql).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }
}