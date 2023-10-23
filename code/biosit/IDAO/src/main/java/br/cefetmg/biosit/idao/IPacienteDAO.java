
package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.dto.exception.CadastroException;
import java.util.Date;
/**
 *
 * @author Aluno
 */
public interface IPacienteDAO {
    boolean inserir(Paciente paciente) throws CadastroException;
    boolean atualizar(Paciente paciente) throws Exception;
    boolean deletar(Paciente paciente) throws Exception;
    List<Paciente> pesquisarNome(String nome) throws Exception;
    List<Paciente> pesquisarCPF(String cpf) throws Exception;
    List<Paciente> pesquisarEndereco(String endereco) throws Exception;
    List<Paciente> pesquisarNascimento(Date nascimento) throws Exception;

}