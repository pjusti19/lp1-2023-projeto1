package br.cefetmg.biosit.controller;

import br.cefetmg.biosit.dto.Consulta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author DavidEller
 */
public class AdicionarNotificacao {

    public static void adicionar(Consulta consulta, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            List<Consulta> consultas = (List<Consulta>) session.getAttribute("consultas");

            consultas.add(consulta);
            session.setAttribute("consultas", consultas);
            

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());

        }
    }
}
