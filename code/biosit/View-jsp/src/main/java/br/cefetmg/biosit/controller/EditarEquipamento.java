
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

public class EditarEquipamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/equipamento.jsp";
        Equipamento equipamento = null;
        
        String nome = request.getParameter("nome");

        try {
            String cpf = request.getParameter("cpf");
            String fornecedora = request.getParameter("fornecedora");
            String data = request.getParameter("data");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            String setor = request.getParameter("setor");

            
        
            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo-reg");
            String desc = request.getParameter("desc-reg");
            String tipo = request.getParameter("tipo-reg");
            
            equipamento = new Equipamento();
            equipamento.setNome(nome);
            equipamento.setFornecedora(fornecedora);
            equipamento.setData(data);
            equipamento.setQuant(quantidade);
            equipamento.setSetor(setor);

            IManterEquipamento manterEquipamento = new ManterEquipamento();
            manterEquipamento.atualizar(equipamento);
        } catch (Exception e) {
            request.setAttribute("tperror", "atualizar");
            request.setAttribute("error", "Não foi possível editar o equipamento");
        }
        
        System.out.println("chego aq");
        ManterEquipamento manterEquipamento = new ManterEquipamento();
        try { equipamento = manterEquipamento.pesquisar(nome); } catch(Exception e) {}
        request.setAttribute("equipamento_exib", equipamento);
        request.setAttribute("sucess", "Equipamento editado com sucesso");
            
        return jsp;
    }
}


