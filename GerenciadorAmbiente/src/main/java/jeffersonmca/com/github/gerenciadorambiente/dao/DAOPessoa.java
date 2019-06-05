package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

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

    public List<Pessoa> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        try {         
            
            String sql = "select p from Pessoa p "
                    + " where (1 = 1)"
                    + " and p.tipoPessoa like '%ALUNO%' ";
            
            if (opcao.equals("ID")) {
                sql += " and p.codigo = " + dado;
            }else if (opcao.equals("NOME")) {
                sql += " and p.nome like '%" + dado + "%'";
            }else if (opcao.equals("E-MAIL")) {
                sql += " and p.email like '%" + dado + "%'";
            }
            
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar os alunos!");
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