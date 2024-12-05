/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MiguelAspire5
 */
public class Conexao {
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
      
        //mudar para Postgresql
        String driver = "org.postgresql.Driver";
     
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user ="postgres";
        String password ="0000";
        try {
            Class.forName(driver);
                    conexao = DriverManager.getConnection(url, user, password);
                    return conexao;
        } catch (Exception e) {
           //caso não conecte no banco de dados use: System.out.println(e)
            return null;
        }
    }    
    
    }
    

   