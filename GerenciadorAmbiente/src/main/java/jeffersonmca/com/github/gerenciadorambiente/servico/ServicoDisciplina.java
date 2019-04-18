package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAODisciplina;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoDisciplina {
    
    private DAODisciplina dao;

    public ServicoDisciplina() throws ExcecaoConexao {
       dao = new DAODisciplina();
    }
    
    public void salvar(Disciplina instancia) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Disciplina(instancia)) {
	    		dao.salvar(instancia);
	    	}
        }catch (ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
        	throw new ExcecaoServico("Erro ao salvar camada Servico");
		}
    }

    public List<Disciplina> getAll()throws ExcecaoDAO {
        return dao.getAll();
    }
    
    public Disciplina getDisciplina(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	    		return dao.getDisciplina(codigo);
	    	}
	    	
	    	return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch(Exception e) {
			throw new ExcecaoServico("Erro ao pegar Disciplina Camda Servico");
		}
    }
    
    
    public Disciplina remover(Integer codigo) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Disciplina aux = dao.getDisciplina(codigo);
	            
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