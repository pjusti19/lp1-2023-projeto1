package br.cefetmg.biosit.controller;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.service.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/CadastrarEquipamento"})
public class CadastrarEquipamento extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "/equipamento.jsp";
        
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            Date data = new Date(request.getParameter("data"));
            String setor = request.getParameter("setor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
            //Equipamento equipamento = new Equipamento(fornecedora, nome, data, setor, quantidade);
            CadastrarEquipamento cad = new CadastrarEquipamento();
            //cad.cadastrar(equipamento);
            
            
        } catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return jsp;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}