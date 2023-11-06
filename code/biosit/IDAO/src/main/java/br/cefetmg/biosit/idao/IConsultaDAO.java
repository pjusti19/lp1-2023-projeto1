package br.cefetmg.biosit.idao;


import java.util.List;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.dto.exception.*;

/**
 *
 * @author pjusti19
 */
public interface IConsultaDAO {
    boolean inserir(Consulta consulta) throws CadastroException;
    boolean atualizar(Consulta consulta) throws Exception;
    boolean deletar(Consulta consulta) throws Exception;
    List<Consulta> pesquisarNome(String medico) throws Exception;
    List<Consulta> pesquisarDataHora(String dataHora) throws Exception;
    List<Consulta> pesquisarPaciente (String nomePaciente) throws Exception;
    List<Consulta> pesquisarTodos() throws Exception;
}
