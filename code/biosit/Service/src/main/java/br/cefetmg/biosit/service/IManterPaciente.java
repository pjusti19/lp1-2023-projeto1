
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Pedro Gabriel
 */
public interface IManterPaciente {
    
    public String cadastrar(Paciente paciente) throws CadastroException;
    public String atualizar(Paciente paciente) throws Exception;
    public String excluir(Paciente paciente) throws Exception;
    
    public List<Paciente> pesquisar(Paciente paciente) throws Exception;
    
}
