
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
public class ExibirProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "/profissional.jsp";
        try {
            String cpf = request.getParameter("cpfExibir");

            ManterProfissional service = new ManterProfissional();
            Profissional pro = service.pesquisar(cpf);
            
            request.setAttribute("profissional", pro);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }
        return jsp;
    }
}
