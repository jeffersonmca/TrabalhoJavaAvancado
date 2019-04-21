package jeffersonmca.com.github.gerenciadorambiente.excecoes;

public class ExcecaoDAO extends Exception {

    public ExcecaoDAO() {
        super();
    }
    
    public ExcecaoDAO(String msg) {
        super(msg);
    }
}