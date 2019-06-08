package jeffersonmca.com.github.gerenciadorambiente.visao.aula;

import java.util.Date;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumDiaSemana;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

public class AulaTableModel  extends AbstractTableModel {

    private List<Aula> dados;
    private String[] colunas = {"Código", "ID - Ambiente", "ID - Turma", "Dia da semana", "Início", "Fim"};

    public AulaTableModel(List<Aula> dados) {
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
        
          Aula a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getFkAmbiente();
              case 2 : return a.getTurma();
              case 3 : return a.getDiaSemana();
              case 4 : return a.getHorarioInicio();
              case 5 : return a.getHorarioTermino();
              default: return null;
          }          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setFkAmbiente((Ambiente)value);
                case 2 : dados.get(colIndex).setTurma((Turma) value);
                case 3 : dados.get(colIndex).setDiaSemana((EnumDiaSemana)value);
                case 4 : dados.get(colIndex).setHorarioInicio((Date)value);
                case 5 : dados.get(colIndex).setHorarioTermino((Date)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Aula a) {
       dados.add(a);
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