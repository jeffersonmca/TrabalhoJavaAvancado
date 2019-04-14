package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPessoa;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoPessoa {
    
    private DAOPessoa dao;

    public ServicoPessoa() {
       dao = new DAOPessoa();
    }
    
    public void salvar(Pessoa instancia) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Pessoa(instancia)) {
        	dao.salvar(instancia);
        }
    }

    public List<Pessoa> getAll() {
        return dao.getAll();
    }
    
    public Pessoa getPessoa(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
    		return dao.getPessoa(codigo);
    	}
    	
    	return null;
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
    	if (Validacao.Identificador(codigo)) {
            
            Pessoa aux = dao.getPessoa(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    } 
}