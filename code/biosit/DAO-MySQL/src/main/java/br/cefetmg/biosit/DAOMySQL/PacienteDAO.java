
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
        url = "jdbc:mysql://localhost:3306/mysql";
        password = "";
        user = "root";
    }
    
    @Override
    public boolean inserir(Paciente paciente) throws CadastroException {
        String query = "INSERT INTO pacientes (nome, dataNascimento, cpf, endereco, id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getNascimento().toString());
            preparedStatement.setString(3, paciente.getCPF());
            preparedStatement.setString(4, paciente.getEndereco());
            preparedStatement.setString(5, paciente.getID());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean atualizar(Paciente paciente) throws CadastroException {
        String query = "UPDATE paciente SET nome = ?, data_nascimento = ?, cpf = ?, endereco = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getNascimento().toString());
            preparedStatement.setString(3, paciente.getCPF());
            preparedStatement.setString(4, paciente.getEndereco());
            preparedStatement.setString(5, paciente.getID());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Paciente paciente) throws Exception {
        String query = "DELETE FROM paciente WHERE cpf = ?";

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
    public List<Paciente> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM paciente WHERE nome = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),new Date(resultSet.getString("data_nascimento")),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o paciente: " + e.getMessage());
        }
        return pacientes;
    }
    @Override
    public List<Paciente> pesquisarCPF(String cpf) throws Exception {
        String query = "SELECT * FROM paciente WHERE cpf = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),new Date(resultSet.getString("data_nascimento")),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o paciente: " + e.getMessage());
        }
        return pacientes;
    }
    @Override
    public List<Paciente> pesquisarEndereco(String endereco) throws Exception {
        String query = "SELECT * FROM paciente WHERE endereco = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, endereco);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),new Date(resultSet.getString("data_nascimento")),resultSet.getString("cpf"),resultSet.getString("endereco"));
                pacientes.add(paciente);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o paciente: " + e.getMessage());
        }
        return pacientes;
    }
    @Override
    public List<Paciente> pesquisarNascimento(Date nascimento) throws Exception {
        String query = "SELECT * FROM paciente WHERE dataNascimento = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nascimento.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(resultSet.getString("nome"),new Date(resultSet.getString("data_nascimento")),resultSet.getString("cpf"),resultSet.getString("endereco"));
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
            Paciente p = new Paciente("aaa", new Date(), "143", "adress");
            PacienteDAO q = new PacienteDAO();
            q.inserir(p);
        } catch(Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    
}
