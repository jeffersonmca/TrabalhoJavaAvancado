package jeffersonmca.com.github.gerenciadorambiente.excecoes;

public class ServicoExcecao extends Exception {

    public ServicoExcecao() {
        super();
    }
    
    public ServicoExcecao(String msg) {
        super(msg);
    }
}