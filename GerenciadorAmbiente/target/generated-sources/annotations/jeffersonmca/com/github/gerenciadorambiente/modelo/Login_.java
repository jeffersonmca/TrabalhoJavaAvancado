package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-15T17:56:41")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> senha;
    public static volatile SingularAttribute<Login, Integer> codigo;
    public static volatile SingularAttribute<Login, Pessoa> usuario;
    public static volatile SingularAttribute<Login, String> id;

}