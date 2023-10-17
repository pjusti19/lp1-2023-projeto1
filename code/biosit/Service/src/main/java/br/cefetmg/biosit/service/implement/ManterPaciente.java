package br.cefetmg.biosit.service.implement;

import java.util.Date;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.dto.Paciente;
import java.util.List;
/**
 *
 * @author Pedro Gabriel
 */
public class ManterPaciente implements IManterPaciente {
    @Override
    public String cadastrar(Paciente paciente) {
        String id = "";
        //verificar os dados do cliente
        // usar classe DAO para gravar no bd
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
