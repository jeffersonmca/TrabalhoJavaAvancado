package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPessoa;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoPessoa {
    
    private DAOPessoa dao;

    public ServicoPessoa() {
       dao = new DAOPessoa();
    }
    
    public void salvar(Pessoa entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Pessoa> getAll() {
        return dao.getAll();
    }
    
    public Pessoa getPessoa(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        return dao.getPessoa(codigo);
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}