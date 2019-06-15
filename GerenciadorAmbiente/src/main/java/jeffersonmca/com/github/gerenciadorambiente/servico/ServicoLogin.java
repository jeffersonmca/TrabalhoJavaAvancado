package jeffersonmca.com.github.gerenciadorambiente.servico;

import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOLogin;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoLogin {
    
    private DAOLogin dao;

    public ServicoLogin() {
        dao = new DAOLogin();
    }
    
    public void editar(Login instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.LoginEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Login!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Login!");
        }
    }
    
    public void salvar(Login instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Login(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Login!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Login!");
        }
    }

    public List<Login> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Login buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um login!");
        }
    }
    
    public Login buscarPorId(String id) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (!Validacao.Vazio(id)) {
                return dao.buscarPorId(id);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um login!");
        }
    }
    
    
    public Login remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Login aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um login!");
        }
    }
    
    public List<Login> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if ((opcao.equals("CODIGO")) ||
                (opcao.equals("ID USUARIO"))) {
                
                // Verifica se string eh numero
                boolean ehNumero = dado.matches("[0-9]+");
                
                if (ehNumero)                
                    return dao.buscarPor(opcao, Integer.parseInt(dado));
            }
            
            // Devem ser STRING
            if (opcao.equals("ID"))
                return dao.buscarPor(opcao, dado);
        }
        
        return null;
    }

    public boolean existeLogin(Login login) throws ExcecaoDAO {
        
        Login l = dao.buscarPorId(login.getId());
        
        // Achou algum login no banco de dados
        if (Validacao.Alocado(l))
             return true;
        else return false;
    }

    public boolean existeLoginEdita(Login login, String idAntes) throws ExcecaoDAO {
        
        Login l = dao.buscarPorId(login.getId());
        
        // Achou algum login no banco de dados E ele eh diferente do ja cadastrado
        if (Validacao.Alocado(l) && !idAntes.equals(login.getId()))
             return true;
        else return false;
    }

    public boolean logar(Login login, String senha) {
        
        // Se as senhas baterem entao ele pode logar
        if (login.getSenha().equals(senha))
             return true;
        else return false;
    }
}