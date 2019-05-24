package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumSemestre;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T21:21:45")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Integer> codigo;
    public static volatile SingularAttribute<Periodo, Integer> ano;
    public static volatile SingularAttribute<Periodo, EnumSemestre> semestre;

}