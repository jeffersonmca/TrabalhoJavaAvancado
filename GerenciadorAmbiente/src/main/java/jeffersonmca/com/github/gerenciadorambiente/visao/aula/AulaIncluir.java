package jeffersonmca.com.github.gerenciadorambiente.visao.aula;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumDiaSemana;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAula;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoTurma;
import jeffersonmca.com.github.gerenciadorambiente.servico.Validacao;

public class AulaIncluir extends javax.swing.JDialog {

    private ServicoAula servico;
    private ServicoAmbiente ambServico;
    private ServicoTurma turServico;
    
    public AulaIncluir(java.awt.Frame parent, boolean modal, ServicoAula servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        ambServico = new ServicoAmbiente();
        turServico = new ServicoTurma();
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        
        DefaultComboBoxModel dcbmDiaSemana = new DefaultComboBoxModel(EnumDiaSemana.values());
        ComboBoxDiaSemana.setModel(dcbmDiaSemana);
        
        List<Ambiente> lista1 = null;
        try {
            lista1 = ambServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Ambiente> vetor1 = new Vector<>(lista1);
        
        DefaultComboBoxModel dcbmAmbiente =
               new DefaultComboBoxModel(vetor1);
        ComboBoxAmbiente.setModel(dcbmAmbiente);
        
        List<Turma> lista2 = null;
        try {
            lista2 = turServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Turma> vetor2 = new Vector<>(lista2);
        
        DefaultComboBoxModel dcbmTurma =
               new DefaultComboBoxModel(vetor2);
        ComboBoxAmbiente.setModel(dcbmTurma);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        buttonSalvar = new JButton();
        buttonCancelar = new JButton();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        ComboBoxDiaSemana = new JComboBox<>();
        ComboBoxAmbiente = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxTurma = new JComboBox<>();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        textHorarioInicio = new JTextField();
        try {
            MaskFormatter mf = new MaskFormatter("##:##");
            JTextField jf = new JFormattedTextField(mf);
        } catch (Exception e) {
        }
        textHorarioTermino = new JTextField();
        try {     MaskFormatter mf = new MaskFormatter("##:##");     JTextField jf = new JFormattedTextField(mf); } catch (Exception e) { }

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir registro");

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

        jLabel2.setForeground(new Color(255, 0, 51));
        jLabel2.setText("Dia da Semana:");

        jLabel3.setForeground(new Color(255, 0, 51));
        jLabel3.setText("Ambiente:");

        ComboBoxAmbiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxAmbienteActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new Color(255, 0, 51));
        jLabel4.setText("Turma:");

        jLabel5.setForeground(new Color(255, 0, 51));
        jLabel5.setText("Horário de Inicio:");

        jLabel6.setForeground(new Color(255, 0, 51));
        jLabel6.setText("Horário de Término:");

        textHorarioInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textHorarioInicioActionPerformed(evt);
            }
        });

        textHorarioTermino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textHorarioTerminoActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textHorarioTermino, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxTurma, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxAmbiente, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxDiaSemana, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxAmbiente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxDiaSemana, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(textHorarioTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        if (ComboBoxAmbiente.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o ambiente",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxDiaSemana.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o dia da semana",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxTurma.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe a turma",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textHorarioInicio.getText())) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o horário de início da aula",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Validacao.Vazio(textHorarioTermino.getText())) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o horário de término da aula",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Aula a = new Aula();
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            a.setHorarioInicio(sdf.parse(textHorarioInicio.getText()));
            a.setHorarioTermino(sdf.parse(textHorarioTermino.getText()));
        } catch (ParseException e) {}
        
        a.setFkAmbiente((Ambiente) ComboBoxAmbiente.getSelectedItem());
        a.setDiaSemana((EnumDiaSemana) ComboBoxDiaSemana.getSelectedItem());
        a.setTurma((Turma) ComboBoxTurma.getSelectedItem());
        
        try {
            servico.salvar(a);
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

    private void ComboBoxAmbienteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ComboBoxAmbienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxAmbienteActionPerformed

    private void textHorarioTerminoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioTerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioTerminoActionPerformed

    private void textHorarioInicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioInicioActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxAmbiente;
    private JComboBox<String> ComboBoxDiaSemana;
    private JComboBox<String> ComboBoxTurma;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField textHorarioInicio;
    private JTextField textHorarioTermino;
    // End of variables declaration//GEN-END:variables
}