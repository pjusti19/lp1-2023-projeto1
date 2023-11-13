package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.service.implement.AgendarConsulta;
/**
 *
 * @author Pedro Gabriel
 */
public class ExibirConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/infoConsultas.jsp";
        try {
            String medico = request.getParameter("nomeExibir");

            AgendarConsulta agendarConsulta = new AgendarConsulta();
            Consulta consulta = agendarConsulta.pesquisar(medico);
            
            request.setAttribute("consulta_exib", consulta);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "buscar Consulta");
            jsp = "/listagemConsultas.jsp";
        }
        return jsp;
    }
}
