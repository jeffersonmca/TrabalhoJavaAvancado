package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAula;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoAula {
    
    private DAOAula dao;

    public ServicoAula() {
       dao = new DAOAula();
    }
    
    public void salvar(Aula instancia) throws ExcecaoServico {
        
    	try {
    		
	        /*Regra de negocio*/
	    	if (Validacao.Aula(instancia)) {
				dao.salvar(instancia);
			}
	    	
    	} catch (ExcecaoDAO | ExcecaoValidacao e) {
    		throw new ExcecaoServico(e.getMessage());
    	}
    }

    public List<Aula> getAll() {
        return dao.getAll();
    }
    
    public Aula getAula(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
    		return dao.getAula(codigo);
    	}
    	
    	return null;
    }
    
    
    public Aula remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Aula aux = dao.getAula(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    }
}