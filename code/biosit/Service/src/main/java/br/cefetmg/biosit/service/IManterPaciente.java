
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.exception.*;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public interface IManterPaciente {
    
    public String cadastrar(Paciente paciente) throws CadastroException;
    public String atualizar(Paciente paciente);
    public String excluir(Paciente paciente);
    
    //public Paciente pesquisar(String id, String nome, Date dataNasc);
    
}
