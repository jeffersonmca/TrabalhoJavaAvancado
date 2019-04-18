package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoPeriodo {
    
    private DAOPeriodo dao;

    public ServicoPeriodo() throws ExcecaoConexao {
       dao = new DAOPeriodo();
    }
    
    public void salvar(Periodo instancia) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Periodo(instancia)) {
	    		dao.salvar(instancia);
	    	}
        }catch (ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
        	throw new ExcecaoServico("Erro ao salvar camada Servico");
		}
    }

    public List<Periodo> getAll()throws ExcecaoDAO {
        return dao.getAll();
    }
    
    public Periodo getPeriodo(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	    		return dao.getPeriodo(codigo);
	    	}
	    	
	    	return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch(Exception e) {
			throw new ExcecaoServico("Erro ao pegar Periodo Camda Servico");
		}
    }
    
    
    public Periodo remover(Integer codigo) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Periodo aux = dao.getPeriodo(codigo);
	            
	            // Esta no BD?
	            if (Validacao.Alocado(aux)) {
	                return dao.remover(codigo);
	            }
	        }
	        
	        return null;
        }catch(ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
			throw new ExcecaoServico("Erro ao remover camada servico");
		}
    }
}