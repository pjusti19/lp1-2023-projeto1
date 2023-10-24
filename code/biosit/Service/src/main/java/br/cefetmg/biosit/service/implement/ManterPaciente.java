package br.cefetmg.biosit.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.PacienteDAO;
import br.cefetmg.biosit.idao.IPacienteDAO;

/**
 *
 * @author Pedro Gabriel
 */
public class ManterPaciente implements IManterPaciente {
    
    private IPacienteDAO pacienteDAO;
    
    public ManterPaciente() {
        pacienteDAO = new PacienteDAO();
    }
    
    @Override
    public String cadastrar(Paciente paciente) throws CadastroException {
        
        if(Util.verify(paciente.getNome())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(paciente.getCPF())) {
            throw new CadastroException("Cadastro Incompleto, insira um CPF");
        }
        if(Util.verify(paciente.getNascimento())) {
            throw new CadastroException("Cadastro Incompleto, insira uma data de nascimento");
        }
        if(Util.verify(paciente.getEndereco())) {
            throw new CadastroException("Cadastro Incompleto, insira um CPF");
        }
        
        String id = paciente.getCPF() + paciente.getNome().charAt(0);
        paciente.setId(id);
        
        pacienteDAO.inserir(paciente);
        
        return id;
    }
    
    @Override
    public String atualizar(Paciente paciente) throws Exception {
        String id = "";
        return id;
    }
    @Override
    public String excluir(Paciente paciente) throws Exception {
        String id = "";
        return id;
    }
    
    
    @Override
    public List<Paciente> pesquisar(Paciente paciente) throws Exception {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        if(!Util.verify(paciente.getNome())) {
            pacientes.addAll(pacienteDAO.pesquisarNome(paciente.getNome()));
        }
        if(!Util.verify(paciente.getCPF())) {
        }
        if(!Util.verify(paciente.getNascimento())) {
        }
        if(!Util.verify(paciente.getEndereco())) {
        }
        return null;
    }
}
