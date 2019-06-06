package jeffersonmca.com.github.gerenciadorambiente.servico;

import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAODisciplina;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoDisciplina {
    
    private DAODisciplina dao;

    public ServicoDisciplina() {
        dao = new DAODisciplina();
    }
    
    public void editar(Disciplina instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.DisciplinaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Disciplina!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Disciplina!");
        }
    }
    
    public void salvar(Disciplina instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Disciplina(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Disciplina!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Disciplina!");
        }
    }

    public List<Disciplina> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Disciplina buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma disciplina!");
        }
    }
    
    
    public Disciplina remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Disciplina aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma disciplina!");
        }
    }
    
    public List<Disciplina> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        return dao.buscarPor(opcao, dado);
    }
}