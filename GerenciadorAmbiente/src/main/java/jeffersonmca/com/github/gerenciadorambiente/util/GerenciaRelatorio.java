package jeffersonmca.com.github.gerenciadorambiente.util;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.gerenciadorambiente.relatorio.Relatorio;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import net.sf.jasperreports.engine.JRException;

public class GerenciaRelatorio {

    private Connection conexao;
    
    public GerenciaRelatorio() throws SQLException {
        this.conexao = null;
        configuraConexao();
    }
    
    private void configuraConexao() throws SQLException {
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/GerenciadorAmbiente?zeroDateTimeBehavior=convertToNull",
                "root", 
                "root");
    }
    
    public void configuraRelatorio(boolean opcao, String nomeRelatorio) throws JRException, FileNotFoundException, Exception {
        
        String nomeEmpresa = "Sistema Gerenciador de Ambientes";
        
        // Parametros de entrada do relatorio.
        HashMap<String,Object> parametros = new HashMap<String, Object>();
              
        URL url = getClass().getResource("/imagens/ifmg.png");
        parametros.put("pImagem", url.getFile());
        parametros.put("pEmpresa", nomeEmpresa);
        parametros.put("REPORT_LOCALE", new Locale("pt","BR"));
        
        // Classe auxiliar para gerar o relatorio
        Relatorio relatorio = new Relatorio();
        
        if (opcao)
             relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, conexao);
        else relatorio.geraRelatorio(!opcao, nomeRelatorio, parametros, conexao);
    }
}