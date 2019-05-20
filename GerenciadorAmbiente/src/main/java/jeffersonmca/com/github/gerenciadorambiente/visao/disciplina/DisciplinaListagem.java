package jeffersonmca.com.github.gerenciadorambiente.visao.disciplina;

import java.awt.Cursor;
import jeffersonmca.com.github.gerenciadorambiente.modelo.Disciplina;
import jeffersonmca.com.github.gerenciadorambiente.servico.ServicoDisciplina;
import java.util.List;
import javax.swing.JOptionPane;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoDAO;
import jeffersonmca.com.github.gerenciadorambiente.excecoes.ExcecaoServico;

public class DisciplinaListagem extends javax.swing.JFrame {

    private ServicoDisciplina service;
    private List<Disciplina> dados;
    private DisciplinaTableModel tabModel;
    
    public DisciplinaListagem() {
        
        initComponents();
        service = new ServicoDisciplina();
        atualizaDados();
    }

    private void atualizaDados(){
        
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

            tabModel = new DisciplinaTableModel(dados);
            jTable1.setModel(tabModel);
        
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbtnIncluir = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnRemover = new javax.swing.JButton();
        jbtnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbtnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de clientes");

        jToolBar1.setRollover(true);

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
        jToolBar1.add(jSeparator1);

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(418, 378));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnFecharActionPerformed

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        atualizaDados();
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoverActionPerformed
        
        if (jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Disciplina aux = dados.get(jTable1.getSelectedRow());        
        
        if (aux == null){            
          JOptionPane.showMessageDialog(this, "Registro não encontrado.");  
          return;   
        } 
        
        if (JOptionPane.showConfirmDialog(this, 
                "Confirma a remoção da disciplina: "
                        + aux.getNome()+"?",
                "Remoção",                
                  JOptionPane.YES_NO_OPTION
                      )
               == JOptionPane.YES_OPTION )
              {

            try {              
                service.remover(aux.getCodigo());
                atualizaDados();
                JOptionPane.showMessageDialog(this, "Registro removido com sucesso.");
                return;
                
            } catch (ExcecaoDAO|ExcecaoServico e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }              
        }
    }//GEN-LAST:event_jbtnRemoverActionPerformed

    private void jbtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIncluirActionPerformed
        
        DisciplinaIncluir tela = new DisciplinaIncluir(this, true, service);
        tela.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jbtnIncluirActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed

        if (jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro.", "Dica", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Disciplina aux = dados.get(jTable1.getSelectedRow());        
        
        if (aux == null){            
          JOptionPane.showMessageDialog(this, "Registro não encontrado.");  
          return;   
        } 

        DisciplinaEdita tela = new DisciplinaEdita(this, true, service, aux);
        
        tela.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jbtnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAtualizar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnFechar;
    private javax.swing.JButton jbtnIncluir;
    private javax.swing.JButton jbtnRemover;
    // End of variables declaration//GEN-END:variables
}