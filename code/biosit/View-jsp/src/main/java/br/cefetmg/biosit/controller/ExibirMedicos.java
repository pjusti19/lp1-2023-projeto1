
package br.cefetmg.biosit.controller;


import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Medico;
// import br.cefetmg.biosit.service.IManterMedico;
// import br.cefetmg.biosit.service.implement.ManterMedico;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;

public class ExibirMedicos {
    public static String execute(HttpServletRequest request) {
        
        String jsp = "/consulta.jsp";
        
        try {
            List<Medico> medicos = new ArrayList<Medico>();
            
            // ManterMedico manterMedico = new ManterMedico());
            // medicos = manterMedico.pesquisar();
           request.setAttribute("medicos", medicos);
        } catch(Exception e) {
            request.setAttribute("tperror", "buscarConsulta");
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }
        
        return jsp;
    }
}
