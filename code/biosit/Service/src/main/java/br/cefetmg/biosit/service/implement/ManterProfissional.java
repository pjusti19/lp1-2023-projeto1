
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
    
    public void atualizar(Profissional pro) throws Exception {
        
    }
}
