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
        String jsp = "/financeiro.jsp";

        try {
            List<Financeiro> valores = new ArrayList<Financeiro>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date dataAntiga = dateFormat.parse("1945-09-02");
            Date data = dataAntiga;
            Date dataNova = dateFormat.parse("2023-12-04");
            Date dataFinal = dataNova;

            if (!(request.getParameter("data-inicial").equals(""))) {
                data = dateFormat.parse(request.getParameter("data-inicial"));
            }
            if (!(request.getParameter("data-final").equals(""))) {
                dataFinal = dateFormat.parse(request.getParameter("data-final"));
            }

            boolean dataDigitada = !(data.equals(dataAntiga) && dataFinal.equals(dataNova));
            String categoria = request.getParameter("categoria");
            Financeiro financeiro = new Financeiro(data, categoria, dataFinal, 0);

            IPesquisarFinanceiro pesquisarFinanceiro = new PesquisarFinanceiro();

            valores = pesquisarFinanceiro.pesquisar(financeiro, dataDigitada);
            request.setAttribute("valores", valores);

        } catch (Exception e) {
            request.setAttribute("tperror", "pesquisaFinanceiro");
            request.setAttribute("error", e.getMessage());
            jsp = "/financeiro.jsp";
        }

        return jsp;
    }
}
