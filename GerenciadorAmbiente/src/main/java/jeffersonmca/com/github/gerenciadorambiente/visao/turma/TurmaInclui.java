package jeffersonmca.com.github.gerenciadorambiente.visao.turma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import jeffersonmca.com.github.gerenciadorambiente.visao.disciplina.DisciplinaInclui;
import jeffersonmca.com.github.gerenciadorambiente.visao.periodo.PeriodoInclui;
import jeffersonmca.com.github.gerenciadorambiente.visao.pessoa.PessoaInclui;

public class TurmaInclui extends javax.swing.JDialog {

    private ServicoTurma servico;
    private ServicoDisciplina disServico;
    private ServicoPeriodo perServico;
    private ServicoPessoa proServico;
    private ServicoPessoa aluServico;
    private List<Pessoa> alunos;
    private boolean ctrl;
    private DisciplinaInclui telaDisciplina;
    private PeriodoInclui telaPeriodo;
    private PessoaInclui telaProfessor;
    private PessoaInclui telaAluno;
    private java.awt.Frame parent;
    private boolean entrouDisciplina;
    private boolean entrouPeriodo;
    private boolean entrouProfessor;
    private boolean entrouAluno;
    
    public TurmaInclui(java.awt.Frame parent, boolean modal, ServicoTurma servico) {
        
        super(parent, modal);
        initComponents();
        
        this.servico = servico;
        this.disServico = new ServicoDisciplina();
        this.perServico = new ServicoPeriodo();
        this.proServico = new ServicoPessoa();
        this.aluServico = new ServicoPessoa();
        this.alunos  = new ArrayList<>();
        this.ctrl = false;
        this.telaDisciplina = null;
        this.telaPeriodo = null;
        this.telaProfessor = null;
        this.telaAluno = null;
        this.parent = parent;
        this.entrouDisciplina = false;
        this.entrouPeriodo = false;
        this.entrouProfessor = false;
        this.entrouAluno = false;
        
        // Preenche todos os cambo box da tela
        PreencheComboBox();
        
        // Atualiza os dados da grid dos alunos
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
    
    // Preenche combo box do Aluno
    private void PreencheComboBoxAluno() {
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
    
    // Preenche todos os cambo box da tela
    private void PreencheComboBox() {
        PreencheComboBoxDisciplina();
        PreencheComboBoxPeriodo();
        PreencheComboBoxProfessor();
    }
    
    // Atualiza os dados da grid dos alunos
    private void carregaTable() {
        AlunosTableModel atm = new AlunosTableModel(alunos);
        tableAlunos.setModel(atm);
        
        // Preenche combo box do Aluno
        PreencheComboBoxAluno();
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        ComboBoxProfessor = new JComboBox<>();
        ComboBoxDisciplina = new JComboBox<>();
        jLabel4 = new JLabel();
        ComboBoxPeriodo = new JComboBox<>();
        jLabel9 = new JLabel();
        textNome = new JTextField();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        buttonRemover = new JButton();
        jPanel5 = new JPanel();
        jLabel10 = new JLabel();
        ComboBoxAluno = new JComboBox<>();
        buttonAdicionar = new JButton();
        jPanel6 = new JPanel();
        jScrollPane1 = new JScrollPane();
        tableAlunos = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclui Turma");

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

        jLabel2.setForeground(new Color(255, 0, 51));
        jLabel2.setText("Professor:");

        jLabel3.setForeground(new Color(255, 0, 51));
        jLabel3.setText("Disciplina:");

        ComboBoxProfessor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxProfessorMouseClicked(evt);
            }
        });
        ComboBoxProfessor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxProfessorKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxProfessorKeyReleased(evt);
            }
        });

        ComboBoxDisciplina.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxDisciplinaMouseClicked(evt);
            }
        });
        ComboBoxDisciplina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxDisciplinaActionPerformed(evt);
            }
        });
        ComboBoxDisciplina.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxDisciplinaKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxDisciplinaKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new Color(255, 0, 51));
        jLabel4.setText("Periodo:");

        ComboBoxPeriodo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxPeriodoMouseClicked(evt);
            }
        });
        ComboBoxPeriodo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxPeriodoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxPeriodoKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new Color(255, 0, 51));
        jLabel9.setText("Nome:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(3, 3, 3)
                        .addComponent(textNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxDisciplina, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxProfessor, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboBoxProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(61, 61, 61))
        );

        jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        buttonRemover.setIcon(new ImageIcon(getClass().getResource("/imagens/images/remover.png"))); // NOI18N
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRemover)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonRemover))
        );

        jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel10.setForeground(new Color(21, 5, 8));
        jLabel10.setText("Aluno:");

        ComboBoxAluno.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ComboBoxAlunoMouseClicked(evt);
            }
        });
        ComboBoxAluno.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ComboBoxAlunoKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                ComboBoxAlunoKeyReleased(evt);
            }
        });

        buttonAdicionar.setIcon(new ImageIcon(getClass().getResource("/imagens/images/incluir.png"))); // NOI18N
        buttonAdicionar.setText("Adicionar");
        buttonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxAluno, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAdicionar)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdicionar)
                    .addComponent(jLabel10)))
        );

        jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

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

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        setSize(new Dimension(436, 664));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        // Valida os campos obrigatorios antes de salvar
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
        
        // Todos os campos obrigatorios estao preenchidos
        // Instancia um novo objeto do tipo Turma
        Turma t = new Turma();
        
        // Preenche esse objeto com os dados da tela        
        t.setNome(textNome.getText());
        t.setFkDisciplina((Disciplina) ComboBoxDisciplina.getSelectedItem());
        t.setFkPeriodo((Periodo) ComboBoxPeriodo.getSelectedItem());
        t.setFkProfessor((Pessoa) ComboBoxProfessor.getSelectedItem());        
        t.setAlunos(alunos);
        
        try {
            // Salva no banco de dados a nova Turma
            servico.salvar(t);
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

    private void ComboBoxProfessorMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxProfessorMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaProfessor == null) {

            // Instancia o tela de incluir do Professor
            telaProfessor = new PessoaInclui(parent, true, new ServicoPessoa());

            // Faz ela ficar visivel
            telaProfessor.setVisible(true);

            // A tela foi instanciada
            entrouProfessor = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box do Professor
            PreencheComboBoxProfessor();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouProfessor) {

            // Se ela foi fechada
            if (!telaProfessor.isActive()) {

                // Faz ela ficar visivel
                telaProfessor.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box do Professor
                PreencheComboBoxProfessor();
            }
        }
    }//GEN-LAST:event_ComboBoxProfessorMouseClicked

    private void ComboBoxProfessorKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxProfessorKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxProfessorKeyPressed

    private void ComboBoxProfessorKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxProfessorKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxProfessorKeyReleased

    private void ComboBoxDisciplinaMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxDisciplinaMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaDisciplina == null) {

            // Instancia o tela de incluir da Disciplina
            telaDisciplina = new DisciplinaInclui(parent, true, new ServicoDisciplina());

            // Faz ela ficar visivel
            telaDisciplina.setVisible(true);

            // A tela foi instanciada
            entrouDisciplina = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box da Disciplina
            PreencheComboBoxDisciplina();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouDisciplina) {

            // Se ela foi fechada
            if (!telaDisciplina.isActive()) {

                // Faz ela ficar visivel
                telaDisciplina.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box da Disciplina
                PreencheComboBoxDisciplina();
            }
        }
    }//GEN-LAST:event_ComboBoxDisciplinaMouseClicked

    private void ComboBoxDisciplinaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ComboBoxDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDisciplinaActionPerformed

    private void ComboBoxDisciplinaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxDisciplinaKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxDisciplinaKeyPressed

    private void ComboBoxDisciplinaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxDisciplinaKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxDisciplinaKeyReleased

    private void ComboBoxPeriodoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxPeriodoMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaPeriodo == null) {

            // Instancia o tela de incluir do Periodo
            telaPeriodo = new PeriodoInclui(parent, true, new ServicoPeriodo());

            // Faz ela ficar visivel
            telaPeriodo.setVisible(true);

            // A tela foi instanciada
            entrouPeriodo = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box do Periodo
            PreencheComboBoxPeriodo();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouPeriodo) {

            // Se ela foi fechada
            if (!telaPeriodo.isActive()) {

                // Faz ela ficar visivel
                telaPeriodo.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box do Periodo
                PreencheComboBoxPeriodo();
            }
        }
    }//GEN-LAST:event_ComboBoxPeriodoMouseClicked

    private void ComboBoxPeriodoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPeriodoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxPeriodoKeyPressed

    private void ComboBoxPeriodoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxPeriodoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxPeriodoKeyReleased

    private void buttonRemoverActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed

        if (tableAlunos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro.");
            return;
        }

        Pessoa aux = alunos.get(tableAlunos.getSelectedRow());

        if (aux == null) {
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

    private void ComboBoxAlunoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ComboBoxAlunoMouseClicked

        // Se pressionou Ctrl e a tela ainda nao foi instanciada
        if (ctrl && telaAluno == null) {

            // Instancia o tela de incluir do Aluno
            telaAluno = new PessoaInclui(parent, true, new ServicoPessoa());

            // Faz ela ficar visivel
            telaAluno.setVisible(true);

            // A tela foi instanciada
            entrouAluno = true;

            // Para de apertar Ctrl
            ctrl = false;

            // Preenche combo box do Aluno
            PreencheComboBoxAluno();

            // Se pressionou Ctrl e a tela foi instanciada
        }else if (ctrl && entrouAluno) {

            // Se ela foi fechada
            if (!telaAluno.isActive()) {

                // Faz ela ficar visivel
                telaAluno.setVisible(true);

                // Para de apertar Ctrl
                ctrl = false;

                // Preenche combo box do Aluno
                PreencheComboBoxAluno();
            }
        }
    }//GEN-LAST:event_ComboBoxAlunoMouseClicked

    private void ComboBoxAlunoKeyPressed(KeyEvent evt) {//GEN-FIRST:event_ComboBoxAlunoKeyPressed
        // Pressionou Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = true;
    }//GEN-LAST:event_ComboBoxAlunoKeyPressed

    private void ComboBoxAlunoKeyReleased(KeyEvent evt) {//GEN-FIRST:event_ComboBoxAlunoKeyReleased
        // Parou de pressionar Ctrl
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL)
        ctrl = false;
    }//GEN-LAST:event_ComboBoxAlunoKeyReleased

    private void buttonAdicionarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed

        // Verifica se tem algum aluno selecionado
        if (!(ComboBoxAluno.getSelectedIndex() <= -1)) {
            alunos.add((Pessoa) ComboBoxAluno.getSelectedItem());
            carregaTable();
        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> ComboBoxAluno;
    private JComboBox<String> ComboBoxDisciplina;
    private JComboBox<String> ComboBoxPeriodo;
    private JComboBox<String> ComboBoxProfessor;
    private JButton buttonAdicionar;
    private JButton buttonCancelar;
    private JButton buttonRemover;
    private JButton buttonSalvar;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JTable tableAlunos;
    private JTextField textNome;
    // End of variables declaration//GEN-END:variables
}