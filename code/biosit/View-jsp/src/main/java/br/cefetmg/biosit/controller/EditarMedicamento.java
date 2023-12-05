
package br.cefetmg.biosit.controller;
import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.service.implement.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;

public class EditarMedicamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        Medicamento medicamento = null;
        
        String nome = request.getParameter("nome");

        try {
            String cpf = request.getParameter("cpf");
            String fornecedora = request.getParameter("fornecedora");
            String validade = request.getParameter("dataValidade");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            int lote = Integer.parseInt(request.getParameter("lote"));

            
        
            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo-reg");
            String desc = request.getParameter("desc-reg");
            String tipo = request.getParameter("tipo-reg");
            
            medicamento = new Medicamento();
            medicamento.setNome(nome);
            medicamento.setFornecedora(fornecedora);
            medicamento.setData(validade);
            medicamento.setQuantRestante(quantidade);
            medicamento.setLote(lote);

            IManterMedicamento manterMedicamento = new ManterMedicamento();
            manterMedicamento.atualizar(medicamento);
        } catch (Exception e) {
            request.setAttribute("tperror", "atualizar");
            request.setAttribute("error", "Não foi possível editar o medicamento");
        }
        
        System.out.println("chego aq");
        ManterMedicamento manterMedicamento = new ManterMedicamento();
        try { medicamento = manterMedicamento.pesquisar(nome); } catch(Exception e) {}
        request.setAttribute("medicamento_exib", medicamento);
        request.setAttribute("sucess", "Medicamento editado com sucesso");
            
        return jsp;
    }
}
