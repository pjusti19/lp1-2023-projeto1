
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
public class AtualizarProfissional {
    public static String execute(HttpServletRequest request) {
        String jsp = "/profissional.jsp";
        
        try {
            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String dataNasc = request.getParameter("nascimento");
            String endereco = request.getParameter("endereco");
            String rg = request.getParameter("rg");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String registro = request.getParameter("registro");
            String cargo = request.getParameter("cargo");
            String admissao = request.getParameter("dataAdmissao");
            double salario = Double.parseDouble(request.getParameter("salario"));
            String especialidade = request.getParameter("especializacao");
            String instituicao = request.getParameter("instituicao");
            String anoGrad = request.getParameter("ano-grad");
            
            Profissional pro = new Profissional(cargo);
            pro.setAdmissao(admissao); pro.setAnoGrad(anoGrad); pro.setCpf(cpf);
            pro.setEmail(email); pro.setEspecialidade(especialidade); pro.setInstituicao(instituicao);
            pro.setNascimento(dataNasc); pro.setNome(nome); pro.setRG(rg); 
            pro.setRegistro(registro); pro.setSalario(salario); pro.setTel(tel);
            
            ManterProfissional service = new ManterProfissional();
            service.atualizar(pro);
            request.setAttribute("profissional", pro);
            
            
            System.out.println(pro.getTel() + "    /?    " + pro.getInstituicao());
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        return jsp;
    }
}
