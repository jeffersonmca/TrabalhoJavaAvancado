package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoAmbiente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-05T18:03:22")
@StaticMetamodel(Ambiente.class)
public class Ambiente_ { 

    public static volatile SingularAttribute<Ambiente, Integer> codigo;
    public static volatile SingularAttribute<Ambiente, String> localizacao;
    public static volatile SingularAttribute<Ambiente, Integer> capacidade;
    public static volatile SingularAttribute<Ambiente, String> nome;
    public static volatile SingularAttribute<Ambiente, EnumTipoAmbiente> tipoAmbiente;

}