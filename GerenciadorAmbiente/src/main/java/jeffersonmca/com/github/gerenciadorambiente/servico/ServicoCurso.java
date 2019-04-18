package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOCurso;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoCurso {
    
    private DAOCurso dao;

    public ServicoCurso() throws ExcecaoConexao {
       dao = new DAOCurso();
    }
    
    public void salvar(Curso instancia) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Curso(instancia)) {
	    		dao.salvar(instancia);
	    	}
        }catch (ExcecaoDAO e) {
        	throw e;
        }catch (Exception e) {
        	throw new ExcecaoServico("Erro ao salvar camada Servico");
		}
    }

    public List<Curso> getAll()throws ExcecaoDAO {
        return dao.getAll();
    }
    
    public Curso getCurso(Integer codigo) throws ExcecaoServico,ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	    		return dao.getCurso(codigo);
	    	}
	    	
	    	return null;
        }catch (ExcecaoDAO e) {
			throw e;
		}catch(Exception e) {
			throw new ExcecaoServico("Erro ao pegar Curso Camda Servico");
		}
    }
    
    
    public Curso remover(Integer codigo) throws ExcecaoServico, ExcecaoDAO {
        try {
	        /*Regra de negocio*/
	    	if (Validacao.Identificador(codigo)) {
	            
	            Curso aux = dao.getCurso(codigo);
	            
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