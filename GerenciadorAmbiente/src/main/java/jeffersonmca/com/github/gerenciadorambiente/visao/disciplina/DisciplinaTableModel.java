package jeffersonmca.com.github.gerenciadorambiente.visao.disciplina;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;

public class DisciplinaTableModel  extends AbstractTableModel {

    private List<Disciplina> dados;
    private String[] colunas = {"Código", "Nome", "Carga Horária", "ID - Curso"};

    public DisciplinaTableModel(List<Disciplina> dados) {
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
        
          Disciplina a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getCargaHoraria();
              case 3 : return a.getFkCurso();
              default: return null;
          }          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setCargaHoraria((Integer) value);
                case 3 : dados.get(colIndex).setFkCurso((Curso) value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Disciplina d) {
       dados.add(d);
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