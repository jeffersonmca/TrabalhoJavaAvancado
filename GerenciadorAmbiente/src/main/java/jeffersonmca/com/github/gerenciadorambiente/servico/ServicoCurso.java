package jeffersonmca.com.github.gerenciadorambiente.servico;

import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOCurso;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;

public class ServicoCurso {
    
    private DAOCurso dao;

    public ServicoCurso() {
        dao = new DAOCurso();
    }
    
    public void editar(Curso instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.CursoEdita(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Curso!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Curso!");
        }
    }
    
    public void salvar(Curso instancia) throws ExcecaoDAO, ExcecaoValidacao, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Curso(instancia)) {
                dao.salvar(instancia);
            }else{
                throw new ExcecaoValidacao("Houve erro ao validar o Curso!");
            }
	        
    	} catch (ExcecaoValidacao e) {
            throw e;
        } catch (Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar o salvamento do Curso!");
        }
    }

    public List<Curso> buscarTodos() throws ExcecaoDAO {
        return dao.buscarTodos();
    }
    
    public Curso buscarPorCodigo(Integer codigo) throws ExcecaoServico,  ExcecaoDAO {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {
                return dao.buscarPorCodigo(codigo);
            }
            
            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e){
            throw new ExcecaoServico("Houve erro ao requisitar a busca de um curso!");
        }
    }
    
    
    public Curso remover(Integer codigo) throws ExcecaoDAO, ExcecaoServico {
        
        try {
            
            /*Regra de negocio*/
            if (Validacao.Identificador(codigo)) {

                Curso aux = dao.buscarPorCodigo(codigo);

                // Esta no BD?
                if (Validacao.Alocado(aux)) {
                    return dao.remover(codigo);
                }
            }

            return null;
            
        }catch(ExcecaoDAO e) {
            throw e;
        }catch(Exception e) {
            throw new ExcecaoServico("Houve erro ao requisitar a remoção de um curso!");
        }
    }
    
    public List<Curso> buscarPor(String opcao, String dado) throws ExcecaoDAO {
        
        // Se a opcao for SEM FILTRO, nao importa se o resto esta vazio
        if (opcao.equals("SEM FILTRO")) {
            return dao.buscarPor(opcao, null);
        }
        
        // Se a opcao NAO for SEM FILTRO, agora iremos verificar se o campo esta vazio
        if  (!(opcao.equals("SEM FILTRO")) && (!Validacao.Vazio(dado))) {
            
            // Devem ser INTEGER
            if ((opcao.equals("CODIGO")) ||
                (opcao.equals("ID PERIODO"))) {
                
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