package jeffersonmca.com.github.gerenciadorambiente.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
    
    public void geraRelatorio(boolean visualizar, String nomeRelatorio, HashMap<String, Object> parametros, Connection conexao) throws JRException, FileNotFoundException, Exception {

        InputStream arquivo = getClass().getResourceAsStream("/Relatorios/MyReports/" + nomeRelatorio + ".jasper");
              
        if (arquivo == null)
            throw new Exception("Relatório não encontrado!");
        
        JasperPrint imprimir = JasperFillManager.fillReport(arquivo, parametros, conexao);
        
        // Quer visualizar?
        if (visualizar){
            JasperViewer ver = new JasperViewer(imprimir, false);
            ver.setTitle("Relatório-" + nomeRelatorio);
            ver.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            ver.setVisible(true);
        }else {
            
            JRPdfExporter exportar = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
            exportar.setExporterInput(new SimpleExporterInput(imprimir));
            exportar.setExporterOutput(
                    new SimpleOutputStreamExporterOutput(
                    new FileOutputStream("../Relatorios/" + nomeRelatorio + ".pdf")));
            
            SimplePdfReportConfiguration configuracao = new SimplePdfReportConfiguration();
            exportar.setConfiguration(configuracao);
                        
            exportar.exportReport();
        }    
    }
}