
package br.cefetmg.biosit.service.exception;

/**
 *
 * @author Pedro Gabriel
 */
public class CadastroException extends Exception {
    public CadastroException(String mensagem) {
        super(mensagem);
    }
    
    public CadastroException() {
        super("Cadastro Incompleto");
    }
}
