package jeffersonmca.com.github.gerenciadorambiente.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Conversoes {

    public Conversoes() {
        
    }
   
    public static Date strToTime(String texto) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        try {
            return sdf.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Hora está errada!");
            return null;
        }
    } 
    
    public static String timeToStr(Date hora) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");        
        return sdf.format(hora);
    }
    
    public static Date strToDate(String texto) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            return sdf.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data está errada!");
            return null;
        }
    } 
    
    public static String dateToStr(Date data) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
        return sdf.format(data);
    }
}