/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.model;

/**
 *
 * @author MiguelAspire5
 */
public class Login {
    
    String idcliente, senhacliente, emailcliente, telefonecliente, logincliente, enderecocliente, nomecliente;

    public Login(String senhacliente, String logincliente) {
        this.senhacliente = senhacliente;
        this.logincliente = logincliente;
    }
    
    public void cadastrar(String idcliente, String senhacliente, String emailcliente, String telefonecliente, String logincliente, String enderecocliente, String nomecliente ) {
        this.idcliente = idcliente;
        this.senhacliente = senhacliente;
        this.emailcliente = emailcliente;
        this.telefonecliente = telefonecliente;
        this.logincliente = logincliente;
        this.enderecocliente = enderecocliente;
        this.nomecliente = nomecliente;
    }

    public String getIdcliente(){
        return idcliente;
    }
    
    public void setIdcliente(String idcliente){
        this.idcliente = idcliente;
    }
    
    public String getSenhacliente() {
        return senhacliente;
    }

    public void setSenhacliente(String senhacliente) {
        this.senhacliente = senhacliente;
    }

    public String getEmailcliente() {
        return emailcliente;
    }

    public void setEmailcliente(String emailcliente) {
        this.emailcliente = emailcliente;
    }

    public String getTelefonecliente() {
        return telefonecliente;
    }

    public void setTelefonecliente(String telefonecliente) {
        this.telefonecliente = telefonecliente;
    }

    public String getLogincliente() {
        return logincliente;
    }

    public void setLogincliente(String logincliente) {
        this.logincliente = logincliente;
    }

    public String getEnderecocliente() {
        return enderecocliente;
    }

    public void setEnderecocliente(String enderecocliente) {
        this.enderecocliente = enderecocliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    
}
