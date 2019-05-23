package jeffersonmca.com.github.gerenciadorambiente.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T20:08:54")
@StaticMetamodel(Turma.class)
public class Turma_ { 

    public static volatile SingularAttribute<Turma, Integer> codigo;
    public static volatile ListAttribute<Turma, Pessoa> alunos;
    public static volatile ListAttribute<Turma, Aula> aulas;
    public static volatile SingularAttribute<Turma, String> nome;
    public static volatile SingularAttribute<Turma, Pessoa> fkProfessor;
    public static volatile SingularAttribute<Turma, Periodo> fkPeriodo;
    public static volatile SingularAttribute<Turma, Disciplina> fkDisciplina;

}