package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T20:15:46")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, Integer> codigo;
    public static volatile SingularAttribute<Pessoa, EnumTipoPessoa> tipoPessoa;
    public static volatile ListAttribute<Pessoa, Turma> turmas;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, String> email;

}