package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Financeiro;
import br.cefetmg.biosit.dto.exception.CadastroException;
import br.cefetmg.biosit.idao.IFinanceiroDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David Eller
 */
public class FinanceiroDAO implements IFinanceiroDAO {
    private final String url;
    private final String password;
    private final String user;
    
    public FinanceiroDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }
    
    @Override
    public List<Financeiro> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM financeiro";
        List<Financeiro> valores = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Financeiro financeiro = new Financeiro(resultSet.getDate("dataEmitida"),resultSet.getString("setor"), new Date());
                valores.add(financeiro);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return valores;
    }

    @Override
    public List<Financeiro> pesquisarIntervaloData(Date dataInicial, Date dataFinal) throws Exception {
        String query = "SELECT * FROM financeiro WHERE data BETWEEN ? AND ?";
        List<Financeiro> valores = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDate(1, new java.sql.Date(dataInicial.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(dataFinal.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Financeiro financeiro = new Financeiro(resultSet.getDate("dataEmitida"), resultSet.getString("categoria"), new Date());
                valores.add(financeiro);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return valores;
    }

    @Override
    public List<Financeiro> pesquisarCategoria(String categoria) throws Exception {
        String query = "SELECT * FROM financeiro WHERE categoria = ?";
        List<Financeiro> valores = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, categoria);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Financeiro financeiro = new Financeiro(resultSet.getDate("dataEmitida"),resultSet.getString("categoria"), new Date());
                valores.add(financeiro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return valores;
    }

    
    
}
