package jeffersonmca.com.github.gerenciadorambiente.visao.login;

import java.awt.Cursor;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Login;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoLogin;
import java.util.List;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;
import jeffersonmca.com.github.gerenciadorambiente.renderizadores.StrippedTableCellHandler;

public class LoginListagem extends javax.swing.JFrame {

    private Login login;
    private ServicoLogin service;
    private List<Login> dados;
    private LoginTableModel tabModel;
    
    public LoginListagem(Login login) {
        
        initComponents();
        
        this.login = login;
        this.service = new ServicoLogin();
        
        // Atualiza os dados da grid
        atualizaDados();
    }

    // Atualiza os dados da grid
    private void atualizaDados() {
        
        try {
            
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            try {
                dados = service.buscarTodos();
            } catch (ExcecaoDAO e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Houve um erro ao buscar todos os registros.", "Erro", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            tabModel = new LoginTableModel(dados);
            tableLogins.setModel(tabModel);
            
            // Melhorando o aspecto da grid
            tableLogins.setDefaultRenderer(Object.class, new StrippedTableCellHandler());
        
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbtnIncluir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbtnEditar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbtnRemover = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbtnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbtnFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLogins = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Login");

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        jbtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/incluir.png"))); // NOI18N
        jbtnIncluir.setText("Incluir");
        jbtnIncluir.setToolTipText("Adcionar");
        jbtnIncluir.setFocusable(false);
        jbtnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIncluirActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnIncluir);

        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator4);

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/editar.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setToolTipText("Editar");
        jbtnEditar.setFocusable(false);
        jbtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnEditar);

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator3);

        jbtnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/remover.png"))); // NOI18N
        jbtnRemover.setText("Remover");
        jbtnRemover.setToolTipText("Remover");
        jbtnRemover.setFocusable(false);
        jbtnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnRemover);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator2);

        jbtnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/atualizar.png"))); // NOI18N
        jbtnAtualizar.setText("Atualizar");
        jbtnAtualizar.setToolTipText("Atualizar");
        jbtnAtualizar.setFocusable(false);
        jbtnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnAtualizar);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.add(jSeparator1);

        jbtnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images/cancelar.png"))); // NOI18N
        jbtnFechar.setText("Fechar");
        jbtnFechar.setToolTipText("Fechar");
        jbtnFechar.setFocusable(false);
        jbtnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnFechar);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableLogins.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableLogins);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(564, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed

        // Instancia a tela de inclusao do Login
        LoginInclui tela = new LoginInclui(this, true, service);
        tela.setVisible(true);

        // Apos a inclusao, atualiza a grid
        atualizaDados();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed

        // Verifica se o usuario selecionou alguma linha da grid para a edicao
        if (tableLogins.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Pega a linha que ele selecionou e transforma em um objeto do tipo Login
        Login aux = dados.get(tableLogins.getSelectedRow());

        // Precaucao caso algo de errado
        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!");
            return;
        }

        // Instancia a tela de edicao do Login. passando de parametro
        // o servico e o Login a ser editado
        LoginEdita tela = new LoginEdita(this, true, service, aux);
        tela.setVisible(true);

        // Apos a edicao, atualiza a grid
        atualizaDados();
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoverActionPerformed

        // Verifica se o usuario selecionou alguma linha da grid para a remocao
        if (tableLogins.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Pega a linha que ele selecionou e transforma em um objeto do tipo Login
        Login aux = dados.get(tableLogins.getSelectedRow());
        
        // Nao pode remover o usuario que esta logado no momento
        if (login.equals(aux)) {
            JOptionPane.showMessageDialog(this, "Não é permitido remover o usuário logado no momento!");
            return;
        }

        // Precaucao caso algo de errado
        if (aux == null) {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!");
            return;
        }

        // Pergunta o usuario se ele realmente quer deletar aquele Login
        if (JOptionPane.showConfirmDialog(this,
            "Confirma a remoção do login: " + aux.getId() + "?",
            "Remoção",
            JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION ) {

            try {
                // Caso a escolha fora sim entao o Login sera removido
                service.remover(aux.getCodigo());
                // Atualiza a grid
                atualizaDados();
                JOptionPane.showMessageDialog(this, "Registro removido com sucesso.");
            } catch (ExcecaoDAO|ExcecaoServico e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtnRemoverActionPerformed

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        // Atualiza os dados da grid
        atualizaDados();
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAtualizar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnFechar;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JButton jbtnRemover;
    private javax.swing.JTable tableLogins;
    // End of variables declaration//GEN-END:variables
}