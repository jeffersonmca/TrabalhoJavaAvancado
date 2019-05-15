package jeffersonmca.com.github.gerenciadorambiente.visao.aula;

import jeffersonmca.com.github.gerenciadorambiente.visao.aula.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
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
import jeffersonmca.com.github.gerenciadorambiente.modelo.Ambiente;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Aula;
import jeffersonmca.com.github.gerenciadorambiente.modelo.EnumDiaSemana;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAula;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoTurma;

public class AulaEdita extends javax.swing.JDialog {

    private ServicoAula servico;
    private ServicoAmbiente ambServico;
    private ServicoTurma turServico;
    private Integer codigo;
    
    public AulaEdita(java.awt.Frame parent, boolean modal, ServicoAula servico, Aula aula) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        ambServico = new ServicoAmbiente();
        turServico = new ServicoTurma();
        
        PreencheComboBox();
        PreencheCampos(aula);
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
    
    private void PreencheCampos(Aula aula) {
        codigo = aula.getCodigo();
        codigo = aula.getCodigo();
        ComboBoxAmbiente.setSelectedItem(aula.getFkAmbiente());
        ComboBoxDiaSemana.setSelectedItem(aula.getDiaSemana());
        ComboBoxTurma.setSelectedItem(aula.getTurma());
        textHorarioInicio.setText(aula.getHorarioInicio().toString());
        textHorarioTermino.setText(aula.getHorarioTermino().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        ComboBoxDiaSemana = new JComboBox<>();
        ComboBoxAmbiente = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxTurma = new JComboBox<>();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        textHorarioInicio = new JTextField();
        try {
            MaskFormatter mf = new MaskFormatter("##:##");
            JTextField jf = new JFormattedTextField(mf);
        } catch (Exception e) {
        }
        textHorarioTermino = new JTextField();
        try {     MaskFormatter mf = new MaskFormatter("##:##");     JTextField jf = new JFormattedTextField(mf); } catch (Exception e) { }

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
        setTitle("Editar registro");

        panelBotoes.setBorder(BorderFactory.createEtchedBorder());

        buttonSalvar.setText("Salvar");
        buttonSalvar.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                buttonSalvarMouseExited(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonSalvarMouseEntered(evt);
            }
        });
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonSalvar);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                buttonCancelarMouseExited(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                buttonCancelarMouseEntered(evt);
            }
        });
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        panelBotoes.add(buttonCancelar);

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

        jLabel9.setForeground(new Color(255, 0, 51));
        jLabel9.setText("Horário de Inicio:");

        jLabel10.setForeground(new Color(255, 0, 51));
        jLabel10.setText("Horário de Término:");

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
                        .addComponent(jLabel10)
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
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxDiaSemana, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
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
                    .addComponent(jLabel9)
                    .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(textHorarioTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(418, 294));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseEntered

    private void buttonSalvarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseExited

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
//        Aula a = new Aula(codigo,
//                                  textNome.getText(),
//                                  (EnumTipoAula) ComboBoxTipoAula.getSelectedItem(),
//                                  (Integer)spinnerCapacidade.getValue(),
//                                  textLocalizacao.getText()
//        );        
//        
//        try {
//            servico.editar(a);
//        } catch (ExcecaoDAO|ExcecaoValidacao|ExcecaoServico e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarMouseEntered(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseEntered

    private void buttonCancelarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseExited

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void ComboBoxAmbienteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ComboBoxAmbienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxAmbienteActionPerformed

    private void textHorarioInicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioInicioActionPerformed

    private void textHorarioTerminoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textHorarioTerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHorarioTerminoActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxAmbiente;
    private JComboBox<String> ComboBoxDiaSemana;
    private JComboBox<String> ComboBoxTipoAmbiente1;
    private JComboBox<String> ComboBoxTurma;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel panelBotoes;
    private JSpinner spinnerCapacidade1;
    private JTextField textHorarioInicio;
    private JTextField textHorarioTermino;
    private JTextField textLocalizacao1;
    private JTextField textNome1;
    // End of variables declaration//GEN-END:variables
}