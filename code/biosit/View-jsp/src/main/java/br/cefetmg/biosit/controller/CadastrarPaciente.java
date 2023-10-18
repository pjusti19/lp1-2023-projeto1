
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.service.implement.ManterPaciente;
import br.cefetmg.biosit.service.exception.*;


/**
 *
 * @author Pedro Gabriel
 */
public class CadastrarPaciente {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try {
            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            Date dataNasc = new Date(request.getParameter("data-nascimento"));
            String endereco = request.getParameter("endereco");
            Paciente paciente = new Paciente(nome, dataNasc, cpf, endereco);
            
            IManterPaciente manterPaciente = new ManterPaciente();
            
            manterPaciente.cadastrar(paciente);
            
        } catch(CadastroException e) {
            request.setAttribute("erro", e.getMessage());
            jsp = "erroCadastro";
        } catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return "index";
    }
}
