package jeffersonmca.com.github.gerenciadorambiente.modelo;

public enum EnumTipoAmbiente {
    
    SALA("Sala"),
    LABORATORIO("Laboratório");

    private String descricao;
    
    private EnumTipoAmbiente(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }    
}