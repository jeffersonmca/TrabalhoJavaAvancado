package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAula;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoAula {
    
    private DAOAula dao;

    public ServicoAula()throws ExcecaoConexao {
       dao = new DAOAula();
    }
    
    public void salvar(Aula instancia) throws ExcecaoServico, ExcecaoDAO, ExcecaoValidacao {
        
    	try {
    		
	        /*Regra de negocio*/
	    	if (Validacao.Aula(instancia)) {
				dao.salvar(instancia);
			}
	    	
    	} catch (ExcecaoDAO e) {
    		throw e;
    	}catch(ExcecaoValidacao e) {
    		throw e;
    	}catch(Exception e) {
    		throw new ExcecaoServico("Erro ao Salva Aula, camada servico");
    	}
    }

    public List<Aula> getAll() throws ExcecaoDAO ,ExcecaoValidacao, ExcecaoServico{
        return dao.getAll();
    }
    
    public Aula getAula(Integer codigo) throws ExcecaoServico, ExcecaoDAO{
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)){
	    		return dao.getAula(codigo);
	    	}
	    	
	    	return null;
        
        }catch(ExcecaoDAO e) {
        	throw e;
        }catch(Exception e) {
        	throw new ExcecaoServico("Erro ao pegar Aula Camada Servico");
        }
        }
    
    
    public Aula remover(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Aula aux = dao.getAula(codigo);
	            
	            // Esta no BD?
	            if (Validacao.Alocado(aux)) {
	                return dao.remover(codigo);
	            }
	        }
	        
	        return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch (Exception e) {
			throw new ExcecaoServico("Erro ao remover Camada Servico");
		}
    }
}