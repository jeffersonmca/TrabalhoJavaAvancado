package jeffersonmca.com.github.gerenciadorambiente.modelo;

public enum EnumSemestre {
    
    PRIMEIRO("1°"),
    SEGUNDO("2°");
    
    private String descricao;

    private EnumSemestre(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}