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

    public List<Pessoa> buscarPor(String opcao, Object dado) throws ExcecaoDAO {
        
        try {         
            
            String sql = "select p from Pessoa p "
                    + " where (1 = 1) ";

            if (!(opcao.equals("SEM FILTRO"))) {
               
                if (opcao.equals("CODIGO")) {
                    sql += " and p.codigo = " + dado;
                }else if (opcao.equals("NOME")) {
                    sql += " and p.nome like '%" + dado + "%'";
                }else if (opcao.equals("E-MAIL")) {
                    sql += " and p.email like '%" + dado + "%'";
                }else if (opcao.equals("TIPO PESSOA")) {
                    sql += " and p.tipoPessoa like '%" + dado + "%'";
                }
            }
            
            return em.createQuery(sql, Pessoa.class).getResultList();
            
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os registros!");
        }
    }

    public List<Pessoa> buscarAlunosForaDaGrid(List<Pessoa> alunos) throws ExcecaoDAO {
        try {         
            
            String sql = "select p from Pessoa p "
                    + " where (1 = 1)"
                    + " and p.tipoPessoa like '%ALUNO%' ";
            
            for (Pessoa a : alunos) {
                if (a != null) {
                    sql += " and p.codigo != " + a.getCodigo();
                }
            }
            
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os alunos!");
        }
    }
}