

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

public class LoginDAL {
    
    public void cadastrarUusuario(String idcliente, String nomecliente, String emailcliente, String telefonecliente, String enderecocliente, String senhacliente, String logincliente) throws SQLException {
        String sql = "INSERT INTO Cliente (idcliente, nomecliente, emailcliente, telefonecliente, enderecocliente, senhacliente, logincliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
             
            statement.setString(1, idcliente);
            statement.setString(2, nomecliente);
            statement.setString(3, emailcliente);
            statement.setString(4, telefonecliente);
            statement.setString(5, enderecocliente);
            statement.setString(6, senhacliente);
            statement.setString(7, logincliente);
            statement.executeUpdate();
        }
    }

    public void loginUusuario( String senhausuario, String loginusuario) throws SQLException {
        String sql = "SELECT senhausuario, loginusuario FROM cliente WHERE senhausuario = ? AND loginusuario = ?";
        
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
             
            statement.setString(1, senhausuario);
            statement.setString(2, loginusuario);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                System.out.println("Possui");
            } else {
                System.out.println("Não Possui");
            }
        }
    }
    
    public void ordemServico(Integer idos, Integer numeroos, Date dataos, String status, String equipamento, String defeito, String servico, String tecnico, String cliente) throws SQLException {
        String sql = "INSERT INTO ordem (idos, numeroos, dataos, status, equipamento, defeito, servico, tecnico, cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
             
            statement.setInt(1, idos);
            statement.setInt(2, numeroos);
            statement.setDate(3, new java.sql.Date(dataos.getTime())); // Convertendo Date para java.sql.Date
            statement.setString(4, status);
            statement.setString(5, equipamento);
            statement.setString(6, defeito);
            statement.setString(7, servico);
            statement.setString(8, tecnico);
            statement.setString(9, cliente);
            statement.executeUpdate();
        }
    }
    
    public void editarOrdem(Integer idos, Integer numeroos, Date dataos, String status, String equipamento, String defeito, String servico, String tecnico, String cliente) throws SQLException {
        String sql = "UPDATE ordem SET numeroos = ?, dataos = ?, status = ?, equipamento = ?, defeito = ?, servico = ?, tecnico = ?, cliente = ? WHERE idos = ?";
        
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
             
            statement.setInt(1, numeroos);
            statement.setDate(2, new java.sql.Date(dataos.getTime())); // Convertendo Date para java.sql.Date
            statement.setString(3, status);
            statement.setString(4, equipamento);
            statement.setString(5, defeito);
            statement.setString(6, servico);
            statement.setString(7, tecnico);
            statement.setString(8, cliente);
            statement.setInt(9, idos);
            statement.executeUpdate();
        }
    }
    
}