package jeffersonmca.com.github.gerenciadorambiente.excecoes;

public class ExcecaoValidacao extends Exception {

    public ExcecaoValidacao() {
        super();
    }
    
    public ExcecaoValidacao(String msg) {
        super(msg);
    }
}