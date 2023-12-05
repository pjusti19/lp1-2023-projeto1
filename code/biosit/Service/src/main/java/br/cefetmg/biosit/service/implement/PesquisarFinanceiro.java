package br.cefetmg.biosit.service.implement;

import br.cefetmg.biosit.DAOMySQL.FinanceiroDAO;
import br.cefetmg.biosit.dto.Financeiro;
import br.cefetmg.biosit.idao.IFinanceiroDAO;
import br.cefetmg.biosit.service.IPesquisarFinanceiro;
import br.cefetmg.biosit.service.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 *
 * @author David Eller
 */
public class PesquisarFinanceiro implements IPesquisarFinanceiro {

    private IFinanceiroDAO financeiroDAO;

    public PesquisarFinanceiro() {
        financeiroDAO = new FinanceiroDAO();
    }

    @Override
    public List<Financeiro> pesquisar(Financeiro financeiro, boolean dataDigitada) throws Exception {
        List<Financeiro> valores = new ArrayList<Financeiro>();
        HashSet<Financeiro> valoresSet = new HashSet<>();

        if (Util.verify(financeiro.getCategoria()) && !dataDigitada) {
            valores = financeiroDAO.pesquisarTodos();
        } else {
            if (!Util.verify(financeiro.getCategoria()) && dataDigitada) {
                valores.addAll(financeiroDAO.pesquisarCompleto(financeiro.getCategoria(), financeiro.getData(), financeiro.getDataFinal()));

            } else {
                if (!Util.verify(financeiro.getCategoria())) {
                    valores.addAll(financeiroDAO.pesquisarCategoria(financeiro.getCategoria()));
                }

                if (dataDigitada) {
                    List<Financeiro> novos = financeiroDAO.pesquisarIntervaloData(financeiro.getData(), financeiro.getDataFinal());
                    for (Financeiro novo : novos) {
                        if (valoresSet.add(novo)) {
                            valores.add(novo);
                        }
                    }
                }
            }

        }
        return valores;
    }
}
