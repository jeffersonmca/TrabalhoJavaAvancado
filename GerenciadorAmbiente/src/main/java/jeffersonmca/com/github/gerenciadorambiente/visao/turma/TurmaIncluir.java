package jeffersonmca.com.github.gerenciadorambiente.visao.turma;

import jeffersonmca.com.github.gerenciadorambiente.visao.aula.*;
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
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoTurma;
import javax.swing.text.MaskFormatter;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoAmbiente;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoDisciplina;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoTurma;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;

public class TurmaIncluir extends javax.swing.JDialog {

    private ServicoTurma servico;
    private ServicoDisciplina disServico;
    private ServicoPeriodo perServico;
    private ServicoPessoa proServico;
    
    public TurmaIncluir(java.awt.Frame parent, boolean modal, ServicoTurma servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        disServico = new ServicoDisciplina();
        perServico = new ServicoPeriodo();
        proServico = new ServicoPessoa();
        
        PreencheComboBox();
    }
    
    private void PreencheComboBox() {
        
        List<Disciplina> lista1 = null;
        try {
            lista1 = disServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Disciplina> vetor1 = new Vector<>(lista1);
        
        DefaultComboBoxModel dcbmDisciplina =
               new DefaultComboBoxModel(vetor1);
        ComboBoxDisciplina.setModel(dcbmDisciplina);
        
        List<Periodo> lista2 = null;
        try {
            lista2 = perServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Periodo> vetor2 = new Vector<>(lista2);
        
        DefaultComboBoxModel dcbmPeriodo =
               new DefaultComboBoxModel(vetor2);
        ComboBoxPeriodo.setModel(dcbmPeriodo);
        
        List<Pessoa> lista3 = null;
        try {
            lista3 = proServico.buscarTodosProfessores();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Pessoa> vetor3 = new Vector<>(lista3);
        
        DefaultComboBoxModel dcbmProfessor =
               new DefaultComboBoxModel(vetor3);
        ComboBoxProfessor.setModel(dcbmProfessor);
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
        ComboBoxProfessor = new JComboBox<>();
        ComboBoxDisciplina = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxPeriodo = new JComboBox<>();
        jLabel9 = new JLabel();
        textNome = new JTextField();

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
        jLabel2.setText("Professor:");

        jLabel3.setForeground(new Color(255, 0, 51));
        jLabel3.setText("Disciplina:");

        ComboBoxDisciplina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxDisciplinaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new Color(255, 0, 51));
        jLabel4.setText("Periodo:");

        jLabel9.setForeground(new Color(255, 0, 51));
        jLabel9.setText("Nome:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBoxProfessor, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBoxDisciplina, 0, 190, Short.MAX_VALUE)
                            .addComponent(textNome))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(424, 322));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        if (Validacao.Vazio(textNome.getText())) {
            
            JOptionPane.showMessageDialog(this, 
                    "Informe o nome da turma",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxDisciplina.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe a disciplina",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxPeriodo.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o periodo",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ComboBoxProfessor.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(this, 
                    "Informe o professor",
                    "Inclusão",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Turma t = new Turma();
        
        t.setNome(textNome.getText());
        t.setFkDisciplina((Disciplina) ComboBoxDisciplina.getSelectedItem());
        t.setFkPeriodo((Periodo) ComboBoxPeriodo.getSelectedItem());
        t.setFkProfessor((Pessoa) ComboBoxProfessor.getSelectedItem());
        
        try {
            servico.salvar(t);
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

    private void ComboBoxDisciplinaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ComboBoxDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDisciplinaActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxDisciplina;
    private JComboBox<String> ComboBoxPeriodo;
    private JComboBox<String> ComboBoxProfessor;
    private JButton buttonCancelar;
    private JButton buttonSalvar;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}