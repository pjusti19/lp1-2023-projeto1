
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
public class GerarAcesso {
    public static String execute(HttpServletRequest request) {
        String jsp = "/profissional.jsp";
        String cpf = request.getParameter("cpf");
        try {
            String user = request.getParameter("user");
            String senha = request.getParameter("senha");
            String cargo = request.getParameter("cargo");
            
            ManterProfissional service = new ManterProfissional();
            service.gerarAcesso(cpf, cargo, user, senha);
            
            Profissional pro = service.pesquisar(cpf);
            request.setAttribute("profissional", pro);
            
            System.out.println("acesso: " + cpf + "    " + cargo + "   " + user + "    " + senha);
        } catch(Exception e) {
        }
        try {Profissional pro = (new ManterProfissional()).pesquisar(cpf);
        request.setAttribute("profissional", pro);} catch (Exception e) {}
        return jsp;
    }
}
