
package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.idao.IMedicamentoDAO;
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
public class MedicamentoDAO implements IMedicamentoDAO {

    private final String url;
    private final String password;
    private final String user;
    
    public MedicamentoDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }
    
    @Override
    public boolean inserir(Medicamento medicamento) throws CadastroException {
        String query = "INSERT INTO medicamentos (nome, data, quantidade, fornecedora, lote) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, medicamento.getNome());
            preparedStatement.setDate(2, new java.sql.Date(medicamento.getData().getTime()));
            preparedStatement.setInt(3, medicamento.getQuantRestante());
            preparedStatement.setString(4, medicamento.getFornecedora());
            preparedStatement.setInt(5, medicamento.getLote());
            
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean atualizar(Medicamento medicamento) throws CadastroException {
        String query = "UPDATE medicamento SET nome = ?, data = ?, fornecedora = ?, setor = ?, WHERE quantidade = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, medicamento.getNome());
            preparedStatement.setDate(2, new java.sql.Date(medicamento.getData().getTime()));
            preparedStatement.setInt(3, medicamento.getQuantRestante());
            preparedStatement.setString(4, medicamento.getFornecedora());
            preparedStatement.setInt(5, medicamento.getLote());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Medicamento medicamento) throws Exception {
        String query = "DELETE FROM medicamento WHERE quantidade = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, medicamento.getQuantRestante());

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum medicamento encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o medicamento: " + e.getMessage());
        }
        return true;
    }
    
    @Override
    public List<Medicamento> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM equipamento WHERE nome = ?";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medicamento medicamento = new Medicamento(resultSet.getString("nome"),resultSet.getString("data"),resultSet.getInt("quantidade"),resultSet.getString("fornecedora"),resultSet.getInt("lote"));
                medicamentos.add(medicamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return medicamentos;
    }
    public List<Medicamento> pesquisarQuantidade(String cpf) throws Exception {
        String query = "SELECT * FROM medicamento WHERE quantidade = ?";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medicamento medicamento = new Medicamento(resultSet.getString("nome"),resultSet.getString("data"),resultSet.getInt("quantidade"),resultSet.getString("fornecedora"),resultSet.getInt("lote"));
                medicamentos.add(medicamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o medicamento: " + e.getMessage());
        }
        return medicamentos;
    }
    @Override
    public List<Medicamento> pesquisarFornecedora(String endereco) throws Exception {
        String query = "SELECT * FROM equipamento WHERE fornecedora = ?";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, endereco);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medicamento medicamento = new Medicamento(resultSet.getString("nome"),resultSet.getString("data"),resultSet.getInt("quantidade"),resultSet.getString("fornecedora"),resultSet.getInt("lote"));
                medicamentos.add(medicamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o medicamento: " + e.getMessage());
        }
        return medicamentos;
    }
    public List<Medicamento> pesquisarValidade(Date nascimento) throws Exception {
        String query = "SELECT * FROM medicamento WHERE data = ?";
        List<Medicamento> medicamentos = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nascimento.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medicamento medicamento = new Medicamento(resultSet.getString("nome"),resultSet.getString("data"),resultSet.getInt("quantidade"),resultSet.getString("fornecedora"),resultSet.getInt("lote"));
                medicamentos.add(medicamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o medicamento: " + e.getMessage());
        }
        return medicamentos;
    }
    
    @Override
    public List<Medicamento> pesquisarData(Date validade) throws Exception {
        return null;
    }
    
    @Override
    public List<Medicamento> pesquisarQuantidade(int quantidade) throws Exception {
        return null;
    }
    
}
