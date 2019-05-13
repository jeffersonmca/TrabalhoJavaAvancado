package jeffersonmca.com.github.gerenciadorambiente.visao.ambiente;

import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;

class Validacao {
 
    public Validacao() { 
        
    }
    
    public static boolean Alocado(Object instancia) {
        
        // Argumento esta vazio?
        if (instancia != null) {
            return true;
        }
        
        return false;
    }
    
    public static boolean Vazio(String texto) {
        
        // Argumento esta vazio?
        if (Alocado(texto)) {
            
            // Continua vazio?
            if (!(texto.trim().equals(""))) {
                return false; 
            }
        }
        
        return true;
    }
    
    public static boolean Ambiente(Ambiente instancia) throws ExcecaoValidacao {
        
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
        	
            // Verifica se o identificador eh valido
            if (Identificador(instancia.getCodigo())) {

                // Verifica se existe um nome
                if (!(Vazio(instancia.getNome()))) {

                    return true;
                }
            }
        }
			
        throw new ExcecaoValidacao("Houve erro ao validar o ambiente!");
    }
    
    public static boolean Identificador(Object id) {
         return NaturalNaoNulo(id);
    }
    
    public static boolean NaturalNaoNulo(Object id) {
                
        // Argumento esta vazio?
        if (Alocado(id)) {
                  
            // Argumento eh do tipo esperado?
            if (id instanceof Integer) {

                // Eh valido para BD?
                if ((Integer)id > 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}