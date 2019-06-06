package jeffersonmca.com.github.gerenciadorambiente.visao.pessoa;

import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumTipoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;

public class PessoaInclui extends javax.swing.JDialog {

    private ServicoPessoa servico;    
    
    public PessoaInclui(java.awt.Frame parent, boolean modal, ServicoPessoa servico) {
        super(parent, modal);
        initComponents();
        this.servico = servico;
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        
        DefaultComboBoxModel dcbmTipoPessoa = new DefaultComboBoxModel(EnumTipoPessoa.values());
        ComboBoxTipoPessoa.setModel(dcbmTipoPessoa);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        textNome = new JTextField();
        textEmail = new JTextField();
        ComboBoxTipoPessoa = new JComboBox<>();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Pessoa");

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalvar);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancelar);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Nome:");

        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("E-mail:");

        jLabel10.setForeground(new Color(255, 0, 0));
        jLabel10.setText("Tipo Pessoa:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNome, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(ComboBoxTipoPessoa, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEmail))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxTipoPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome da pessoa",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textEmail.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o email",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxTipoPessoa.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this,
                "Informe o tipo da pessoa",
                "Inclusão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Pessoa p = new Pessoa();
        
        p.setNome(textNome.getText());
        p.setEmail(textEmail.getText());
        p.setTipoPessoa((EnumTipoPessoa) ComboBoxTipoPessoa.getSelectedItem());
        
        try {
            servico.salvar(p);
        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxTipoPessoa;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField textEmail;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}