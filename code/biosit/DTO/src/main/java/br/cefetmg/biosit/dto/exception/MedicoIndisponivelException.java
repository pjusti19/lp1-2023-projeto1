
package br.cefetmg.biosit.dto.exception;

/**
 *
 * @author pjusti19
 */
public class MedicoIndisponivelException extends Exception {
    public MedicoIndisponivelException(String medico, String data, String horario) {
        super("O medico" + medico + "já possui uma consulta marcada na data" + data + "às" + horario);
    }
}
