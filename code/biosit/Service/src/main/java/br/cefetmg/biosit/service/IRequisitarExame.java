
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Exame;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;


public interface IRequisitarExame {
    
    public String cadastrar(Exame exame) throws CadastroException;
    public String atualizar(Exame exame) throws Exception;
    public String excluir(Exame exame) throws Exception;
    public List<Exame> pesquisar(Exame exame) throws Exception;
    
}
