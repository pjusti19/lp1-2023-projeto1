
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
 * @author Pedro Gabriel
 */
public class AtualizarPaciente {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        try {
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String dataNasc = request.getParameter("data-nascimento");
            String endereco = request.getParameter("endereco");
            String rg = request.getParameter("rg");
            String tel = request.getParameter("tel");
            Paciente paciente = new Paciente(nome, dataNasc, cpf, endereco);
            paciente.setRG(rg);
            paciente.setTel(tel);
            
            ManterPaciente manterPaciente = new ManterPaciente();
            manterPaciente.atualizar(paciente);
            
            request.setAttribute("paciente_exib", paciente);
            
        } catch (Exception e) {
            
        }
        return jsp;
    }
}
