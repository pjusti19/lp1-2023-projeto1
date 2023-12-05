/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.biosit.controller;

import br.cefetmg.biosit.DAOMySQL.TriagemDAO;
import br.cefetmg.biosit.dto.Triagem;
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
@WebServlet(name = "CadastrarTriagem", urlPatterns = {
  "/CadastrarTriagem"
})
public class CadastrarTriagem extends HttpServlet {

    static String execute(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  TriagemDAO dao = new TriagemDAO();
  Triagem inserir = new Triagem();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();

    try {

      inserir.setNome(request.getParameter("nome"));
      inserir.setDtnasc(request.getParameter("dtnasc"));

      inserir.setCpf(request.getParameter("cpf"));
      inserir.setMedico(request.getParameter("medico"));
      inserir.setEsp(request.getParameter("esp"));
      inserir.setConsult(request.getParameter("consult"));
      inserir.setHora_ent(request.getParameter("hora_ent"));
      inserir.setHora_prev(request.getParameter("hora_prev"));
      inserir.setUrg(request.getParameter("urg"));

      dao.inserirTriagem(inserir);

    } catch (Exception e) {
      e.printStackTrace();

    }
    
    

    RequestDispatcher dispatcher = request.getRequestDispatcher("/ExibirTriagem");
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