package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.service.ICadastrarMedicamento;
import br.cefetmg.biosit.service.implement.ManterMedicamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;

public class AtualizarMedicamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            Date dataValidade = new Date(request.getParameter("dataValidade"));           
            int lote = Integer.parseInt("lote");
            int quantidadeRestante = Integer.parseInt("quantidade");
            
            Medicamento medicamento = new Medicamento(nome, dataValidade, quantidadeRestante, fornecedora, lote);
            
            
            ManterMedicamento manterMedicamento = new ManterMedicamento();
            manterMedicamento.atualizar(medicamento);
            
            request.setAttribute("medicamento_exib", medicamento);
            request.setAttribute("sucess", "Dados atualizados com sucesso");
            
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }
        return jsp;
    }
}
