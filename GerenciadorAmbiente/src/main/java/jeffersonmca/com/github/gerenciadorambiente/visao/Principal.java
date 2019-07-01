package jeffersonmca.com.github.gerenciadorambiente.visao;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoLogin;
import jeffersonmca.com.github.gerenciadorambiente.util.Conversoes;
import jeffersonmca.com.github.gerenciadorambiente.util.Validacao;
import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.AmbienteListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.ambiente.AmbientePesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.aula.AulaListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.aula.AulaPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.curso.CursoListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.curso.CursoPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.disciplina.DisciplinaListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.disciplina.DisciplinaPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.login.LoginListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.login.LoginPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.periodo.PeriodoListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.periodo.PeriodoPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.pessoa.PessoaListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.pessoa.PessoaPesquisa;
import jeffersonmca.com.github.gerenciadorambiente.visao.turma.TurmaListagem;
import jeffersonmca.com.github.gerenciadorambiente.visao.turma.TurmaPesquisa;

public class Principal extends javax.swing.JFrame {

    private Login login;
    
    public Principal(Login login) {
        
        initComponents();
        
        this.login = login;
        
        // Preenche informacoes
        PreencheInformacoes();
    }
    
    // Preenche informacoes
    private void PreencheInformacoes() {
        
        labelIdLogado.setText(login.getId());
        labelUsuarioLogado.setText(login.getUsuario().getNome());
        labelData.setText(Conversoes.dateToStr(new Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsuarioLogado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelIdLogado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadMenuAmbiente = new javax.swing.JMenuItem();
        cadMenuAula = new javax.swing.JMenuItem();
        cadMenuCurso = new javax.swing.JMenuItem();
        cadMenuDisciplina = new javax.swing.JMenuItem();
        cadMenuLogin = new javax.swing.JMenuItem();
        cadMenuPeriodo = new javax.swing.JMenuItem();
        cadMenuPessoa = new javax.swing.JMenuItem();
        cadMenuTurma = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pesMenuAmbiente = new javax.swing.JMenuItem();
        pesMenuAula = new javax.swing.JMenuItem();
        pesMenuCurso = new javax.swing.JMenuItem();
        pesMenuDisciplina = new javax.swing.JMenuItem();
        pesMenuLogin = new javax.swing.JMenuItem();
        pesMenuPeriodo = new javax.swing.JMenuItem();
        pesMenuPessoa = new javax.swing.JMenuItem();
        pesMenuTurma = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        conMenuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Usuário:");

        jLabel3.setText("Data:");

        jLabel1.setText("id:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdLogado, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIdLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("Listagem");

        cadMenuAmbiente.setText("Ambiente");
        cadMenuAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuAmbienteActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuAmbiente);

        cadMenuAula.setText("Aula");
        cadMenuAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuAulaActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuAula);

        cadMenuCurso.setText("Curso");
        cadMenuCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuCursoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuCurso);

        cadMenuDisciplina.setText("Disciplina");
        cadMenuDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuDisciplinaActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuDisciplina);

