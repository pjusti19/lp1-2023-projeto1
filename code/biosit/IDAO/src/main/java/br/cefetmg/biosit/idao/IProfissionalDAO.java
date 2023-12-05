
package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public interface IProfissionalDAO {
    
    boolean inserir(Profissional profissional) throws Exception;
    boolean atualizar(Profissional profissional) throws Exception;
    boolean excluir(String cpf) throws Exception;
    
    List<Profissional> pesquisarTodos() throws Exception;
    List<Profissional> pesquisarNome(String nome) throws Exception;
    Profissional pesquisarCPF(String cpf) throws Exception;
    List<Profissional> pesquisarRegistro(String registro) throws Exception;
    List<Profissional> pesquisarCargo(String cargo) throws Exception;
    List<Profissional> pesquisarEspecialidade(String especialidade) throws Exception;
    
    Integer inserirAcesso(String cargo, String user, String senha) throws Exception;
    boolean linkarAcesso(String cpf, Integer id) throws Exception;
    boolean excluirAcesso(Integer id) throws Exception;
}
