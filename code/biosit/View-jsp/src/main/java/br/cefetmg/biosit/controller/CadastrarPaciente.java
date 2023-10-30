
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.service.implement.ManterPaciente;
import br.cefetmg.biosit.dto.exception.*;


/**
 *
 * @author Pedro Gabriel
 */
public class CadastrarPaciente {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "/paciente.jsp";
        
        try {
        
            String nome = request.getParameter("nome");
//            System.out.println("nome:" + nome);
            String cpf = request.getParameter("cpf");
//            System.out.println("cpf:" + cpf);
            String dataNasc = request.getParameter("data-nascimento");
//            System.out.println("nasc:" + dataNasc);
            String endereco = request.getParameter("endereco");
//            System.out.println("end:" + endereco);
            Paciente paciente = new Paciente(nome, dataNasc, cpf, endereco);
//            System.out.println("pac:" + paciente);
            
            IManterPaciente manterPaciente = new ManterPaciente();
            manterPaciente.cadastrar(paciente);
            
            request.setAttribute("sucess", "Paciente cadastrado com sucesso");
            
        } catch(PacienteDuplicadoException e) {
            request.setAttribute("tperror", "cadastroPaciente");
            request.setAttribute("error", e.getMessage());
        } catch (CadastroException e) {
            request.setAttribute("tperror", "cadastroPaciente");
            request.setAttribute("error", e.getMessage());
        } catch(Exception e) {
            request.setAttribute("tperror", "cadastroPaciente");
            request.setAttribute("error", "Não foi possível realizar o cadastro, tente novamente");
        }
        
        return jsp;
    }
}
