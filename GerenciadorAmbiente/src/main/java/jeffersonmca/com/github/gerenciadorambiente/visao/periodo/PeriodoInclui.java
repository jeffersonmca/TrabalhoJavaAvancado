package jeffersonmca.com.github.gerenciadorambiente.visao.periodo;

import jeffersonmca.com.github.gerenciadorambiente.visao.curso.*;
import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Curso;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumSemestre;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;

public class PeriodoInclui extends javax.swing.JDialog {

    private ServicoPeriodo servico;
    
    public PeriodoInclui(java.awt.Frame parent, boolean modal, ServicoPeriodo servico) {
        
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
    }
    
    // Preenche combo box do Enum Semestre
    private void PreencheComboBoxSemestre() {
        DefaultComboBoxModel dcbmSemestre = new DefaultComboBoxModel(EnumSemestre.values());
        ComboBoxSemestre.setModel(dcbmSemestre);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxSemestre();
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
        ComboBoxSemestre = new JComboBox<>();
        jLabel9 = new JLabel();
        spinnerAno = new JSpinner();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Período");

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

        jLabel1.setForeground(new Color(245, 14, 14));
        jLabel1.setText("Ano:");

        jLabel9.setForeground(new Color(255, 0, 0));
        jLabel9.setText("Semestre:");

        spinnerAno.setModel(new SpinnerNumberModel(2019, 0, null, 1));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(ComboBoxSemestre, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerAno, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(spinnerAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 181));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
        if (ComboBoxSemestre.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o semestre",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Todos os campos obrigatorios estao preenchidos
        // Instancia um novo objeto do tipo Periodo
        Periodo p = new Periodo();
        
        // Preenche esse objeto com os dados da tela
        p.setAno((Integer) spinnerAno.getValue());
        p.setSemestre((EnumSemestre) ComboBoxSemestre.getSelectedItem());
        
        try {
            // Salva no banco de dados o novo Periodo
            servico.salvar(p);
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

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxSemestre;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel1;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSpinner spinnerAno;
    // End of variables declaration//GEN-END:variables
}