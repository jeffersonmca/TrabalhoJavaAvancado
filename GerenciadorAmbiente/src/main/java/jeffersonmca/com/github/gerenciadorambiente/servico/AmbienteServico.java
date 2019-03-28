package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.dao.AmbienteDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class AmbienteServico {
    
    private AmbienteDAO dao;

    public AmbienteServico() {
       dao = new AmbienteDAO();
    }
    
    public void salvar(Ambiente entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Ambiente> getAll() {
        return dao.getAll();
    }
    
    public Ambiente getAmbiente(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getAmbiente(codigo);
    }
    
    
    public Ambiente remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}