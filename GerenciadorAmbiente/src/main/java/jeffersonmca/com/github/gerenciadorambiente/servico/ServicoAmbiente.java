package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoAmbiente {
    
    private DAOAmbiente dao;

    public ServicoAmbiente() {
        dao = new DAOAmbiente();
    }
    
    public void salvar(Ambiente instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
    	try {
    		
            /*Regra de negocio*/
            if (Validacao.Ambiente(instancia)) {
                dao.salvar(instancia);
            }
	        
    	} catch (ExcecaoDAO|ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
        }
    }

    public List<Ambiente> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Ambiente buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um ambiente!");
        }
    }
    
    
    public Ambiente remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
        	
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Ambiente aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um ambiente!");
        }
    }
}