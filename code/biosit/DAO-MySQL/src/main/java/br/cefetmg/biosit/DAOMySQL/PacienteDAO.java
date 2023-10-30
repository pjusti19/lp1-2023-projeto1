
package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.idao.IPacienteDAO;
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
 * @author Aluno
 */
public class PacienteDAO implements IPacienteDAO {

    private final String url;
    private final String password;
    private final String user;
    
    public PacienteDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }
    
    @Override
    public boolean inserir(Paciente paciente) throws CadastroException, PacienteDuplicadoException {
        String query = "INSERT INTO pacientes (nome, dataNascimento, cpf, endereco) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getNascimento());
            preparedStatement.setString(3, paciente.getCPF());
            preparedStatement.setString(4, paciente.getEndereco());
            
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            if(e.getMessage().substring(0, 9).equals("Duplicate")) {
                throw new PacienteDuplicadoException(paciente.getCPF());
            }
            throw new CadastroException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean atualizar(Paciente paciente) throws CadastroException {
        String query = "UPDATE pacientes SET nome = ?, dataNascimento = ?, endereco = ?, rg = ?, tel = ? WHERE cpf = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getNascimento());
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setString(4, paciente.getRG());
            preparedStatement.setString(5, paciente.getTel());
            preparedStatement.setString(6, paciente.getCPF());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Paciente paciente) throws Exception {
        String query = "DELETE FROM pacientes WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, paciente.getCPF());

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum paciente encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o paciente: " + e.getMessage());
        }
        return true;
    }
    
    @Override
    public List<Paciente> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM pacientes";
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),resultSet.getString("dataNascimento"),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return pacientes;
    }
    
    @Override
    public List<Paciente> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM pacientes WHERE nome = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),resultSet.getString("dataNascimento"),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return pacientes;
    }
    @Override
    public Paciente pesquisarCPF(String cpf) throws Exception {
        String query = "SELECT * FROM pacientes WHERE cpf = ?";
        Paciente paciente = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String dataNascimento = resultSet.getString("dataNascimento");
                paciente = new Paciente(nome, dataNascimento, cpf, endereco);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return paciente;
    }
    @Override
    public List<Paciente> pesquisarEndereco(String endereco) throws Exception {
        String query = "SELECT * FROM pacientes WHERE endereco = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, endereco);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),resultSet.getString("dataNascimento"),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return pacientes;
    }
    @Override
    public List<Paciente> pesquisarNascimento(String nascimento) throws Exception {
        String query = "SELECT * FROM pacientes WHERE dataNascimento = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nascimento);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),resultSet.getString("dataNascimento"),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o paciente: " + e.getMessage());
        }
        return pacientes;
    }
    
    public static void main(String[] args) {
        try {
            String cpf = "12378945600";
            PacienteDAO q = new PacienteDAO();
            Paciente p = q.pesquisarCPF(cpf);
            System.out.println(p);
        } catch(Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    
}
