package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAula;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoAula {
    
    private DAOAula dao;

    public ServicoAula() throws ExcecaoConexao{
        dao = new DAOAula();
    }
    
    public void salvar(Aula instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Aula(instancia)) {
                dao.salvar(instancia);
            }
            
        } catch (ExcecaoDAO|ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da aula!");
        }
    }

    public List<Aula> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Aula buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma aula!");
        }
    }
    
    
    public Aula remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Aula aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma aula!");
        }
    }
}