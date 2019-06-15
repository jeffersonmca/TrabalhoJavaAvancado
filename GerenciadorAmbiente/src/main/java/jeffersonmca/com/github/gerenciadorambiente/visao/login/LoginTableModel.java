package jeffersonmca.com.github.gerenciadorambiente.visao.login;

import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;

public class LoginTableModel  extends AbstractTableModel {

    private List<Login> dados;
    private String[] colunas = {"Código", "Id", "ID- USUARIO"};

    public LoginTableModel(List<Login> dados) {
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
        
          Login a = dados.get(rowIndex);
          
          switch (columnIndex){
              case 0 : return a.getCodigo();
              case 1 : return a.getId();
              case 2 : return a.getUsuario();
              default: return null;
          }          
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex){
       
        if (value != null){
           
            switch (colIndex){
                case 0 : dados.get(colIndex).setCodigo((Integer)value);
                case 1 : dados.get(colIndex).setId((String)value);
                case 2 : dados.get(colIndex).setUsuario((Pessoa) value);
            }
           
            this.fireTableCellUpdated(rowIndex, colIndex);
        }       
    }
    
   public void addRow(Login l) {
       dados.add(l);
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