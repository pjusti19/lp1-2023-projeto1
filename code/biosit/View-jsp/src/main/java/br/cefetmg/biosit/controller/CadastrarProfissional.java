
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


/**
 *
 * @author Pedro Gabriel
 */
public class CadastrarProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "gerenciarProfissional";
        
        try {
            
            String nome = request.getParameter("nome");
        } catch(Exception e) {
            
        }
        
        return jsp;
    }
}
