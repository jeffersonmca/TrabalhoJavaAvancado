package jeffersonmca.com.github.gerenciadorambiente.visao.aula;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;
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
import jeffersonmca.com.github.gerenciadorambiente.util.Conversoes;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.AmbienteInclui;
import jeffersonmca.com.github.gerenciadorambiente.visao.turma.TurmaInclui;

public class AulaEdita extends javax.swing.JDialog {

    private Aula aula;
    private ServicoAula servico;
    private ServicoAmbiente ambServico;
    private ServicoTurma turServico;
    private boolean ctrl;
    private AmbienteInclui telaAmbiente;
    private TurmaInclui telaTurma;
    private java.awt.Frame parent;
    private boolean entrouAmbiente;
    private boolean entrouTurma;
    
    public AulaEdita(java.awt.Frame parent, boolean modal, ServicoAula servico, Aula aula) {
        
        super(parent, modal);
        initComponents();
        
        this.aula = aula;
        this.servico = servico;
        this.ambServico = new ServicoAmbiente();
        this.turServico = new ServicoTurma();
        this.ctrl = false;
        this.telaAmbiente = null;
        this.telaTurma = null;
        this.parent = parent;
        this.entrouAmbiente = false;
        this.entrouTurma = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Como esta editando os dados de uma Aula especifica, os campos seram preenchidos
        // com os dados desse objeto para entao poder edita-los
        PreencheCampos(aula);
    }
    
    // Preenche combo box do Enum Dia Semana
    private void PreencheComboBoxDiaSemana() {
        DefaultComboBoxModel dcbmDiaSemana = new DefaultComboBoxModel(EnumDiaSemana.values());
        ComboBoxDiaSemana.setModel(dcbmDiaSemana);
    }
    
