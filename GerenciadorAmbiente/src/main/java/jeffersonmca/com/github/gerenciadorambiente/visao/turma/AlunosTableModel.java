package jeffersonmca.com.github.gerenciadorambiente.visao.turma;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;

public class AlunosTableModel  extends AbstractTableModel{

    private List<Pessoa> dados;
    private String[] colunas = {"Código", "Nome", "E-mail"};

    public AlunosTableModel(List<Pessoa> dados) {
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
          Pessoa e = dados.get(rowIndex);

          switch (columnIndex){
              case 0 : return e.getCodigo();
              case 1 : return e.getNome();
              case 2 : return e.getEmail();
              default: return null;
          }          
    }
    
   @Override
   public void setValueAt(Object value, int rowIndex, int colIndex){
       
       if (value != null){
           switch (colIndex){
              case 0 : dados.get(colIndex).setCodigo((Integer)value);
              case 1 : dados.get(colIndex).setNome((String)value);
              case 3 : dados.get(colIndex).setEmail((String)value);
          }
           
        this.fireTableCellUpdated(rowIndex, colIndex);
       }       
   } 
    
   public void addRow(Pessoa p) {
       dados.add(p);
       this.fireTableDataChanged();
   } 
   
   public void removeRow(int linha) {
       dados.remove(linha);
       this.fireTableDataChanged();
   } 
   
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
}