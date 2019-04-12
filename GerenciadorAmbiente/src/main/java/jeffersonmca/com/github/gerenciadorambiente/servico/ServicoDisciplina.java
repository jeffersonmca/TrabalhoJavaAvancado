package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAODisciplina;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoDisciplina {
    
    private DAODisciplina dao;

    public ServicoDisciplina() {
       dao = new DAODisciplina();
    }
    
    public void salvar(Disciplina entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Disciplina> getAll() {
        return dao.getAll();
    }
    
    public Disciplina getDisciplina(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
    		return dao.getDisciplina(codigo);
    	}
    	
    	return null;
    }
    
    
    public Disciplina remover(Integer codigo) throws ExcecaoServico {
        
    	/*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Disciplina aux = dao.getDisciplina(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    }
}