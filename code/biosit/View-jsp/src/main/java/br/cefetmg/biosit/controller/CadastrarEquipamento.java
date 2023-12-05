package br.cefetmg.biosit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.service.IManterEquipamento;
import br.cefetmg.biosit.service.implement.ManterEquipamento;
import br.cefetmg.biosit.dto.exception.*;

@WebServlet(urlPatterns = {"/CadastrarEquipamento"})
public class CadastrarEquipamento extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "/equipamento.jsp";
        
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String data = request.getParameter("data");
            String setor = request.getParameter("setor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
            Equipamento equipamento = new Equipamento(nome, data, quantidade, fornecedora, setor);
            IManterEquipamento manterEquipamento = new ManterEquipamento();
            manterEquipamento.cadastrar(equipamento);
            
            
        } catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return jsp;
    }
}