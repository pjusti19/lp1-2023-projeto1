package br.cefetmg.biosit.service.implement;

import java.util.Date;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.exception.*;
import br.cefetmg.biosit.service.util.Util;
import java.util.List;
/**
 *
 * @author Pedro Gabriel
 */
public class ManterPaciente implements IManterPaciente {
    @Override
    public String cadastrar(Paciente paciente) throws CadastroException {
        String id = "";
        
        if(Util.verify(paciente.getNome())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        
        return id;
    }
    
    @Override
    public String atualizar(Paciente paciente) {
        String id = "";
        return id;
    }
    @Override
    public String excluir(Paciente paciente) {
        String id = "";
        return id;
    }
    
    
    public List<Paciente> pesquisar(String id, String nome, Date dataNasc) {
        //List<Paciente> pacientes = new List<Paciente>;
        return null;
    }
}
