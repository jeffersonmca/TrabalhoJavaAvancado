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
    
    public static String timeToStr(Date data) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");        
        return sdf.format(data);
    }
}