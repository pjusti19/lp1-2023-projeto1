
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
    public List<Profissional> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM profissional";
        List<Profissional> profissionais = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profissional pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
                profissionais.add(pro);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return profissionais;
    }
    
    @Override
    public List<Profissional> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM profissional WHERE nome = ?";
        List<Profissional> profissionais = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Profissional pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
                profissionais.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return profissionais;
    }

    @Override
    public Profissional pesquisarCPF(String cpf) throws Exception {
        String query = "SELECT * FROM profissional WHERE cpf = ?";
        Profissional pro = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return pro;
    }

    @Override
    public List<Profissional> pesquisarRegistro(String registro) throws Exception {
        String query = "SELECT * FROM profissional WHERE registro = ?";
        List<Profissional> profissionais = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, registro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Profissional pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
                profissionais.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return profissionais;
    }

    @Override
    public List<Profissional> pesquisarCargo(String cargo) throws Exception {
        String query = "SELECT * FROM profissional WHERE cargo = ?";
        List<Profissional> profissionais = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cargo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Profissional pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
                profissionais.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return profissionais;
    }

    @Override
    public List<Profissional> pesquisarEspecialidade(String especialidade) throws Exception {
        String query = "SELECT * FROM profissional WHERE especialidade = ?";
        List<Profissional> profissionais = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, especialidade);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Profissional pro = new Profissional(resultSet.getString("cargo"));
                pro.setCpf(resultSet.getString("cpf"));
                pro.setEmail(resultSet.getString("email"));
                pro.setEspecialidade(resultSet.getString("especialidade"));
                pro.setId(resultSet.getString("id"));
                pro.setNascimento(resultSet.getString("nascimento"));
                pro.setNome(resultSet.getString("nome"));
                profissionais.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return profissionais;
    }
    
    // Teste
    public static void main(String[] args) {
        try {
            ProfissionalDAO dao = new ProfissionalDAO();
//            List<Profissional> pros = dao.pesquisarTodos();
//            for(Profissional pro : pros) {
//                System.out.println(pro.getCpf() + "    " + pro.getNome());
//            }
            List<Profissional> pros = dao.pesquisarCargo("medico");
            for(Profissional pro : pros) {
                System.out.println(pro.getCpf() + "    " + pro.getNome());
            }
        } catch (Exception e) {
            System.out.println("errro:  " + e.getMessage());
        }
    }
}
