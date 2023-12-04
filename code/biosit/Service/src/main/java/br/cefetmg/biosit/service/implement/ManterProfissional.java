
package br.cefetmg.biosit.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.*;
import br.cefetmg.biosit.idao.*;

/**
 *
 * @author Pedro Gabriel
 */
public class ManterProfissional {
    
    private IProfissionalDAO dao;
    
    public ManterProfissional() {
        dao = new ProfissionalDAO();
    }
    
    public void cadastrar(Profissional pro) throws Exception {
        if(Util.verify(pro.getCargo())) {
            throw new Exception("Cadastro incompleto. Insira um cargo");
        }
        if(Util.verify(pro.getCpf())) {
            throw new Exception("Cadastro incompleto. Insira um CPF");
        }
        if(Util.verify(pro.getEmail())) {
            throw new Exception("Cadastro incompleto. Insira um email");
        }
        if(Util.verify(pro.getNascimento())) {
            throw new Exception("Cadastro incompleto. Insira um nascimento");
        }
        if(Util.verify(pro.getNome())) {
            throw new Exception("Cadastro incompleto. Insira um nome");
        }
        
        dao.inserir(pro);
    }
    
    public List<Profissional> pesquisarTodos() throws Exception {
        return dao.pesquisarTodos();
    }
    
    public Profissional pesquisar(String cpf) throws Exception {
        return dao.pesquisarCPF(cpf);
    }
    
    public List<Profissional> pesquisar(Profissional pro) throws Exception {
        List<Profissional> profissionais = new ArrayList<>();
        
        if(Util.verify(pro)) {
            profissionais = dao.pesquisarTodos();
        } else {
            if(!Util.verify(pro.getNome())) {
                profissionais.addAll(dao.pesquisarNome(pro.getNome()));
            }
            if(!Util.verify(pro.getCpf())) {
                Profissional aux = dao.pesquisarCPF(pro.getCpf());
                boolean ver = true;
                for(Profissional p : profissionais) {
                    if(p.equals(aux)) {
                        ver = false;
                    }
                }
                if(ver) profissionais.add(aux);
            }
            if(!Util.verify(pro.getRegistro())) {
                List<Profissional> novos = dao.pesquisarRegistro(pro.getRegistro());
                for(Profissional novo : novos) {
                    boolean ver = true;
                    for(Profissional exist : profissionais) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) profissionais.add(novo);
                }
            }
            if(!Util.verify(pro.getCargo())) {
                List<Profissional> novos = dao.pesquisarCargo(pro.getCargo());
                for(Profissional novo : novos) {
                    boolean ver = true;
                    for(Profissional exist : profissionais) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) profissionais.add(novo);
                }
            }
            if(!Util.verify(pro.getEspecialidade())) {
                List<Profissional> novos = dao.pesquisarEspecialidade(pro.getEspecialidade());
                for(Profissional novo : novos) {
                    boolean ver = true;
                    for(Profissional exist : profissionais) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) profissionais.add(novo);
                }
            }
        }
        return profissionais;
    }
    
    public void atualizar(Profissional pro) throws Exception {
        if(Util.verify(pro.getCargo())) {
            throw new Exception("Erro");
        }
        if(Util.verify(pro.getCpf())) {
            throw new Exception("Erro");
        }
        if(Util.verify(pro.getNome())) {
            throw new Exception("Erro");
        }
        
        dao.atualizar(pro);
    }
    
    public void excluir(String cpf) throws Exception {
        dao.excluir(cpf);
    }
    
//    public static void main(String[] args) {
//        try {
//            ManterProfissional service = new ManterProfissional();
//            Profissional pro = new Profissional("");
//            pro.setCpf("12345678985");
//            List<Profissional> pros = service.pesquisar(pro);
//            for(Profissional p : pros) {
//                System.out.println(p.getNome());
//            }
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
