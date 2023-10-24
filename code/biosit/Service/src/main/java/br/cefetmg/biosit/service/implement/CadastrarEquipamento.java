/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.service.implement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.ICadastrarEquipamento;
import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.EquipamentoDAO;
import br.cefetmg.biosit.idao.IEquipamentoDAO;
/**
 *
 * @author Aluno
 */
public class CadastrarEquipamento {
    private IEquipamentoDAO equipamentoDAO;
   
    
    @Override
    public String cadastrar(Equipamento equipamento) throws CadastroException {
        
        if(Util.verify(equipamento.getNome())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(equipamento.getFornecedora())) {
            throw new CadastroException("Cadastro Incompleto, insira uma fornecedora");
        }
        if(Util.verify(equipamento.getData())) {
            throw new CadastroException("Cadastro Incompleto, insira uma data");
        }
        if(Util.verify(equipamento.getSetor())) {
            throw new CadastroException("Cadastro Incompleto, insira um setor");
        }
        if(equipamento.getQuant() == 0 || equipamento.getQuant() == null) {
            throw new CadastroException("Cadastro Incompleto, insira uma quantidade");
        }
        
        
        equipamentoDAO.inserir(equipamento);
        
    }
    
    @Override
    public String atualizar(Equipamento equipamento) throws Exception {
        String id = "";
        return id;
    }
    @Override
    public String excluir(Equipamento equipamento) throws Exception {
        String id = "";
        return id;
    }
    
    
    @Override
    public List<Equipamento> pesquisar(Equipamento equipamento) throws Exception {
        List<Equipamento> equipamentos = new ArrayList<Equipamento>();
        if(!Util.verify(equipamento.getNome())) {
            equipamentos.addAll(equipamentoDAO.pesquisarNome(equipamento.getNome()));
        }
        if(!Util.verify(equipamento.getSetor())) {
        }
        if(!Util.verify(equipamento.getFornecedora())) {
        }
        if(!Util.verify(equipamento.getData())) {
        }
        if(equipamento.getQuant() == 0 || equipamento.getQuant() == null){
        }
        return null;
    }
}
