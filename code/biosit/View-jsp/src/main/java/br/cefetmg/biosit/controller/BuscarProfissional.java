
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
import java.util.List;

/**
 *
 * @author Pedro Gabriel
 */
public class BuscarProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "/gerenciarProfissional.jsp";
        List<Profissional> profissionais = new ArrayList<>();
        try {
            Profissional pro = null;
            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String registro = request.getParameter("registro");
            String cargo = request.getParameter("cargo");
            String especialidade = request.getParameter("especialidade");
            
            
            if(cargo.equals("medico")) {
                pro = new Medico();
                pro.setRegistro(request.getParameter("registro"));
            } else if(cargo.equals("secretario")) {
                pro = new Profissional("secretario");
            } else if (cargo.equals("gerente")) {
                pro = new Profissional("gerente");
            } else {
                pro = new Profissional(cargo);
            }
            
            pro.setCpf(cpf);
            pro.setNome(nome);
            pro.setEspecialidade(especialidade);
            pro.setRegistro(registro);
            
            ManterProfissional service = new ManterProfissional();
            profissionais = service.pesquisar(pro);
            
            jsp = "/listagemProfissional.jsp";
            request.setAttribute("profissionais", profissionais);
            System.out.println("tam: " + profissionais.size() + " r: " + profissionais);
        } catch (Exception e) {
            jsp = "index.jsp";
        }
        
        return jsp;
    }
}
