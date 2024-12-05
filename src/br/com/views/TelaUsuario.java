/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.views;

/**
 *
 * @author MiguelAspire5
 */
import java.sql.*;
import br.com.login.dal.Conexao;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = Conexao.conector();
    }

    private void consultar(){
        String sql = "SELECT * FROM usuario WHERE idusuario = ?";
        try {
            pst = conexao.prepareStatement(sql);
            int idUsuario = Integer.parseInt(txtId.getText());
            pst.setInt(1, idUsuario);
            rs=pst.executeQuery();
            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtTelefone.setText(rs.getString(3));
                txtLogin.setText(rs.getString(4));
                txtSenha.setText(rs.getString(5));
                cbxPerfil.setSelectedItem(rs.getString(6));
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cadastrar() {
    String sql = "INSERT INTO usuario (idusuario, nomeusuario, telefoneusuario, loginusuario, senhausuario, perfil) VALUES(?,?,?,?,?,?)";
    PreparedStatement pst = null; // Inicializa a variável pst
    try {
        // Tente converter o ID para inteiro
        int idUsuario = Integer.parseInt(txtId.getText().trim()); // Converte o texto do JTextField para um inteiro
        
        // Prepare a instrução SQL
        pst = conexao.prepareStatement(sql);
        
        // Use setInt para o ID
        pst.setInt(1, idUsuario);
        
        // Definindo os outros parâmetros como strings
        pst.setString(2, txtNome.getText());
        
        // Validação e conversão do telefone
        String telefoneStr = txtTelefone.getText().trim();
        if (!telefoneStr.matches("\\d+")) { // Verifica se o telefone contém apenas dígitos
            throw new NumberFormatException("O telefone deve conter apenas números.");
        }
        BigDecimal telefoneUsuario = new BigDecimal(telefoneStr);
        pst.setBigDecimal(3, telefoneUsuario);
        pst.setString(4, txtLogin.getText());
        pst.setString(5, txtSenha.getText());
        pst.setString(6, cbxPerfil.getSelectedItem().toString());
        
        /*código para obrigar a preencher os campos
        if ((txtId.getText().isEmpty()) || (txtNome.getText().isEmpty())||(txttelefone.getGText().isEmpty())|| {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
        }        
        
        */
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
    } catch (NumberFormatException e) {
        // Captura exceção se a conversão do ID ou telefone falhar
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    } catch (SQLException e) {
        // Captura exceção se houver um erro de SQL
        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
    } catch (Exception e) {
        // Captura qualquer outra exceção
        JOptionPane.showMessageDialog(null, e);
    } finally {
        // Fecha o PreparedStatement se não for nulo
        try {
            if (pst != null) pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    
    private void  alterar(){
        String sql="UPDATE usuario SET nomeusuario=?, telefoneusuario=?, loginusuario=?, senhausuario=?, perfil=? WHERE idusuario=?";
        try {
            
            pst=conexao.prepareStatement(sql);
            
            int idUsuario = Integer.parseInt(txtId.getText().trim());
            
            BigDecimal telefone = new BigDecimal(txtTelefone.getText());
            
            pst.setString(1, txtNome.getText());
            pst.setBigDecimal(2, telefone);
            pst.setString(3, txtLogin.getText());
            pst.setString(4, txtSenha.getText());
            pst.setString(5,cbxPerfil.getSelectedItem().toString());
            
            pst.setInt(6, idUsuario);
            
            pst.executeUpdate();
        } catch(NumberFormatException e){
            System.out.println("Erro do Id");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        cbxPerfil = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JToggleButton();
        login = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JToggleButton();
        senha = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JToggleButton();
        perfil = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JToggleButton();
        txtId = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        telefone = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(690, 433));

        cbxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "usuario" }));
        cbxPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPerfilItemStateChanged(evt);
            }
        });
        cbxPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPerfilActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        login.setText("Login:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        senha.setText("Senha:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        perfil.setText("Perfil:");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        usuario.setText("USUÁRIO");

        id.setText("ID:");

        nome.setText("Nome:");

        telefone.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nome)
                                .addComponent(id)
                                .addComponent(telefone)
                                .addComponent(login))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(senha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(perfil)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtNome))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(usuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perfil)
                    .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefone))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void cbxPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPerfilActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbxPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPerfilItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPerfilItemStateChanged

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
    alterar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterar;
    private javax.swing.JToggleButton btnCadastrar;
    private javax.swing.JToggleButton btnConsultar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JComboBox<String> cbxPerfil;
    private javax.swing.JLabel id;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel perfil;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel telefone;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}