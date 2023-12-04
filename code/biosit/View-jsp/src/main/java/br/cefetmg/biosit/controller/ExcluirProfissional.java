
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
import java.text.SimpleDateFormat;

/**
 *
 * @author Pedro Gabriel
 */
public class ExcluirProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "/gerenciarProfissional.jsp";
        String cpf = request.getParameter("cpf");
        
        try {
            ManterProfissional service = new ManterProfissional();
            service.excluir(cpf);
        } catch(Exception e) {
            
        }
        
        return jsp;
    }
}
