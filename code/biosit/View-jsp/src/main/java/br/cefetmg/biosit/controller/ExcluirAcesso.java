
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
public class ExcluirAcesso {
    public static String execute(HttpServletRequest request) {
        String jsp = "/profissional.jsp";
        String cpf = request.getParameter("cpf");
        
        try {
            ManterProfissional service = new ManterProfissional();
            service.excluirAcesso(cpf);
        } catch(Exception e) {
            System.out.println("errorrr: asdfas " + e.getMessage());
        }
        
        try {Profissional pro = (new ManterProfissional()).pesquisar(cpf);
        request.setAttribute("profissional", pro);} catch (Exception e) {}
        
        return jsp;
    }
}
