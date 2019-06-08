package jeffersonmca.com.github.gerenciadorambiente.visao.periodo;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumSemestre;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;

public class PeriodoTableModel  extends AbstractTableModel {

    private List<Periodo> dados;
    private String[] colunas = {"Código", "Ano", "Semestre"};

    public PeriodoTableModel(List<Periodo> dados) {
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
        
          Periodo a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getAno();
              case 2 : return a.getSemestre();
              default: return null;
          }          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setAno((Integer)value);
                case 2 : dados.get(colIndex).setSemestre((EnumSemestre) value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Periodo p) {       
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