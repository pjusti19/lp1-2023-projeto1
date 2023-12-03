package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.service.IManterMedicamento;
import br.cefetmg.biosit.service.implement.ManterMedicamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;


public class ExibirMedicamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "medicamento.jsp";
        try {
            String nome = request.getParameter("nome"); 
            String fornecedora = request.getParameter("fornecedora");
            String validade = request.getParameter("validade");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            int lote = Integer.parseInt(request.getParameter("lote"));     
            
            
            Medicamento medicamento = new Medicamento(nome, validade, quantidade, fornecedora, lote);


            ManterMedicamento manterMedicamento = new ManterMedicamento();
            manterMedicamento.pesquisar(medicamento);            
            request.setAttribute("medicamento_exib", medicamento);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaMedicamento");
            jsp = "/medicamento.jsp";
        }
        return jsp;
    }
}