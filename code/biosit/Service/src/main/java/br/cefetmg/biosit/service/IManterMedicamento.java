package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.dto.exception.CadastroException;
import java.util.List;

public interface IManterMedicamento {
    public String cadastrar(Medicamento medicamento) throws CadastroException;
    public Medicamento atualizar(Medicamento medicamento) throws Exception;
    public String excluir(String nome) throws Exception;
    
    public List<Medicamento> pesquisar(Medicamento medicamento) throws Exception;
}
