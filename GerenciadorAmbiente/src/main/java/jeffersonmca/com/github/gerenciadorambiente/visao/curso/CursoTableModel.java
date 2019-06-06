package jeffersonmca.com.github.gerenciadorambiente.visao.curso;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;

public class CursoTableModel  extends AbstractTableModel {

    private List<Curso> dados;
    private String[] colunas = {"Código", "Nome", "ID- Periodo"};

    public CursoTableModel(List<Curso> dados) {
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
        
          Curso a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getFkPeriodo();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setFkPeriodo((Periodo) value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Curso c){
       
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