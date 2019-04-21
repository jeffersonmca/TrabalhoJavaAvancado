package jeffersonmca.com.github.gerenciadorambiente.dao;

import java.io.Serializable;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;

public interface IDAOGenerico <ID, I extends Serializable> {
    
    public void salvar(I instancia) throws ExcecaoDAO;
    public List<I> buscarTodos() throws ExcecaoDAO;
    public I buscarPorID(ID codigo) throws ExcecaoDAO;
    public I remover(ID codigo) throws ExcecaoDAO;
}
