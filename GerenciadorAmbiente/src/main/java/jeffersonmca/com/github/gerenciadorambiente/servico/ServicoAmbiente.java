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
	        
    	} catch (ExcecaoDAO e) {
    		throw new ExcecaoDAO(e.getMessage());
		} catch (ExcecaoValidacao e) {
			throw new ExcecaoValidacao(e.getMessage());
		} catch (Exception e) {
			throw new ExcecaoServico("Houve erro ao requisitar o salvamento do ambiente!");
		}
    }

    public List<Ambiente> getAll() {
        return dao.getAll();
    }
    
    public Ambiente getAmbiente(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            return dao.getAmbiente(codigo);
        }
        
        return null;
    }
    
    
    public Ambiente remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            
            Ambiente aux = dao.getAmbiente(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    }
}