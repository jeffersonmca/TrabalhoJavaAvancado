package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.dao.AmbienteDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ServicoExcecao;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;

public class ServicoAmbiente {
    
    private AmbienteDAO dao;

    public ServicoAmbiente() {
       dao = new AmbienteDAO();
    }
    
    public void salvar(Ambiente instanciaAmbiente) throws ServicoExcecao {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(instanciaAmbiente.getCodigo())) {
            
            if (!(Validacao.Vazio(instanciaAmbiente.getNome()))) {
                
                if (Validacao.NaturalNaoNulo(instanciaAmbiente.getCapacidade())) {
                    
                    if (Validacao.Alocado(instanciaAmbiente.getLocalizacao())) {
                        
                        dao.salvar(instanciaAmbiente);
                    }
                }
            }
        }
    }

    public List<Ambiente> getAll() {
        return dao.getAll();
    }
    
    public Ambiente getAmbiente(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            return dao.getAmbiente(codigo);
        }
    }
    
    
    public Ambiente remover(Integer codigo) throws ServicoExcecao {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            
            Ambiente aux = dao.getAmbiente(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
    } 
}