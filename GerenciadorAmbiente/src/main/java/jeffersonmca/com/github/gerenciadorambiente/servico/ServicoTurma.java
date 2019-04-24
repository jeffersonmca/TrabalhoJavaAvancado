package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOTurma;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoTurma {
    
    private DAOTurma dao;

    public ServicoTurma() throws ExcecaoConexao{
        dao = new DAOTurma();
    }
    
    public void salvar(Turma instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Turma(instancia)) {
                dao.salvar(instancia);
            }
            
        } catch (ExcecaoDAO|ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da turma!");
        }
    }

    public List<Turma> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Turma buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de uma turma!");
        }
    }
    
    
    public Turma remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Turma aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de uma turma!");
        }
    }
}