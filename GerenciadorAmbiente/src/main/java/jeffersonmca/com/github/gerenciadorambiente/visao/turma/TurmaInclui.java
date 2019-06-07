package jeffersonmca.com.github.gerenciadorambiente.visao.turma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoValidacao;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Turma;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Periodo;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Pessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoDisciplina;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPeriodo;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoPessoa;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoTurma;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;

public class TurmaInclui extends javax.swing.JDialog {

    private ServicoTurma servico;
    private ServicoDisciplina disServico;
    private ServicoPeriodo perServico;
    private ServicoPessoa proServico;
    private ServicoPessoa aluServico;
    private List<Pessoa> alunos;
    
    public TurmaInclui(java.awt.Frame parent, boolean modal, ServicoTurma servico) {
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        this.disServico = new ServicoDisciplina();
        this.perServico = new ServicoPeriodo();
        this.proServico = new ServicoPessoa();
        this.aluServico = new ServicoPessoa();
        this.alunos  = new ArrayList<>();
        
        PreencheComboBox();
        carregaTable();
    }
    
    // Preenche combo box da Disciplina
    private void PreencheComboBoxDisciplina() {
        List<Disciplina> lista = null;
        try {
            lista = disServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Disciplina> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmDisciplina =
               new DefaultComboBoxModel(vetor);
        ComboBoxDisciplina.setModel(dcbmDisciplina);
    }
    
    // Preenche combo box do Periodo
    private void PreencheComboBoxPeriodo() {
        List<Periodo> lista = null;
        try {
            lista = perServico.buscarTodos();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Periodo> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmPeriodo =
               new DefaultComboBoxModel(vetor);
        ComboBoxPeriodo.setModel(dcbmPeriodo);
    }
    
    // Preenche combo box do Professor
    private void PreencheComboBoxProfessor() {
        List<Pessoa> lista = null;
        try {
            lista = proServico.buscarTodosProfessores();
        } catch (ExcecaoDAO ex) {}
        
        Vector<Pessoa> vetor = new Vector<>(lista);
        
        DefaultComboBoxModel dcbmProfessor =
               new DefaultComboBoxModel(vetor);
        ComboBoxProfessor.setModel(dcbmProfessor);
    }
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxDisciplina();
        PreencheComboBoxPeriodo();
        PreencheComboBoxProfessor();
    }
    
    private void carregaTable() {
        AlunosTableModel atm = new AlunosTableModel(alunos);
        tableAlunos.setModel(atm);
        
        atualizaComboAluno();
    }
    
    private void atualizaComboAluno() {
        List<Pessoa> lista4 = null;
        try {
            lista4 = aluServico.buscarAlunosForaDaGrid(alunos);
        } catch (ExcecaoDAO ex) {}
        
        Vector<Pessoa> vetor4 = new Vector<>(lista4);
        
        DefaultComboBoxModel dcbmAluno =
               new DefaultComboBoxModel(vetor4);
        ComboBoxAluno.setModel(dcbmAluno);
        
        // Nao coloca o foco em nenhum nome
        ComboBoxAluno.setSelectedIndex(-1);
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
        buttonAdicionar = new JButton();
        buttonRemover = new JButton();
        jScrollPane1 = new JScrollPane();
        tableAlunos = new JTable();
        ComboBoxAluno = new JComboBox<>();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Turma");

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

        buttonAdicionar.setText("Adicionar");
        buttonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        tableAlunos.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAlunos);

        jLabel5.setForeground(new Color(21, 5, 8));
        jLabel5.setText("Aluno:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxDisciplina, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxProfessor, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxAluno, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAdicionar)))
                        .addGap(289, 289, 289))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(32, 32, 32)
                                .addComponent(textNome, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdicionar)
                    .addComponent(jLabel5))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(buttonRemover)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new Dimension(436, 483));
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
        t.setAlunos(alunos);
        
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

    private void buttonAdicionarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        
        // Verifica se tem algum aluno selecionado
        if (!(ComboBoxAluno.getSelectedIndex() <= -1)) {
            alunos.add((Pessoa) ComboBoxAluno.getSelectedItem());
            carregaTable();
        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonRemoverActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed

        if (tableAlunos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro.");
            return;
        }

        Pessoa aux = alunos.get(tableAlunos.getSelectedRow());

        if (aux == null){
            JOptionPane.showMessageDialog(this, "Registro não encontrado.");
            return;
        }

        if (JOptionPane.showConfirmDialog(this,
            "Confirma a remoção do aluno: "
            + aux.getNome() + "?",
            "Remoção",
            JOptionPane.YES_NO_OPTION
        )== JOptionPane.YES_OPTION )
        {
            alunos.remove(tableAlunos.getSelectedRow());
            carregaTable();
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxAluno;
    private JComboBox<String> ComboBoxDisciplina;
    private JComboBox<String> ComboBoxPeriodo;
    private JComboBox<String> ComboBoxProfessor;
    private JButton buttonAdicionar;
    private JButton buttonCancelar;
    private JButton buttonRemover;
    private JButton buttonSalvar;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable tableAlunos;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}