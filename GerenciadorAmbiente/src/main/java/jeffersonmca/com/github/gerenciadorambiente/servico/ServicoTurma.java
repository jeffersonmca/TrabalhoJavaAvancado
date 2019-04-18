package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOTurma;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoTurma {
    
    private DAOTurma dao;

    public ServicoTurma() throws ExcecaoConexao {
       dao = new DAOTurma();
    }
    
    public void salvar(Turma instancia) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Turma(instancia)) {
	    		dao.salvar(instancia);
	    	}
        }catch (ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
        	throw new ExcecaoServico("Erro ao salvar camada Servico");
		}
    }

    public List<Turma> getAll()throws ExcecaoDAO {
        return dao.getAll();
    }
    
    public Turma getTurma(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	    		return dao.getTurma(codigo);
	    	}
	    	
	    	return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch(Exception e) {
			throw new ExcecaoServico("Erro ao pegar Turma Camda Servico");
		}
    }
    
    
    public Turma remover(Integer codigo) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Turma aux = dao.getTurma(codigo);
	            
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