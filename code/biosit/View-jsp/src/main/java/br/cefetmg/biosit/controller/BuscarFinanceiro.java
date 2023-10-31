
package br.cefetmg.biosit.controller;

/**
 *
 * @author David Eller
 */
import br.cefetmg.biosit.dto.Financeiro;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.biosit.service.IPesquisarFinanceiro;
import br.cefetmg.biosit.service.implement.PesquisarFinanceiro;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuscarFinanceiro {
    public static String execute(HttpServletRequest request) {
        String jsp = "/listagemFinanceiro.jsp";
        
        try {
            List<Financeiro> valores = new ArrayList<Financeiro>();
            
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data-inicial"));
            Date dataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data-final"));
            String categoria = request.getParameter("");
            Financeiro financeiro = new Financeiro(data, categoria, dataFinal);
            
            IPesquisarFinanceiro pesquisarFinanceiro = new PesquisarFinanceiro();
            
            valores = pesquisarFinanceiro.pesquisar(financeiro);
            request.setAttribute("valores", valores);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaPaciente");
            request.setAttribute("error", e.getMessage());
            jsp = "/financeiro.jsp";
        }
        
        return jsp;
    }
}
