package jeffersonmca.com.github.gerenciadorambiente.dao;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

public class DAOTurma extends DAOGenerico<Turma, Integer> {

    public Turma buscarPorCodigo(Turma turma) throws ExcecaoServico,  ExcecaoDAO {
        try {         
            
            String sql = "select t from Turma t "
                    + " where (1 = 1)"
                    + " and t.codigo = " + turma.getCodigo();
            Turma retorno = (Turma) em.createQuery(sql).getSingleResult();
            System.out.println("\taopa1");
            System.out.println(retorno.getAlunos());
            System.out.println("\taopa2");
            return retorno;
        } catch (Exception e) {
            throw new ExcecaoDAO("Houve erro ao pegar a turma!");
        }
    }
}