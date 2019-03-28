package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.dao.DisciplinaDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class DisciplinaServico {
    
    private DisciplinaDAO dao;

    public DisciplinaServico() {
       dao = new DisciplinaDAO();
    }
    
    public void salvar(Disciplina entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Disciplina> getAll() {
        return dao.getAll();
    }
    
    public Disciplina getDisciplina(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getDisciplina(codigo);
    }
    
    
    public Disciplina remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}