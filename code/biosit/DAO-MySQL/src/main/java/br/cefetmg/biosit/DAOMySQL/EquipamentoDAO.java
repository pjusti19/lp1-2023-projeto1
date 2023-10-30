package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.idao.IEquipamentoDAO;
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
public class EquipamentoDAO implements IEquipamentoDAO {

    private final String url;
    private final String password;
    private final String user;

    public EquipamentoDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }

    @Override
    public boolean inserir(Equipamento equipamento) throws CadastroException {
        String query = "INSERT INTO equipamentos (nome, data, quantidade, fornecedora, setor) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, equipamento.getNome());
            preparedStatement.setDate(2, new java.sql.Date(equipamento.getData().getTime()));
            preparedStatement.setInt(3, equipamento.getQuant());
            preparedStatement.setString(4, equipamento.getFornecedora());
            preparedStatement.setString(5, equipamento.getSetor());

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
    public boolean atualizar(Equipamento equipamento) throws CadastroException {
        String query = "UPDATE equipamento SET nome = ?, data = ?, fornecedora = ?, setor = ?, WHERE quantidade = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, equipamento.getNome());
            preparedStatement.setDate(2, new java.sql.Date(equipamento.getData().getTime()));
            preparedStatement.setInt(3,    equipamento.getQuant());
            preparedStatement.setString(4, equipamento.getFornecedora());
            preparedStatement.setString(5, equipamento.getSetor());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Equipamento equipamento) throws Exception {
        String query = "DELETE FROM equipamento WHERE quantidade = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, equipamento.getQuant());

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum equipamento encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return true;
    }

    @Override
    public List<Equipamento> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM equipamento WHERE nome = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), new Date(resultSet.getString("data")), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    public List<Equipamento> pesquisarQuantidade(String cpf) throws Exception {
        String query = "SELECT * FROM equipamento WHERE quantidade = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), new Date(resultSet.getString("data")), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    @Override
    public List<Equipamento> pesquisarFornecedora(String endereco) throws Exception {
        String query = "SELECT * FROM equipamento WHERE fornecedora = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, endereco);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), new Date(resultSet.getString("data")), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    @Override
    public List<Equipamento> pesquisarData(Date nascimento) throws Exception {
        String query = "SELECT * FROM equipamento WHERE data = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nascimento.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), new Date(resultSet.getString("data")), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }


}
