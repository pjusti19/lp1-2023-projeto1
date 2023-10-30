 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
@WebServlet(urlPatterns = {"/CadastrarMedicamento"})
public class CadastrarMedicamento extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            Date data = new Date(request.getParameter("data"));
            String setor = request.getParameter("setor");
            int quantidadeRestante = Integer.parseInt("quantidade");
        } catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return jsp;
    }

}