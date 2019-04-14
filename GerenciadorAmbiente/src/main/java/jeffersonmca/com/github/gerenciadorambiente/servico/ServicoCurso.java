package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOCurso;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoCurso {
    
    private DAOCurso dao;

    public ServicoCurso() {
       dao = new DAOCurso();
    }
    
    public void salvar(Curso instancia) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Curso(instancia)) {
    		dao.salvar(instancia);
    	}
    }

    public List<Curso> getAll() {
        return dao.getAll();
    }
    
    public Curso getCurso(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
    		return dao.getCurso(codigo);
    	}
    	
    	return null;
    }
    
    
    public Curso remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Curso aux = dao.getCurso(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    }
}