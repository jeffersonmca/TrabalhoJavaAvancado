package jeffersonmca.com.github.gerenciadorambiente.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoConexao;

public class Conexao {
    
    private static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("GerenciadorAmbiente");    
    private static EntityManager em;
    
    private Conexao(){
        
    }
    
    public static EntityManager getConexao() throws ExcecaoConexao {
        
        try {
        	
            if (em == null)
                em = emf.createEntityManager();

            return em;
                
    	} catch (Exception e) {
            throw new ExcecaoConexao("Erro ao Conectar!");
    	}
    } 
}