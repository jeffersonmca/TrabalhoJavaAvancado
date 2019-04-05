package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.dao.PeriodoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class ServicoPeriodo {
    
    private PeriodoDAO dao;

    public ServicoPeriodo() {
       dao = new PeriodoDAO();
    }
    
    public void salvar(Periodo entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Periodo> getAll() {
        return dao.getAll();
    }
    
    public Periodo getPeriodo(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getPeriodo(codigo);
    }
    
    
    public Periodo remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}