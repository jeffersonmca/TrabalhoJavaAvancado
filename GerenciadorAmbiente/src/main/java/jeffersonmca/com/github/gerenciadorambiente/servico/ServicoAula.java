package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.dao.AulaDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class ServicoAula {
    
    private AulaDAO dao;

    public ServicoAula() {
       dao = new AulaDAO();
    }
    
    public void salvar(Aula entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Aula> getAll() {
        return dao.getAll();
    }
    
    public Aula getAula(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getAula(codigo);
    }
    
    
    public Aula remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}