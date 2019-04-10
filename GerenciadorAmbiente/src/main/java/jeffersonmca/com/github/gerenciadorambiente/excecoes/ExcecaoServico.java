package jeffersonmca.com.github.gerenciadorambiente.excecoes;

public class ExcecaoServico extends Exception {

    public ExcecaoServico() {
        super();
    }
    
    public ExcecaoServico(String msg) {
        super(msg);
    }
}