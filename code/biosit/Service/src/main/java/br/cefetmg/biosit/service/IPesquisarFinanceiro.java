
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Financeiro;
import java.util.List;

/**
 *
 * @author David Eller
 */
public interface IPesquisarFinanceiro {   
    public List<Financeiro> pesquisar(Financeiro financeiro, boolean dataDigitada) throws Exception;
}
