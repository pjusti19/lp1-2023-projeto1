
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.service.implement.ManterPaciente;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ExcluirPaciente {
    public static String execute(HttpServletRequest request) {
        String jsp = "/paciente.jsp";
        
        try {
            
            String cpf = request.getParameter("cpf");
            ManterPaciente manterPaciente = new ManterPaciente();
            manterPaciente.excluir(cpf);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaPaciente");
            request.setAttribute("error", e.getMessage());
            jsp = "/paciente.jsp";
        }
        
        return jsp;
    }
}
