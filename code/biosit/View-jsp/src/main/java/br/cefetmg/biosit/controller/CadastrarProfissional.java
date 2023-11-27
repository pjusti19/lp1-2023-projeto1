
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


/**
 *
 * @author Pedro Gabriel
 */
public class CadastrarProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "/gerenciarProfissional.jsp";
        
        try {
            Profissional pro = null;
            
            String nome = request.getParameter("nome");
            String nasc = request.getParameter("nascimento");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String registro = request.getParameter("registro");
            String cargo = request.getParameter("cargo");
            
            if(cargo.equals("medico")) {
                pro = new Medico();
                pro.setRegistro(request.getParameter("registro"));
            } if(cargo.equals("secretario")) {
                pro = new Profissional("secretario");
            } if (cargo.equals("gerente")) {
                pro = new Profissional("gerente");
            } else {
                pro = new Profissional(null);
            }
            
            pro.setCpf(cpf);
            pro.setEmail(email);
            pro.setNascimento(nasc);
            pro.setNome(nome);
            
            ManterProfissional service = new ManterProfissional();
            service.cadastrar(pro);
            
            jsp = "/gerenciarProfissional.jsp";
            System.out.println("cadastrou com sucesso");
        } catch(Exception e) {
            System.out.println("erro: " + e.getMessage());
            jsp = "/index.jsp";
        }
        
        return jsp;
    }
}
