package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.dao.CursoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;

public class CursoServico {
    
    private CursoDAO dao;

    public CursoServico() {
       dao = new CursoDAO();
    }
    
    public void salvar(Curso entidade) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Curso> getAll() {
        return dao.getAll();
    }
    
    public Curso getCurso(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        
        return dao.getCurso(codigo);
    }
    
    
    public Curso remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}