package jeffersonmca.com.github.gerenciadorambiente.validacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import jeffersonmca.com.github.gerenciadorambiente.modelo.enumDiaSemana;

public class Validacao {

    public Validacao() { 
        
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
        
    public static boolean Vazio(Object [] vetor) {
        
        // Argumento esta vazio?
        if (Alocado(vetor)) {
            
            // Tem algo nele?
            if (vetor.length != 0) {
                return false;
            }
        }
        
        return true;
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
    
    public static boolean Alocado(Object instancia) {
        
        // Argumento esta vazio?
        if (instancia != null) {
            return true;
        }
        
        return false;
    }
    public static boolean Data(String data) {
        // Argumento esta vazio?
        if (Alocado(data)) {
            //esta no formato correto
            try{
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate d = LocalDate.parse(data, formato);
                return true;
            }catch(DateTimeParseException erro){
                return false;
            }
        }
        return false;
    }
    public static boolean Hora(Date hora) {
        
        // Argumento esta vazio?
        if (Alocado(hora)) {
           return true;
        }
        
        return false;
    }
    public static boolean DiaSemana(enumDiaSemana diaSemana) {
        
        // Argumento esta vazio?
        if (Alocado(diaSemana)) {               
            return true;
        }      
        return false;
    }
    
}