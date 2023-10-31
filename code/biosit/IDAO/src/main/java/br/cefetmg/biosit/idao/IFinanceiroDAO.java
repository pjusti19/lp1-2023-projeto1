package br.cefetmg.biosit.idao;

import br.cefetmg.biosit.dto.Financeiro;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David Eller
 */
public interface IFinanceiroDAO {
    List<Financeiro> pesquisarCategoria(String categoria) throws Exception;
    List<Financeiro> pesquisarIntervaloData(Date dataInicial, Date dataFinal) throws Exception;
    List<Financeiro> pesquisarTodos() throws Exception;
}
