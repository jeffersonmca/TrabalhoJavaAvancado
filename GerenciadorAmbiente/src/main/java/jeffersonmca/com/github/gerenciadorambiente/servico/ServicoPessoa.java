package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.dao.PessoaDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class ServicoPessoa {
    
    private PessoaDAO dao;

    public ServicoPessoa() {
       dao = new PessoaDAO();
    }
    
    public void salvar(Pessoa entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Pessoa> getAll() {
        return dao.getAll();
    }
    
    public Pessoa getPessoa(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getPessoa(codigo);
    }
    
    
    public Pessoa remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}