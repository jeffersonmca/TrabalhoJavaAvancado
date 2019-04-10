package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAODisciplina;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoDisciplina {
    
    private DAODisciplina dao;

    public ServicoDisciplina() {
       dao = new DAODisciplina();
    }
    
    public void salvar(Disciplina entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Disciplina> getAll() {
        return dao.getAll();
    }
    
    public Disciplina getDisciplina(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        return dao.getDisciplina(codigo);
    }
    
    
    public Disciplina remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}