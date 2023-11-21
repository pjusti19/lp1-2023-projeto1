package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.dto.exception.CadastroException;
import java.util.List;

public interface IManterEquipamento {
    public String cadastrar(Equipamento equipamento) throws CadastroException;
    public Equipamento atualizar(Equipamento equipamento) throws Exception;
    public String excluir(String nome) throws Exception;
    
    public List<Equipamento> pesquisar(Equipamento equipamento) throws Exception;
}
