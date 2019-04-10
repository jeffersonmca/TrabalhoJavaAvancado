package jeffersonmca.com.github.gerenciadorambiente.servico;

import java.util.List;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.dao.DAOAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.validacao.Validacao;

public class ServicoAmbiente {
    
    private DAOAmbiente dao;

    public ServicoAmbiente() {
       dao = new DAOAmbiente();
    }
    
    public void salvar(Ambiente instancia) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(instancia.getCodigo())) {
            
            if (!(Validacao.Vazio(instancia.getNome()))) {
                
                if (Validacao.NaturalNaoNulo(instancia.getCapacidade())) {
                    
                    if (Validacao.Alocado(instancia.getLocalizacao())) {
                        
                        dao.salvar(instancia);
                    }
                }
            }
        }
    }

    public List<Ambiente> getAll() {
        return dao.getAll();
    }
    
    public Ambiente getAmbiente(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            return dao.getAmbiente(codigo);
        }
        
        return null;
    }
    
    
    public Ambiente remover(Integer codigo) throws ExcecaoServico {
        
        /*Regra de negocio*/
        if (Validacao.Identificador(codigo)) {
            
            Ambiente aux = dao.getAmbiente(codigo);
            
            // Esta no BD?
            if (Validacao.Alocado(aux)) {
                return dao.remover(codigo);
            }
        }
        
        return null;
    }
}