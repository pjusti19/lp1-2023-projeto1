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
import java.util.ArrayList;

/**
 *
 * @author joaop
 */
@WebServlet(name = "CadastrarInternacao", urlPatterns = {
  "/CadastrarInternacao"
})
public class CadastrarInternacao extends HttpServlet {
  InternacaoDAO dao = new InternacaoDAO();
  Internacao inserir = new Internacao();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();

    try {

      inserir.setNome(request.getParameter("nome"));
      inserir.setDtnasc(request.getParameter("dtnasc"));
      inserir.setCpf(request.getParameter("cpf"));
      inserir.setQuarto(request.getParameter("quarto"));
      inserir.setLeito(request.getParameter("leito"));
      inserir.setDat_ent(request.getParameter("data_ent"));
      inserir.setMotivo(request.getParameter("motivo"));
      inserir.setHistorico(request.getParameter("historico"));
      

      dao.inserirInternacao(inserir);

    } catch (Exception e) {
      e.printStackTrace();

    }
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/ListagemInternacao");
    dispatcher.forward(request, response); 
    
    

    

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

  }
}