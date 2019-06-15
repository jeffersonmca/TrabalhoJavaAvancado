package jeffersonmca.com.github.gerenciadorambiente.visao.login;

import jeffersonmca.com.github.gerenciadorambiente.visao.login.*;
import jeffersonmca.com.github.gerenciadorambiente.visao.login.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoLogin;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import jeffersonmca.com.github.gerenciadorambiente.visao.pessoa.PessoaInclui;

public class LoginEdita extends javax.swing.JDialog {

    private Login login;
    private ServicoLogin servico;
    private ServicoPessoa pesServico;
    private boolean ctrl;
    private PessoaInclui telaPessoa;
    private java.awt.Frame parent;
    private boolean entrou;
    
    public LoginEdita(java.awt.Frame parent, boolean modal, ServicoLogin servico, Login login) {
        
        super(parent, modal);
        initComponents();
        
        this.login = login;
        this.servico = servico;
        this.pesServico = new ServicoPessoa();
        this.ctrl = false;
        this.telaPessoa = null;
        this.parent = parent;
        this.entrou = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de um Login especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(login);
    }
    
    // Preenche combo box do Pessoa
    private void PreencheComboBoxPessoa() {
        
        List<Pessoa> lista = null;
        try {
            lista = pesServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Pessoa> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmPessoa =
               new DefaultComboBoxModel(vetor);
        ComboBoxPessoa.setModel(dcbmPessoa);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxPessoa();
    }
    
    // Como esta editando os dados de um Ambiente especifico, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Login login) {
        textId.setText(login.getId());
        passwordSenha.setText(login.getSenha());
        ComboBoxPessoa.setSelectedItem(login.getUsuario());
    }
    
    // Fecha a tela e sai da mesma
    private void sair() {
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        textNome1 = new JTextField();
        textLocalizacao1 = new JTextField();
        jLabel8 = new JLabel();
        ComboBoxTipoAmbiente1 = new JComboBox<>();
        spinnerCapacidade1 = new JSpinner();
        panelBotoes = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textId = new JTextField();
        ComboBoxPessoa = new JComboBox<>();
        jLabel9 = new JLabel();
        passwordSenha = new JPasswordField();
        jLabel2 = new JLabel();

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        jLabel5.setForeground(new Color(255, 0, 0));
        jLabel5.setText("Nome:");

        jLabel6.setText("TipoAmbiente:");

        jLabel7.setText("Capacidade:");

        jLabel8.setText("Localização:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textLocalizacao1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNome1, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(ComboBoxTipoAmbiente1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spinnerCapacidade1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxTipoAmbiente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinnerCapacidade1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textLocalizacao1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edita Login");

        panelBotoes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonSalvar);

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Id:");

        ComboBoxPessoa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxPessoaMouseClicked(evt);
            }
        });
        ComboBoxPessoa.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxPessoaKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxPessoaKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("Pessoa:");

        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("Senha:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textId)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxPessoa, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(passwordSenha))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(418, 219));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        // Valida os campos obrigatorios antes de salvar
        if (Validacao.Vazio(textId.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o id do login",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(String.valueOf(passwordSenha.getPassword()))) {

            JOptionPane.showMessageDialog(this,
                "Informe a senha",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxPessoa.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe a pessoa",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idAntes = login.getId();
        
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        login.setId(textId.getText());
        login.setSenha(String.valueOf(passwordSenha.getPassword()));
        login.setUsuario((Pessoa) ComboBoxPessoa.getSelectedItem());
                
        try {
            // Verifica se ja existe este login cadastrado
            if (servico.existeLoginEdita(login, idAntes)) {
                JOptionPane.showMessageDialog(this, "Já tem um cadastro com este id!", "Dica", JOptionPane.ERROR_MESSAGE);
                return ;
            }
        } catch (ExcecaoDAO ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        try {
            // Salva no banco de dados o Login
            servico.editar(login);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro editado com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);

        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void ComboBoxPessoaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPessoaKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxPessoaKeyReleased

    private void ComboBoxPessoaMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxPessoaMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaPessoa == null) {

            // Instancia o tela de incluir do Pessoa
            telaPessoa = new PessoaInclui(parent, true, new ServicoPessoa());

            // Faz ela ficar visivel
            telaPessoa.setVisible(true);

            // A tela foi instanciada
            entrou = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box do Pessoa
            PreencheComboBoxPessoa();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrou) {

            // Se ela foi fechada
            if (!telaPessoa.isActive()) {

                // Faz ela ficar visivel
                telaPessoa.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box do Pessoa
                PreencheComboBoxPessoa();
            }
        }
    }//GEN-LAST:event_ComboBoxPessoaMouseClicked

    private void ComboBoxPessoaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPessoaKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxPessoaKeyPressed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxPessoa;
    private JComboBox<String> ComboBoxTipoAmbiente1;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel panelBotoes;
    private JPasswordField passwordSenha;
    private JSpinner spinnerCapacidade1;
    private JTextField textId;
    private JTextField textLocalizacao1;
    private JTextField textNome1;
    // End of variables declaration//GEN-END:variables
}