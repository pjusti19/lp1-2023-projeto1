package br.cefetmg.biosit.service;

import java.util.List;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.dto.exception.*;
/**
 *
 * @author pjusti19
 */
public interface IAgendarConsulta {
    public String cadastrar(Consulta consulta) throws CadastroException, MedicoIndisponivelException;
    public String atualizar(Consulta consulta) throws Exception;
    public String excluir(String nomePaciente) throws Exception;
    
    public List<Consulta> pesquisar(Consulta consulta) throws Exception;
}
