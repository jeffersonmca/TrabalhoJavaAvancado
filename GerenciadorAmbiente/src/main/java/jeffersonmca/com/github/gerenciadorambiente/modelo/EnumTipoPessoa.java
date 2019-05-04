package jeffersonmca.com.github.gerenciadorambiente.modelo;

public enum EnumTipoPessoa {
    
    ALUNO("Aluno"),
    PROFESSOR("Professor");
    
    private String descricao;

    private EnumTipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}