package jeffersonmca.com.github.gerenciadorambiente.util;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.relatorio.Relatorio;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import net.sf.jasperreports.engine.JRException;

public class GerenciaRelatorio {

    private Connection conexao;
    
    public GerenciaRelatorio() throws SQLException {
        this.conexao = null;
//        configuraConexao();
    }
    
//    private void configuraConexao() throws SQLException {
//        
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        conexao = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/GerenciadorAmbiente?zeroDateTimeBehavior=convertToNull",
//                "root", 
//                "root");
//    }
    
    public void configuraRelatorio(boolean opcao, String nomeRelatorio) throws JRException, FileNotFoundException, Exception {
        
        System.out.println("EOOOOO");
        
        String nomeSistema = "Sistema Gerenciador de Ambientes";
        String urlImagem = "../../imagens/ifmg.png";
        // Parametros de entrada do relatorio.
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        System.out.println("EOOOOO");
//        URL url = this.getClass().getResource(urlImagem);
//        System.out.println("["+url.toString()+"]");
        System.out.println("EOOOOO");
        parametros.put("pImagem", urlImagem);
        System.out.println("EOOOOO");
        parametros.put("pSistema", nomeSistema);
        parametros.put("REPORT_LOCALE", new Locale("pt","BR"));
        System.out.println("EOOOOO");
        // Classe auxiliar para gerar o relatorio
        Relatorio relatorio = new Relatorio();
        System.out.println("EOOOOO");
        
        ServicoAmbiente servico = new ServicoAmbiente();
        List<Ambiente> ambientes = servico.buscarTodos();
        
//        if (opcao)
             relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, ambientes);
//        else relatorio.geraRelatorio(!opcao, nomeRelatorio, parametros, ambientes);
    }
}