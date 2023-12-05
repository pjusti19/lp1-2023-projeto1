package br.cefetmg.biosit.controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Consulta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
/**
 *
 * @author David Eller
 */
@WebServlet("/ExibirNotificacao")
public class ExibirNotificacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        
        List<Consulta> consultas = (List<Consulta>) session.getAttribute("consultas");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (consultas != null && !consultas.isEmpty()) {
        for (Consulta consulta : consultas) {
            out.println("<li>Nome: " + consulta.getNomePaciente() + ", Data: " + consulta.getData() + "</li>");
        }
        }
    }
}
