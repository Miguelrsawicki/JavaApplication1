/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import interfaces.TelaCliente;
import interfaces.TelaLogin;
import interfaces.TelaOS;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MiguelAspire5
 */
public class LoginController {
    
    public void cadastrarUsuario(TelaCliente view) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastro(view.getID().getText(), view.getNOME().getText(), view.getENDERECO().getText(), view.getTELEFONE().getText(), view.getEMAIL().getText() );
    }
    
    public void loginUsuario(TelaLogin view) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        LoginDAO login = new LoginDAO();
        login.login(view.getUSUARIOLOG().getText(), view.getSENHALOG().getText());
        
    }
    
    public void cadastrarOrdem( TelaOS view) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        
    }
    
}
