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
    public String cadastrar(Paciente paciente) throws CadastroException, PacienteDuplicadoException {
        
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
        
        if(paciente.getCPF().length() != 11) {
            throw new CadastroException("Insira um CPF válido");
        }
        if(paciente.getNome().length() > 25) {
            throw new CadastroException("O nome não pode ter mais de 50 caracteres");
        }
        if(paciente.getEndereco().length() > 50) {
            throw new CadastroException("O endereço não pode ter mais de 100 caracteres");
        }
        
        
        pacienteDAO.inserir(paciente);
        
        return "";
    }
    
    @Override
    public String atualizar(Paciente paciente) throws Exception {
        String id = "";
        if(Util.verify(paciente.getNome())) {
            throw new CadastroException("Insira um nome");
        }
        if(Util.verify(paciente.getCPF())) {
            throw new CadastroException("Insira um CPF");
        }
        if(Util.verify(paciente.getNascimento())) {
            throw new CadastroException("Insira uma data de nascimento");
        }
        if(Util.verify(paciente.getEndereco())) {
            throw new CadastroException("Insira um CPF");
        }
        
        
        pacienteDAO.atualizar(paciente);
        
        return null;
    }
    @Override
    public String excluir(Paciente paciente) throws Exception {
        String id = "";
        return id;
    }
    
    
    @Override
    public List<Paciente> pesquisar(Paciente paciente) throws Exception {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        if(Util.verify(paciente)) {
            pacientes = pacienteDAO.pesquisarTodos();
        } else {
            if(!Util.verify(paciente.getNome())) {
                pacientes.addAll(pacienteDAO.pesquisarNome(paciente.getNome()));
            }
            if(!Util.verify(paciente.getCPF())) {
                Paciente aux = pacienteDAO.pesquisarCPF(paciente.getCPF());
                boolean ver = true;
                for(Paciente pac : pacientes) {
                    if(pac.equals(aux)) {
                        ver = false;
                    }
                }
                if(ver) pacientes.add(aux);
            }
            if(!Util.verify(paciente.getNascimento())) {
                List<Paciente> novos = pacienteDAO.pesquisarNascimento(paciente.getNascimento());
                for(Paciente novo : novos) {
                    boolean ver = true;
                    for(Paciente exist : pacientes) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) pacientes.add(novo);
                }
            }
            if(!Util.verify(paciente.getEndereco())) {
                List<Paciente> novos = pacienteDAO.pesquisarEndereco(paciente.getEndereco());
                for(Paciente novo : novos) {
                    System.out.println(novo);
                    boolean ver = true;
                    for(Paciente exist : pacientes) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) pacientes.add(novo);
                }
            }
        }
        return pacientes;
    }
    
    public Paciente pesquisar(String cpf) throws Exception {
        Paciente paciente = null;
        paciente = pacienteDAO.pesquisarCPF(cpf);
        
        return paciente;
    }
}
