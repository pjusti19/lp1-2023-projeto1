/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.biosit.controller;


import br.cefetmg.biosit.DAOMySQL.InternacaoDAO;
import br.cefetmg.biosit.dto.Internacao;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author joaop
 */
@WebServlet(name = "ListagemInternacao", urlPatterns = {
  "/ListagemInternacao"
})
public class ListagemInternacao extends HttpServlet {
    InternacaoDAO dao = new InternacaoDAO();
    
            



  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      PrintWriter out = response.getWriter();
        String action = request.getServletPath();
        InternacaoDAO dao = new InternacaoDAO();
        
        
        
        
        
        
        
        try {
      // Seu código aqui

     ArrayList<Internacao> lista = dao.listarContatos();

        request.setAttribute("contatos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("listagemInternacao.jsp");
         rd.forward(request,response); 

        if (lista != null && !lista.isEmpty()) {
            out.println(lista.get(3).getDtnasc());
        } else {
            out.println("A lista está vazia ou nula.");
        }

    } catch (Exception e) {
      e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
      // Adicione uma mensagem de erro ao request para exibição no JSP, por exemplo:
      out.println("Erro ao atualizar o contato: " + e.getMessage());
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
   // </editor-fold>

}}