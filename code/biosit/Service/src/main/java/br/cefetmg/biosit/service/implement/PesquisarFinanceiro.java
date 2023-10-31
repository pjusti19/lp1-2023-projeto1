
package br.cefetmg.biosit.service.implement;

import br.cefetmg.biosit.DAOMySQL.FinanceiroDAO;
import br.cefetmg.biosit.dto.Financeiro;
import br.cefetmg.biosit.idao.IFinanceiroDAO;
import br.cefetmg.biosit.service.IPesquisarFinanceiro;
import br.cefetmg.biosit.service.util.Util;
import java.util.ArrayList;
import java.util.List;

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
    public List<Financeiro> pesquisar(Financeiro financeiro) throws Exception {
        List<Financeiro> valores = new ArrayList<Financeiro>();
        if(Util.verify(financeiro)) {
            valores = financeiroDAO.pesquisarTodos();
        } else {
            if(!Util.verify(financeiro.getCategoria())) {
                valores.addAll(financeiroDAO.pesquisarCategoria(financeiro.getCategoria()));
            }
            
            if(!Util.verify(financeiro.getData())) {
                List<Financeiro> novos = financeiroDAO.pesquisarIntervaloData(financeiro.getData(), financeiro.getDataFinal());
                for(Financeiro novo : novos) {
                    boolean ver = true;
                    for(Financeiro exist : valores) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) valores.add(novo);
                }
            }          
        }
        return valores;
    }

}


