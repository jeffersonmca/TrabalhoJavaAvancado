package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoPeriodo {
    
    private DAOPeriodo dao;

    public ServicoPeriodo() {
       dao = new DAOPeriodo();
    }
    
    public void salvar(Periodo entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Periodo> getAll() {
        return dao.getAll();
    }
    
    public Periodo getPeriodo(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        return dao.getPeriodo(codigo);
    }
    
    
    public Periodo remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}