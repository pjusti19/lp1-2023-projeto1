
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.service.implement.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class EditarRegistroProntuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        String idReg = request.getParameter("idReg");
        Paciente paciente;
        try {
            IManterProntuario manterProntuario = new ManterProntuario();
        } catch (Exception e) {
            
        }
        
        return jsp;
    }
}