    // Preenche combo box do Ambiente
    private void PreencheComboBoxAmbiente() {
        List<Ambiente> lista = null;
        try {
            lista = ambServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Ambiente> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmAmbiente =
               new DefaultComboBoxModel(vetor);
        ComboBoxAmbiente.setModel(dcbmAmbiente);
    }
    
    // Preenche combo box da Turma
    private void PreencheComboBoxTurma() {
        List<Turma> lista = null;
        try {
            lista = turServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Turma> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmTurma =
               new DefaultComboBoxModel(vetor);
        ComboBoxTurma.setModel(dcbmTurma);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxDiaSemana();
        PreencheComboBoxAmbiente();
        PreencheComboBoxTurma();
    }
    
    // Como esta editando os dados de uma Aula especifico, os campos seram preenchidos
    // com os dados desse objeto para entao poder edita-los
    private void PreencheCampos(Aula aula) {
        ComboBoxAmbiente.setSelectedItem(aula.getFkAmbiente());
        ComboBoxDiaSemana.setSelectedItem(aula.getDiaSemana());
        ComboBoxTurma.setSelectedItem(aula.getTurma());
        textHorarioInicio.setText(Conversoes.timeToStr(aula.getHorarioInicio()));
        textHorarioTermino.setText(Conversoes.timeToStr(aula.getHorarioTermino()));
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        ComboBoxDiaSemana = new JComboBox<>();
        ComboBoxAmbiente = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxTurma = new JComboBox<>();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        textHorarioInicio = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("##:##");
            textHorarioInicio = new JFormattedTextField(mf);
        }catch (Exception e){}
        textHorarioTermino = new JTextField();
        try{
            MaskFormatter mf = new MaskFormatter("##:##");
            textHorarioTermino = new JFormattedTextField(mf);
        }catch (Exception e){}

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
        setTitle("Edita Aula");

        panelBotoes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonSalvar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/Salvar.png"))); // NOI18N
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

        buttonCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
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

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel2.setForeground(new Color(255, 0, 51));
        jLabel2.setText("Dia da Semana:");

        jLabel3.setForeground(new Color(255, 0, 51));
        jLabel3.setText("Ambiente:");

        ComboBoxAmbiente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxAmbienteMouseClicked(evt);
            }
        });
        ComboBoxAmbiente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxAmbienteKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxAmbienteKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new Color(255, 0, 51));
        jLabel4.setText("Turma:");

        ComboBoxTurma.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxTurmaMouseClicked(evt);
            }
        });
        ComboBoxTurma.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxTurmaKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxTurmaKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new Color(255, 0, 51));
        jLabel9.setText("Horário de Inicio:");

        jLabel10.setForeground(new Color(255, 0, 51));
        jLabel10.setText("Horário de Término:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBoxTurma, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ComboBoxAmbiente, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(ComboBoxDiaSemana, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(3, 3, 3)
                        .addComponent(textHorarioTermino, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxAmbiente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxDiaSemana, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textHorarioInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textHorarioTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(393, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseEntered

    private void buttonSalvarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonSalvarMouseExited

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
        if (ComboBoxAmbiente.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o ambiente",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxTurma.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe a turma",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxDiaSemana.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o dia da semana",
                    "Edição",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
                       
        // Transforma string para hora
        Date aux1 = Conversoes.strToTime(textHorarioInicio.getText());
        Date aux2 = Conversoes.strToTime(textHorarioTermino.getText());
        
        if (!Validacao.Alocado(aux1)) {

            JOptionPane.showMessageDialog(this,
                "Informe o horário de início da aula",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Validacao.Alocado(aux2)) {

            JOptionPane.showMessageDialog(this,
                "Informe o horário de término da aula",
                "Edição",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Todos os campos obrigatorios estao preenchidos
        // Preenche esse objeto com os dados da tela
        aula.setFkAmbiente((Ambiente) ComboBoxAmbiente.getSelectedItem());
        aula.setTurma((Turma) ComboBoxTurma.getSelectedItem());
        aula.setDiaSemana((EnumDiaSemana) ComboBoxDiaSemana.getSelectedItem());
        aula.setHorarioInicio(aux1);
        aula.setHorarioTermino(aux2);
        
        try {
            // Salva no banco de dados a Aula
            servico.editar(aula);
        } catch (ExcecaoServico|ExcecaoDAO|ExcecaoValidacao e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro editado com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
        
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarMouseEntered(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseEntered

    private void buttonCancelarMouseExited(MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonCancelarMouseExited

    private void buttonCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Fecha a tela e sai da mesma
        sair();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void ComboBoxAmbienteMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxAmbienteMouseClicked
        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaAmbiente == null) {
            
            // Instancia o tela de incluir do Ambiente
            telaAmbiente = new AmbienteInclui(parent, true, new ServicoAmbiente());
            
            // Faz ela ficar visivel
            telaAmbiente.setVisible(true);
            
            // A tela foi instanciada
            entrouAmbiente = true;
            
            // Para de apertar Ctrl
            ctrl = false;
            
            // Preenche combo box do Ambiente
            PreencheComboBoxAmbiente();
            
        // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouAmbiente) {
            
            // Se ela foi fechada
            if (!telaAmbiente.isActive()) {
                
                // Faz ela ficar visivel
                telaAmbiente.setVisible(true);
                
                // Para de apertar Ctrl
                ctrl = false;
                
                // Preenche combo box do Ambiente
                PreencheComboBoxAmbiente();
            }
        }
    }//GEN-LAST:event_ComboBoxAmbienteMouseClicked

    private void ComboBoxTurmaMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxTurmaMouseClicked
        
        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaTurma == null) {
            
            // Instancia o tela de incluir da Turma
            telaTurma = new TurmaInclui(parent, true, new ServicoTurma());
            
            // Faz ela ficar visivel
            telaTurma.setVisible(true);
            
            // A tela foi instanciada
            entrouTurma = true;
            
            // Para de apertar Ctrl
            ctrl = false;
            
            // Preenche combo box da Turma
            PreencheComboBoxTurma();
            
        // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouTurma) {
            
            // Se ela foi fechada
            if (!telaTurma.isActive()) {
                
                // Faz ela ficar visivel
                telaTurma.setVisible(true);
                
                // Para de apertar Ctrl
                ctrl = false;
                
                // Preenche combo box da Turma
                PreencheComboBoxTurma();
            }
        }
    }//GEN-LAST:event_ComboBoxTurmaMouseClicked

    private void ComboBoxAmbienteKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxAmbienteKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxAmbienteKeyPressed

    private void ComboBoxAmbienteKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxAmbienteKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxAmbienteKeyReleased

    private void ComboBoxTurmaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxTurmaKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = true;
    }//GEN-LAST:event_ComboBoxTurmaKeyPressed

    private void ComboBoxTurmaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxTurmaKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
            ctrl = false;
    }//GEN-LAST:event_ComboBoxTurmaKeyReleased

   
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