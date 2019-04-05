package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.dao.TurmaDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class ServicoTurma {
    
    private TurmaDAO dao;

    public ServicoTurma() {
       dao = new TurmaDAO();
    }
    
    public void salvar(Turma entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Turma> getAll() {
        return dao.getAll();
    }
    
    public Turma getTurma(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getTurma(codigo);
    }
    
    
    public Turma remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}