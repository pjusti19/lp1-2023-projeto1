package br.cefetmg.biosit.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
//@WebServlet(urlPatterns = {"/Facade"})
public class Facade extends HttpServlet {
    private String jsp;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String act = request.getParameter("act");
        
        if(act == null) {
            jsp = "/index.jsp";
        } else if(act.equals("cadastrarPaciente")) {
            jsp = CadastrarPaciente.execute(request);
        } else if(act.equals("buscarPaciente")) {
            jsp = BuscarPaciente.execute(request);
        } else if(act.equals("exibirPaciente")) {
            jsp = ExibirPaciente.execute(request);
        } else if(act.equals("atualizaPaciente")) {
            jsp = AtualizarPaciente.execute(request);
        } else if(act.equals("excluirPaciente")) {
            jsp = ExcluirPaciente.execute(request);
        } else if(act.equals("cadastrarEquipamento")) {
            jsp = CadastrarEquipamento.execute(request);
        } else if (act.equals("cadastrarMedicamento")) {
            jsp = CadastrarMedicamento.execute(request);
        }else if(act.equals("buscarEquipamento")) {
            jsp = BuscarEquipamento.execute(request);
        } else if(act.equals("exibirEquipamento")) {
            jsp = ExibirEquipamento.execute(request);
        } else if(act.equals("atualizaEquipamento")) {
            jsp = AtualizarEquipamento.execute(request);
        } else if(act.equals("excluirEquipamento")) {
            jsp = ExcluirEquipamento.execute(request);
        } else if(act.equals("buscarMedicamento")) {
            jsp = BuscarMedicamento.execute(request);
        } else if(act.equals("exibirMedicamento")) {
            jsp = ExibirMedicamento.execute(request);
        } else if(act.equals("atualizaMedicamento")) {
            jsp = AtualizarMedicamento.execute(request);
        } else if(act.equals("excluirMedicamento")) {
            jsp = ExcluirMedicamento.execute(request);
        } 
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    

}