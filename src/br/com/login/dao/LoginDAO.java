/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import br.com.login.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JTextField;
import org.w3c.dom.Text;

        String clienteos;
        String datos;
        String defeitoos;
        String equipos;
        String idors;
        String numos;
        String servicoos;
        String statos;
        String tecnicoos;
/**
 *
 * @author MiguelAspire5
 */
public class LoginDAO {
    
    public void cadastrarUsuario(String id, String nome,String email,String telefone, String endereco, String senha, String login)throws SQLException {
          Connection conexao= new Conexao().getConnection();
          String sql ="INSERT INTO Cliente (idcliente, nomecliente, emailcliente, telefonecliente, enderecocliente, senhacliente, logincliente) VALUES ('"+id+"','"+nome+"','"+email+"','"+telefone+"','"+endereco+"','"+senha+"','"+login+"',)";
          PreparedStatement statement = conexao.prepareStatement(sql);
          statement.execute();
          conexao.close();
     }

    public void loginUsuario(String loginusuario, String senhausuario) throws SQLException{
          Connection conexao= new Conexao().getConnection();
          String sql ="SELECT senhausuario,loginusuario FROM cliente WHERE senhausuario = ('"+senhausuario+"' AND loginusuario ='"+loginusuario+"')";
          PreparedStatement statement = conexao.prepareStatement(sql);
          ResultSet rs = statement.executeQuery();
          
          
          if(rs.next()){
              System.out.println("Possui");
          }
          else{
              System.out.println("Não Possui");
          }
          
          conexao.close();
    }
    
    public void ordemServico(Integer idos, Integer numeroos, Date dataos, Text status, Text equipamento, Text defeito, Text servico, Text tecnico, String cliente) throws SQLException{
        Connection conexao= new Conexao().getConnection();
       
        String sql = "INSERT INTO ordem (idos, numeroos, dataos, status, equipamento, defeito, servico, tecnico, cliente) VALUES ('"+idors+"','"+numos+"','"+datos+"','"+statos+"','"+equipos+"','"+defeitoos+"','"+servicoos+"','"+tecnicoos+"','"+clienteos"',)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        conexao.close();
    }
    
    public void editarOrdem(Integer idos, Integer numeroos, Date dataos, Text status, Text equipamento, Text defeito, Text servico, Text tecnico, String cliente) throws SQLException{
        Connection conexao= new Conexao().getConnection();
        String sql = "ALTER TABLE ordem (idos, numeroos, dataos, status, equipamento, defeito, servico, tecnico, cliente) VALUES ('"+idors+"','"+numos+"','"+datos+"','"+statos+"','"+equipos+"','"+defeitoos+"','"+servicoos+"','"+tecnicoos+"','"+clienteos"',)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        conexao.close();
    }
    
    

    public void login(JTextField usuariolog) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void cadastro(String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void login(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
