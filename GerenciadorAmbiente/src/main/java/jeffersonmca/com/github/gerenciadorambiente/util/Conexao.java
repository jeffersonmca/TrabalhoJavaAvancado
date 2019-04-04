package jeffersonmca.com.github.gerenciadorambiente.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GerenciadorAmbiente");    
    private static EntityManager em;
    
    private Conexao(){
        
    }
    
    public static EntityManager getConexao(){
         
        if (em == null)
            em = emf.createEntityManager();
        
        return em;
    } 
}