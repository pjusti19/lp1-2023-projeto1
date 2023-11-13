package br.cefetmg.biosit.DAOMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import br.cefetmg.biosit.dto.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private final String url;
    private final String password;
    private final String user;
    
    public UsuarioDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }        
    
    public ResultSet autenticacaoUsuario(Usuario usuario) throws Exception {
        String query = "SELECT * FROM usuario where nomeUsuario = ? and senhaUsuario = ? ";
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNomeUsuario());
        preparedStatement.setString(2, usuario.getSenhaUsuario());
        
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
                
            }
        
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        }
    }
}
