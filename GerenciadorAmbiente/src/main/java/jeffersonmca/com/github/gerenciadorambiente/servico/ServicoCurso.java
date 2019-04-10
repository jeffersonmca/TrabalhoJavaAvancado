package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOCurso;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class ServicoCurso {
    
    private DAOCurso dao;

    public ServicoCurso() {
       dao = new DAOCurso();
    }
    
    public void salvar(Curso entidade) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        dao.salvar(entidade);
    }

    public List<Curso> getAll() {
        return dao.getAll();
    }
    
    public Curso getCurso(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        return dao.getCurso(codigo);
    }
    
    
    public Curso remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}