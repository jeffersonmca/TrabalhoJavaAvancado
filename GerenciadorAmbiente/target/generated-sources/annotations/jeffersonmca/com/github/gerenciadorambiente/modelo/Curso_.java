package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T20:15:46")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> codigo;
    public static volatile SingularAttribute<Curso, String> nome;
    public static volatile SingularAttribute<Curso, Periodo> fkPeriodo;

}