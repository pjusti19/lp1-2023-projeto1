
package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public interface IProfissionalDAO {
    
    boolean inserir(Profissional profissional) throws Exception;
    boolean atualizar(Profissional profissional) throws Exception;
    boolean excluir(String cpf) throws Exception;
    List<Profissional> pesquisar(Profissional pro) throws Exception;
    Profissional pesquisar(String cpf) throws Exception;
}
