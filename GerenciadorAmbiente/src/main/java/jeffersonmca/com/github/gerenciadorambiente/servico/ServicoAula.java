package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAula;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;

public class ServicoAula {
    
    private DAOAula dao;

    public ServicoAula() {
       dao = new DAOAula();
    }
    
    public void salvar(Aula instancia) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(instancia.getCodigo())) {
            
            if (!(Validacao.Hora(instancia.getHorarioInicio()))) {
                
                 if (!(Validacao.Hora(instancia.getHorarioTermino()))) {
                     
                    if (Validacao.NaturalNaoNulo(instancia.getDiaSemana())) {

                        if (Validacao.Alocado(instancia.getLocalizacao())) {

                            dao.salvar(instancia);
                        }
                    }
            }
        }
    }

    public List<Aula> getAll() {
        return dao.getAll();
    }
    
    public Aula getAula(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        
        return dao.getAula(codigo);
    }
    
    
    public Aula remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
              
        return dao.remover(codigo);
    } 
}