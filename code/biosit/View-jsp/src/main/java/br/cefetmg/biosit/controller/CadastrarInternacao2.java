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
@WebServlet(name = "CadastrarInternacao2", urlPatterns = {
  "/CadastrarInternacao2"
})
public class CadastrarInternacao2 extends HttpServlet {
  

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();
    InternacaoDAO dao = new InternacaoDAO();
  Internacao inserir = new Internacao();
  
    inserir.setNome("joao");
      inserir.setDtnasc("2004");
      inserir.setCpf("16965357606");
      inserir.setQuarto("301");
      inserir.setLeito("A");
      inserir.setDat_ent("2005");
      inserir.setMotivo("doença");
      inserir.setHistorico("sei la");
      out.println(inserir.getNome());
      out.println("joao");
      dao.inserirInternacao(inserir);
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