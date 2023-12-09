/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.DAOMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import br.cefetmg.biosit.dto.Internacao;


/**
 *
 * @author joaop
 */
public class InternacaoDAO {
    
    private String driver = "com.mysql.cj.jdbc.Driver";
  private String url = "jdbc:mysql://localhost:3306/biositdb";
  private String user = "root";
  private String password = "joao34376600";

  private Connection conectar() {
    Connection con = null;
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      return con;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
    
    public ArrayList<Internacao> listarContatos() throws SQLException{
      ArrayList<Internacao> contatos = new ArrayList<>();
      String read = "select * from internacao order by idinter";
      
      try {
      //abrir conexao
      Connection con = conectar();
      //preparar a query create
      PreparedStatement pst = con.prepareStatement(read);
      //substituir os parametros
      ResultSet rs = pst.executeQuery();
      while(rs.next()){
          String idinter = rs.getString(1);
          String nome = rs.getString(2);
          String cpf = rs.getString(3);
          String dtnasc = rs.getString(4);
          String quarto = rs.getString(5);
          String leito = rs.getString(6);
          String dat_ent = rs.getString(7);
          String motivo = rs.getString(8);
          String historico = rs.getString(9);
          
          
          contatos.add(new Internacao(idinter, nome, cpf, dtnasc, quarto, leito, dat_ent, motivo, historico));
      }

      //encerrar conexao
      con.close();
      return contatos;
    } catch (SQLException e) {
        // Log ou relance a exceção para que o servlet a capture
        throw e;
    } catch (Exception e) {
        e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
        throw new SQLException("Falha ao atualizar o contato.", e);
    }
       
  }
    
     public void inserirInternacao(Internacao inserir) throws SQLException {
    String create = "INSERT INTO contatos (nome, cpf, dtnasc, quarto, leito, dat_ent, motivo, historico) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      //abrir conexao
      Connection con = conectar();
      //preparar a query create
      PreparedStatement pst = con.prepareStatement(create);
      //substituir os parametros
     pst.setString(1, inserir.getNome());
     pst.setString(2, inserir.getCpf());
     pst.setString(3, inserir.getDtnasc());
     pst.setString(4, inserir.getQuarto());
     pst.setString(5, inserir.getLeito());
     pst.setString(6, inserir.getDat_ent());
     pst.setString(7, inserir.getMotivo());
     pst.setString(8, inserir.getHistorico());
      //ExecutarQuery
      pst.executeUpdate();
      //encerrar conexao
      con.close();
    } catch (SQLException e) {
        // Log ou relance a exceção para que o servlet a capture
        throw e;
    } catch (Exception e) {
        e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
        throw new SQLException("Falha ao atualizar o contato.", e);
    }

  }
    
   
    
}
