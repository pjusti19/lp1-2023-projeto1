
package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.idao.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class ProfissionalDAO implements IProfissionalDAO {
    private final String url;
    private final String password;
    private final String user;
    
    public ProfissionalDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }
    
    @Override
    public boolean inserir(Profissional pro) throws Exception {
        String query = "INSERT INTO profissional (nome, cpf, email, nascimento, registro, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, pro.getNome());
            preparedStatement.setString(2, pro.getCpf());
            preparedStatement.setString(3, pro.getEmail());
            preparedStatement.setString(4, pro.getNascimento());
            preparedStatement.setString(5, pro.getRegistro());
            preparedStatement.setString(6, pro.getCargo());
            
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }
    
    @Override
    public boolean atualizar(Profissional pro) throws Exception {
        return false;
    }
    
    @Override
    public boolean excluir(String cpf) throws Exception {
        return false;
    }
    
    @Override
    public List<Profissional> pesquisar(Profissional pro) throws Exception {
        return null;
    }
    
    @Override
    public Profissional pesquisar(String cpf) throws Exception {
        return null;
    }
    
    public static void main(String[] args) {
        try {
            Profissional pro = new Profissional("medico");
            pro.setNascimento("05/07/1999");
            pro.setNome("Nome teste");
            pro.setCpf("12345678900");
            pro.setEmail("email@email.com");
            pro.setRegistro("reg");
            
            ProfissionalDAO dao = new ProfissionalDAO();
            dao.inserir(pro);
            
            System.out.println("deu certo: " + pro);
        } catch (Exception e) {
            System.out.println("errro:  " + e.getMessage());
        }
    }
}
