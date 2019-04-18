package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPessoa;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoPessoa {
    
    private DAOPessoa dao;

    public ServicoPessoa() throws ExcecaoConexao {
       dao = new DAOPessoa();
    }
    
    public void salvar(Pessoa instancia) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Pessoa(instancia)) {
	    		dao.salvar(instancia);
	    	}
        }catch (ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
        	throw new ExcecaoServico("Erro ao salvar camada Servico");
		}
    }

    public List<Pessoa> getAll()throws ExcecaoDAO {
        return dao.getAll();
    }
    
    public Pessoa getPessoa(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	    		return dao.getPessoa(codigo);
	    	}
	    	
	    	return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch(Exception e) {
			throw new ExcecaoServico("Erro ao pegar Pessoa Camda Servico");
		}
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Pessoa aux = dao.getPessoa(codigo);
	            
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