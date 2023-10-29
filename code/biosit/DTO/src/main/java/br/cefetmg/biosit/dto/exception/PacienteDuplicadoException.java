
package br.cefetmg.biosit.dto.exception;

/**
 *
 * @author Pedro Gabriel
 */
public class PacienteDuplicadoException extends Exception {
    public PacienteDuplicadoException(String cpf) {
        super("Já existe um paciente cadastrado com o CPF " + cpf);
    }
}
