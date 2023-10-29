import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


@WebServlet("/consulta")
public class BuscarConsulta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //obtém a data atual
        LocalDate currentDate = LocalDate.now();
        String data = String.valueOf(currentDate.getDayOfMonth());
        
        //cria uma lista para cada dado desejado
        List<String> nomes = new ArrayList<>();
        List<String> horarios = new ArrayList<>();

        try (var connection = ConexaoDB.getConnection()) {
            String sql = "SELECT nome, horario FROM funcionários WHERE data = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, data);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                nomes.add(resultSet.getString("nome"));
                horarios.add(resultSet.getString("horario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("nomes", nomes);
        request.setAttribute("horarios", horarios);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}