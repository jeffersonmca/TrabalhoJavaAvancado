package jeffersonmca.com.github.gerenciadorambiente.servico;

import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOPessoa;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoPessoa {
    
    private DAOPessoa dao;

    public ServicoPessoa() {
        dao = new DAOPessoa();
    }
    
    public void editar(Pessoa instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.PessoaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Pessoa!");
        }
    }
    
    public void salvar(Pessoa instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Pessoa(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Pessoa!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Pessoa!");
        }
    }

    public List<Pessoa> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public List<Pessoa> buscarTodosProfessores() throws ExcecaoDAO {
        return dao.buscarTodosProfessores();
    }
    
    public Pessoa buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma pessoa!");
        }
    }
    
    
    public Pessoa remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Pessoa aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma pessoa!");
        }
    }

    public List<Pessoa> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        return dao.buscarPor(opcao, dado);
    }

    public List<Pessoa> buscarAlunosForaDaGrid(List<Pessoa> alunos) throws ExcecaoDAO {
        return dao.buscarAlunosForaDaGrid(alunos);
    }
}