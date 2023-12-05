
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.service.implement.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class ExibirPaciente {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        try {
            String cpf = request.getParameter("cpfExibir");

            ManterPaciente manterPaciente = new ManterPaciente();
            Paciente paciente = manterPaciente.pesquisar(cpf);
            
            request.setAttribute("paciente_exib", paciente);
            
            AgendarConsulta sconsulta = new AgendarConsulta();
            Consulta c = new Consulta(paciente.getNome(), null, null, null, null, null);
            ArrayList<Consulta> consultas = (ArrayList<Consulta>) sconsulta.pesquisar(c);
            request.setAttribute("consultas", consultas);
            
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaPaciente");
            jsp = "/paciente.jsp";
        }
        return jsp;
    }
}
