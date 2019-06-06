package jeffersonmca.com.github.gerenciadorambiente.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumDiaSemana;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-06T11:16:00")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, Date> horarioInicio;
    public static volatile SingularAttribute<Aula, Ambiente> fkAmbiente;
    public static volatile SingularAttribute<Aula, Integer> codigo;
    public static volatile SingularAttribute<Aula, EnumDiaSemana> diaSemana;
    public static volatile SingularAttribute<Aula, Turma> turma;
    public static volatile SingularAttribute<Aula, Date> horarioTermino;

}