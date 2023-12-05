package br.cefetmg.biosit.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.service.IManterMedicamento;
import br.cefetmg.biosit.service.implement.ManterMedicamento;
import br.cefetmg.biosit.dto.exception.*;

@WebServlet(urlPatterns = {"/CadastrarMedicamento"})
public class CadastrarMedicamento extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String dataValidade = request.getParameter("data");           
            int lote = Integer.parseInt(request.getParameter("lote"));
            int quantidadeRestante = Integer.parseInt(request.getParameter("quantidade"));
            
            Medicamento medicamento = new Medicamento(nome, dataValidade, quantidadeRestante, fornecedora, lote);
            IManterMedicamento manterMedicamento = new ManterMedicamento();
            manterMedicamento.cadastrar(medicamento);
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return jsp;
    }

}