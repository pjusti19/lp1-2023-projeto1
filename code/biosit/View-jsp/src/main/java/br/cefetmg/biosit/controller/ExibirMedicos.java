
package br.cefetmg.biosit.controller;


import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Aluno
 */
public class ExibirMedicos {
    public static String execute(HttpServletRequest request) {
        
        String jsp = "/consulta.jsp";
        
        try {
            // request.setAttribute("funcionarios", funcionarios);
        } catch(Exception e) {
            request.setAttribute("tperror", "buscarConsulta");
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }
        
        return jsp;
    }
}
