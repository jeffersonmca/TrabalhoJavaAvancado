package jeffersonmca.com.github.gerenciadorambiente.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

public class Validacao {

    public Validacao() {
        
    }
    
    /**
     * Verifica se o argumento esta Vazio
     * @param texto - O texto informado para ser verificado. 
     * @return Vazio=true	Preenchido=false
     */
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

    public static boolean Vazio(Enum instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            String texto = instancia.toString();
        	
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
    
    public static boolean Vazio(List vetor) {
        
        // Argumento esta vazio?
        if (Alocado(vetor)) {
            
            // Tem algo nele?
            if (vetor.size() != 0) {
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
        	
            // Esta no formato correto ?
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
    
    public static boolean Hora(String hora) {
        
        // Argumento esta vazio?
        if (Alocado(hora)) {
        	
            // Esta no formato correto ?
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
            try {
                sdf.parse(hora);
                return true;
            } catch (ParseException ex) {
                return false;
            }
        }
        
        return false;
    }
    
    public static boolean Ambiente(Ambiente instancia) {
        
    	// Argumento esta vazio?
        if (Alocado(instancia)) {

            // Verifica se existe um nome
            if (!(Validacao.Vazio(instancia.getNome()))) {

                return true;
            }
        }
			
        return false;
    }
    
    public static boolean AmbienteEdita(Ambiente instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Ambiente(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Aula(Aula instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se a hora eh valida
            if (Validacao.Hora(Conversoes.timeToStr(instancia.getHorarioInicio()))) {

                // Verifica se a hora eh valida
                if (Validacao.Hora(Conversoes.timeToStr(instancia.getHorarioTermino()))) {
                    
                    // Verifica se foi o enum esta preenchido
                    if (!(Validacao.Vazio(instancia.getDiaSemana()))) {

                        // Verifica se o ambiente eh valido
                        if (Validacao.Ambiente(instancia.getFkAmbiente())) {

                            // Verifica se a turma eh valida
                            if (Validacao.Turma(instancia.getTurma())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public static boolean AulaEdita(Aula instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Aula(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Curso(Curso instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
		        
            // Verifica se existe um nome
            if (!Validacao.Vazio(instancia.getNome())) {

                // Verifica se o periodo eh valido
                if (Validacao.Periodo(instancia.getFkPeriodo())) {
                    return true;
                }
            }
        }
	    
        return false;
    }
    
    public static boolean CursoEdita(Curso instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Curso(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Disciplina(Disciplina instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {

            // Verifica se existe um nome
            if (!Validacao.Vazio(instancia.getNome())) {

                // Verifica se a carga horaria eh maior que zero
                if (Validacao.NaturalNaoNulo(instancia.getCargaHoraria())) {

                    // Verifica se o curso eh valido
                    if (Validacao.Curso(instancia.getFkCurso())) {
                        return true;
                    }
                }
            }
        }
	    
        return false;
    }
    
    public static boolean DisciplinaEdita(Disciplina instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Disciplina(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Login(Login instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
		        
            // Verifica se existe um id
            if (!Validacao.Vazio(instancia.getId())) {

                // Verifica se existe uma senha
                if (!Validacao.Vazio(instancia.getSenha())) {
                    
                    // Verifica se a pessoa eh valida
                    if (Validacao.Pessoa(instancia.getUsuario())) {
                        return true;
                    }
                }
            }
        }
	    
        return false;
    }
    
    public static boolean LoginEdita(Login instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Login(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Periodo(Periodo instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {

            // Verifica se o ano eh maior que zero
            if (Validacao.NaturalNaoNulo(instancia.getAno())) {

                // Verifica se o semestre esta preenchido
                if (!(Validacao.Vazio(instancia.getSemestre()))) {
                    return true;
                }
            }
        }
	    
        return false;
    }
    
    public static boolean PeriodoEdita(Periodo instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Periodo(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Pessoa(Pessoa instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {

            // Verifica se existe um nome
            if (!Validacao.Vazio(instancia.getNome())) {

                // Verifica se o email eh valido
                if (!Validacao.Vazio(instancia.getEmail())) {
                    
                    // Verifica se o tipo pessoa esta preenchido
                    if (!(Validacao.Vazio(instancia.getTipoPessoa()))) {
                        return true;
                    }
                }
            }
        }
	    
        return false;
    }
    
    public static boolean PessoaEdita(Pessoa instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Pessoa(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Turma(Turma instancia) {
    	
    	// Argumento esta vazio?
        if (Alocado(instancia)) {

            // Verifica se existe um nome
            if (!Validacao.Vazio(instancia.getNome())) {

                // Verifica se a disciplina eh valida
                if (Validacao.Disciplina(instancia.getFkDisciplina())) {

                    // Verifica se o periodo eh valido
                    if (Validacao.Periodo(instancia.getFkPeriodo())) {

                        // Verifica se o professor eh valido
                        if (Validacao.Professor(instancia.getFkProfessor())) {
                            return true;
                        }
                    }
                }
            }
        }
	    
        return false;
    }
    
    public static boolean TurmaEdita(Turma instancia) {
        
        // Argumento esta vazio?
        if (Alocado(instancia)) {
            
            // Verifica se o identificador eh valido
            if (Validacao.Identificador(instancia.getCodigo())) {
                return Turma(instancia);
            }
        }
        
        return false;
    }
    
    public static boolean Professor(Pessoa instancia) {
        
        // 
        if (Pessoa(instancia)) {
            
            if (instancia.getTipoPessoa().equals(EnumTipoPessoa.PROFESSOR)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean Aluno(Pessoa instancia) {
        
        // 
        if (Pessoa(instancia)) {
        	
            if (instancia.getTipoPessoa().equals(EnumTipoPessoa.ALUNO)) {
                return true;
            }
        }
        
        return false;
    }
}