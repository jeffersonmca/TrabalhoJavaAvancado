package jeffersonmca.com.github.gerenciadorambiente.visao.pessoa;

import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.*;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoPessoa;

public class PessoaTableModel  extends AbstractTableModel {

    private List<Pessoa> dados;
    private String[] colunas = {"Código", "Nome", "E-mail", "Tipo Pessoa"};

    public PessoaTableModel(List<Pessoa> dados) {
        this.dados = dados;
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
          Pessoa a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getEmail();
              case 3 : return a.getTipoPessoa();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setEmail((String) value);
                case 3 : dados.get(colIndex).setTipoPessoa((EnumTipoPessoa)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Pessoa c){
       
       dados.add(c);
       this.fireTableDataChanged();
   } 
   
   public void removeRow(int linha){
       
       dados.remove(linha);
       this.fireTableDataChanged();
   } 
   
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
}