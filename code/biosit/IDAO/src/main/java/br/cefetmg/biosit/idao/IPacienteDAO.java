
package br.cefetmg.biosit.idao;


import br.cefetmg.biosit.dto.Paciente;
/**
 *
 * @author Aluno
 */
public interface IPacienteDAO {
    boolean inserir(Paciente paciente);
    boolean atualizar(Paciente paciente);
    boolean deletar(Paciente paciente);
}
