package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOTurma;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoTurma {
    
    private DAOTurma dao;

    public ServicoTurma() {
       dao = new DAOTurma();
    }
    
    public void salvar(Turma entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Turma> getAll() {
        return dao.getAll();
    }
    
    public Turma getTurma(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
    		return dao.getTurma(codigo);
    	}
    	
    	return null;
    }
    
    
    public Turma remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Turma aux = dao.getTurma(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    } 
}