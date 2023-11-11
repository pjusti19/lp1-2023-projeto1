
package br.cefetmg.biosit.DAOMySQL;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.idao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public class ProntuarioDAO implements IProntuarioDAO {
    
    private final String url;
    private final String password;
    private final String user;
    
    public ProntuarioDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        user = "root";
        password = "";
    }
    
    
    @Override
    public boolean inserir(RegistroProntuario registro) throws Exception {
        String query = "INSERT INTO prontuario (cpf, titulo, dataReg, descricao) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, registro.getCPF());
            preparedStatement.setString(2, registro.getTitulo());
            preparedStatement.setString(3, registro.getData());
            preparedStatement.setString(4, registro.getDescricao());
            
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }
    @Override
    public boolean atualizar(RegistroProntuario registro) throws Exception {
        return false;
    }
    @Override
    public boolean deletar(String cpf) throws Exception {
        return false;
    }
    @Override
    public Prontuario pesquisar(String cpf) throws Exception {
        String query = "SELECT * FROM prontuario WHERE cpf = ?";
        Prontuario pron = new Prontuario();
        pron.setCpf(cpf);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String data = resultSet.getString("dataReg");
                String descricao = resultSet.getString("descricao");
                int id = resultSet.getInt("id");
                RegistroProntuario novoRegistro = new RegistroProntuario(cpf);
                novoRegistro.setTitulo(titulo);
                novoRegistro.setData(data);
                novoRegistro.setDescricao(descricao);
                novoRegistro.setID(id);
                pron.addRegistro(novoRegistro);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        
        return pron;
    }
    
    public static void main(String[] args) {
        try {
            ProntuarioDAO dao = new ProntuarioDAO();
            Prontuario pron = dao.pesquisar("12345678900");
            System.out.println("FUnciona: " + pron.getRegistros());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