        cadMenuLogin.setText("Login");
        cadMenuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuLoginActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuLogin);

        cadMenuPeriodo.setText("Período");
        cadMenuPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuPeriodoActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuPeriodo);

        cadMenuPessoa.setText("Pessoa");
        cadMenuPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuPessoaActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuPessoa);

        cadMenuTurma.setText("Turma");
        cadMenuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadMenuTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(cadMenuTurma);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pesquisa");

        pesMenuAmbiente.setText("Ambiente");
        pesMenuAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuAmbienteActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuAmbiente);

        pesMenuAula.setText("Aula");
        pesMenuAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuAulaActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuAula);

        pesMenuCurso.setText("Curso");
        pesMenuCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuCursoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuCurso);

        pesMenuDisciplina.setText("Disciplina");
        pesMenuDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuDisciplinaActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuDisciplina);

        pesMenuLogin.setText("Login");
        pesMenuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuLoginActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuLogin);

        pesMenuPeriodo.setText("Periodo");
        pesMenuPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuPeriodoActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuPeriodo);

        pesMenuPessoa.setText("Pessoa");
        pesMenuPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuPessoaActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuPessoa);

        pesMenuTurma.setText("Turma");
        pesMenuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesMenuTurmaActionPerformed(evt);
            }
        });
        jMenu3.add(pesMenuTurma);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Configurações");

        conMenuLogout.setText("Logout");
        conMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conMenuLogoutActionPerformed(evt);
            }
        });
        jMenu4.add(conMenuLogout);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 291, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadMenuAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuAmbienteActionPerformed
        AmbienteListagem tela = new AmbienteListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuAmbienteActionPerformed

    private void cadMenuAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuAulaActionPerformed
        AulaListagem tela = new AulaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuAulaActionPerformed

    private void cadMenuCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuCursoActionPerformed
        CursoListagem tela = new CursoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuCursoActionPerformed

    private void cadMenuDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuDisciplinaActionPerformed
        DisciplinaListagem tela = new DisciplinaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuDisciplinaActionPerformed

    private void cadMenuPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuPeriodoActionPerformed
        PeriodoListagem tela = new PeriodoListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuPeriodoActionPerformed

    private void cadMenuPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuPessoaActionPerformed
        PessoaListagem tela = new PessoaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuPessoaActionPerformed

    private void cadMenuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuTurmaActionPerformed
        TurmaListagem tela = new TurmaListagem();
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuTurmaActionPerformed

    private void pesMenuAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuAmbienteActionPerformed
        AmbientePesquisa tela = new AmbientePesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuAmbienteActionPerformed

    private void pesMenuAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuAulaActionPerformed
        AulaPesquisa tela = new AulaPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuAulaActionPerformed

    private void pesMenuCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuCursoActionPerformed
        CursoPesquisa tela = new CursoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuCursoActionPerformed

    private void pesMenuDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuDisciplinaActionPerformed
        DisciplinaPesquisa tela = new DisciplinaPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuDisciplinaActionPerformed

    private void pesMenuPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuPeriodoActionPerformed
        PeriodoPesquisa tela = new PeriodoPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuPeriodoActionPerformed

    private void pesMenuPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuPessoaActionPerformed
        PessoaPesquisa tela = new PessoaPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuPessoaActionPerformed

    private void pesMenuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuTurmaActionPerformed
        TurmaPesquisa tela = new TurmaPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuTurmaActionPerformed

    private void cadMenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadMenuLoginActionPerformed
        LoginListagem tela = new LoginListagem(login);
        tela.setVisible(true);
    }//GEN-LAST:event_cadMenuLoginActionPerformed

    private void pesMenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesMenuLoginActionPerformed
        LoginPesquisa tela = new LoginPesquisa();
        tela.setVisible(true);
    }//GEN-LAST:event_pesMenuLoginActionPerformed

    private void conMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conMenuLogoutActionPerformed
        
        this.setVisible(false);
        this.dispose();
        
        VisaoLogin tela = new VisaoLogin();
        tela.setVisible(true);
    }//GEN-LAST:event_conMenuLogoutActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
        ServicoLogin servico = new ServicoLogin();
        try {
            login = servico.buscarPorCodigo(login.getCodigo());
        } catch (ExcecaoDAO|ExcecaoServico ex) {}
        
        if (Validacao.Alocado(login))
            PreencheInformacoes();
    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadMenuAmbiente;
    private javax.swing.JMenuItem cadMenuAula;
    private javax.swing.JMenuItem cadMenuCurso;
    private javax.swing.JMenuItem cadMenuDisciplina;
    private javax.swing.JMenuItem cadMenuLogin;
    private javax.swing.JMenuItem cadMenuPeriodo;
    private javax.swing.JMenuItem cadMenuPessoa;
    private javax.swing.JMenuItem cadMenuTurma;
    private javax.swing.JMenuItem conMenuLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelIdLogado;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JMenuItem pesMenuAmbiente;
    private javax.swing.JMenuItem pesMenuAula;
    private javax.swing.JMenuItem pesMenuCurso;
    private javax.swing.JMenuItem pesMenuDisciplina;
    private javax.swing.JMenuItem pesMenuLogin;
    private javax.swing.JMenuItem pesMenuPeriodo;
    private javax.swing.JMenuItem pesMenuPessoa;
    private javax.swing.JMenuItem pesMenuTurma;
    // End of variables declaration//GEN-END:variables
}