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
@WebServlet(name = "SelecionarTriagem", urlPatterns = {"/editarcontato", "/apagarcontato",
  "/SelecionarInternao", "/apagarinternacao", "/editarinternacao"
})
public class SelecionarInternacao extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();

    InternacaoDAO dao = new InternacaoDAO();
    Internacao inserir = new Internacao();

    ArrayList < Internacao > lista = dao.listarContatos();

    request.setAttribute("contatos", lista);
    String idinter = request.getParameter("idcon");

    inserir.setIdinter(idinter);

    dao.selecionarInternacao(inserir);

    request.setAttribute("nomemodal", inserir.getNome());
    request.setAttribute("cpfmodal", inserir.getCpf());
    request.setAttribute("dtnascmodal", inserir.getDtnasc());
    request.setAttribute("quartomodal", inserir.getQuarto());
    request.setAttribute("leitomodal", inserir.getLeito());
    request.setAttribute("datenmodal", inserir.getDat_ent());

    request.setAttribute("idintermodal", inserir.getIdinter());
    
    if(action.equals("/editarinternacao")){
    request.setAttribute("Modal", true);
    request.setAttribute("Modalapagar", false);
    RequestDispatcher dispatcher = request.getRequestDispatcher("listagemInternacao.jsp");
    dispatcher.forward(request, response);
    }
    else if(action.equals("/apagarinternacao")){
    request.setAttribute("Modalapagar", true);
    request.setAttribute("Modal", false);
    RequestDispatcher dispatcher = request.getRequestDispatcher("listagemInternacao.jsp");
    dispatcher.forward(request, response);
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

  }
}