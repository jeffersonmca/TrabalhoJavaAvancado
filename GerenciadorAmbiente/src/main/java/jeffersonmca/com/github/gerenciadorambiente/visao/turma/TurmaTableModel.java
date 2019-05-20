package jeffersonmca.com.github.gerenciadorambiente.visao.turma;

import jeffersonmca.com.github.gerenciadorambiente.visao.aula.*;
import java.util.Date;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumDiaSemana;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;

public class TurmaTableModel  extends AbstractTableModel {

    private List<Turma> dados;
    private String[] colunas = {"Código", "Nome", "Disciplina", "Periodo", "Professor"};

    public TurmaTableModel(List<Turma> dados) {
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
        
          Turma a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getNome();
              case 2 : return a.getFkDisciplina();
              case 3 : return a.getFkPeriodo();
              case 4 : return a.getFkProfessor();
              default: return null;
          }
          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setNome((String)value);
                case 2 : dados.get(colIndex).setFkDisciplina((Disciplina) value);
                case 3 : dados.get(colIndex).setFkPeriodo((Periodo)value);
                case 4 : dados.get(colIndex).setFkProfessor((Pessoa)value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Turma c){
       
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