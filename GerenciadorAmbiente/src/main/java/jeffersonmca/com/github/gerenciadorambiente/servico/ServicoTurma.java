package jeffersonmca.com.github.gerenciadorambiente.servico;

import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOTurma;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoTurma {
    
    private DAOTurma dao;

    public ServicoTurma() {
        dao = new DAOTurma();
    }
    
    public void editar(Turma instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.TurmaEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Turma!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Turma!");
        }
    }
    
    public void salvar(Turma instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Turma(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar a Turma!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento da Turma!");
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
    
    public List<Turma> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if ((opcao.equals("CODIGO")) ||
                (opcao.equals("ID DISCIPLINA")) ||
                (opcao.equals("ID PERIODO")) ||
                (opcao.equals("ID PROFESSOR"))) {
                
                // Verifica se string eh numero
                boolean ehNumero = dado.matches("[0-9]+");
                
                if (ehNumero)                
                    return dao.buscarPor(opcao, Integer.parseInt(dado));
            }
            
            // Devem ser STRING
            if (opcao.equals("NOME"))
                return dao.buscarPor(opcao, dado);
        }
        
        return null;
    }
}