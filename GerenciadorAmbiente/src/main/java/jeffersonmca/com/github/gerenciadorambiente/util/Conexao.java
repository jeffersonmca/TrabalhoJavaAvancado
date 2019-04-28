package jeffersonmca.com.github.gerenciadorambiente.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("GerenciadorAmbientePU");
    private static EntityManager em;
    
    private Conexao() {
        
    }
    
    public static EntityManager getConexao() {
        
        System.out.println("entrou1");
        if (em == null) {
            System.out.println("entrou2");
            em = emf.createEntityManager();
            System.out.println("entrou3");
        }
        System.out.println("entrou4");
        return em;
    }  
}

//public class Conexao {
//    
//    private static EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("PetPU");
//    private static EntityManager em;
//    
//    private Conexao() {
//        
//    }
//    
//    public static EntityManager getConexao(){
//         
//        if (em == null)
//         em = emf.createEntityManager();
//        
//        return em;
//    }  
//}

//public class Conexao {
//    
//    private static EntityManagerFactory emf = null;            
//    private static EntityManager em = null;
//    
//    private Conexao() {
//        emf = Persistence.createEntityManagerFactory("GerenciadorAmbientePU");
//        em = emf.createEntityManager();
//    }
//    
//    public static EntityManager getConexao() {
//       
//        if (em == null) {
//            Conexao conexao = new Conexao();            
//        }
//
//        return em;
//    }
//}