package jeffersonmca.com.github.gerenciadorambiente.visao.login;

import jeffersonmca.com.github.gerenciadorambiente.visao.curso.*;
import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class LoginInclui extends javax.swing.JDialog {

    private ServicoLogin servico;
    private ServicoPessoa pesServico;
    private boolean ctrl;
    private PessoaInclui telaPessoa;
    private java.awt.Frame parent;
    private boolean entrou;
    
    public LoginInclui(java.awt.Frame parent, boolean modal, ServicoLogin servico) {
        
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        this.pesServico = new ServicoPessoa();
        this.ctrl = false;
        this.telaPessoa = null;
        this.parent = parent;
        this.entrou = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
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
    
    // Fecha a tela e sai da mesma
    private void sair() {
        setVisible(false);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textId = new JTextField();
        ComboBoxPessoa = new JComboBox<>();
        jLabel9 = new JLabel();
        passwordSenha = new JPasswordField();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Login");

        jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalvar);

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancelar);

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
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 219));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
        if (Validacao.Vazio(textId.getText())) {

            JOptionPane.showMessageDialog(this,
                "Informe o id do login",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(String.valueOf(passwordSenha.getPassword()))) {

            JOptionPane.showMessageDialog(this,
                "Informe a senha",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxPessoa.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe a pessoa",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Todos os campos obrigatorios estao preenchidos
        // Instancia um novo objeto do tipo Login
        Login l = new Login();
        
        // Preenche esse objeto com os dados da tela
        l.setId(textId.getText());
        l.setSenha(String.valueOf(passwordSenha.getPassword()));
        l.setUsuario((Pessoa) ComboBoxPessoa.getSelectedItem());
                
        try {
            // Verifica se ja existe este login cadastrado
            if (servico.existeLogin(l)) {
                JOptionPane.showMessageDialog(this, "Já tem um cadastro com este id!", "Dica", JOptionPane.ERROR_MESSAGE);
                return ;
            }
        } catch (ExcecaoDAO ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        try {
            // Salva no banco de dados o novo Login
            servico.salvar(l);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro incluído com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
        
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

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

    private void ComboBoxPessoaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPessoaKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxPessoaKeyReleased

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxPessoa;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPasswordField passwordSenha;
    private JTextField textId;
    // End of variables declaration//GEN-END:variables
}