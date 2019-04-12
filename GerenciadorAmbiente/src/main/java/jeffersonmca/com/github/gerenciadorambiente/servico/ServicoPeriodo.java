package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;
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
    	if (Validacao.Identificador(codigo)) {
    		return dao.getPeriodo(codigo);
    	}
    	
    	return null;
    }
    
    
    public Periodo remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Periodo aux = dao.getPeriodo(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    } 
}