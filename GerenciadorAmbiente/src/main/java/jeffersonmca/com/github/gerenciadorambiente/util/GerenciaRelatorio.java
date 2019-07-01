package jeffersonmca.com.github.gerenciadorambiente.util;

import java.io.FileNotFoundException;
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

    private static Connection conexao = null;
    
    public GerenciaRelatorio() throws SQLException {
        configuraConexao();
    }
    
    private void configuraConexao() throws SQLException {
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/GerenciadorAmbiente?zeroDateTimeBehavior=convertToNull",
                "root", 
                "root");
    }
    
    public static void configuraRelatorio(boolean opcao, String nomeRelatorio, HashMap<String, Object> parametros) throws JRException, FileNotFoundException, Exception {
        
        String nomeSistema = "Sistema Gerenciador de Ambientes";
        String urlImagem = "./imagens/ifmg.png";
        
        // Parametros de entrada do relatorio.
        parametros.put("pImagem", urlImagem);
        parametros.put("pSistema", nomeSistema);
        parametros.put("pNomeRelatorio", nomeRelatorio);
        parametros.put("REPORT_LOCALE", new Locale("pt","BR"));
        
        // Classe auxiliar para gerar o relatorio
        Relatorio relatorio = new Relatorio();
        
        ServicoAmbiente servico = new ServicoAmbiente();
        List<Ambiente> ambientes = servico.buscarTodos();
        
        if (opcao)
             relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, conexao);
        else relatorio.geraRelatorio(opcao, nomeRelatorio, parametros, conexao);
    }
}