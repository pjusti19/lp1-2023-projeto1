/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.service.implement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.ICadastrarMedicamento;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.MedicamentoDAO;
import br.cefetmg.biosit.idao.IMedicamentoDAO;
/**
 *
 * @author Aluno
 */
public class CadastrarMedicamento implements ICadastrarMedicamento {
    private IMedicamentoDAO medicamentoDAO;
   
    
    public String cadastrar(Medicamento medicamento) throws CadastroException {
        
        if(Util.verify(medicamento.getNome())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(medicamento.getFornecedora())) {
            throw new CadastroException("Cadastro Incompleto, insira uma fornecedora");
        }
        if(Util.verify(medicamento.getData())) {
            throw new CadastroException("Cadastro Incompleto, insira uma validade");
        }
        if(medicamento.getLote() == 0) {
            throw new CadastroException("Cadastro Incompleto, insira um lote");
        }
        if(medicamento.getQuantRestante() == 0) {
            throw new CadastroException("Cadastro Incompleto, insira uma quantidade");
        }
        
        
        medicamentoDAO.inserir(medicamento);
        return "?";
    }
    
    @Override
    public String atualizar(Medicamento medicamento) throws Exception {
        String id = "";
        return id;
    }
    @Override
    public String excluir(Medicamento medicamento) throws Exception {
        String id = "";
        return id;
    }
    
    
    @Override
    public List<Medicamento> pesquisar(Medicamento medicamento) throws Exception {
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        if(!Util.verify(medicamento.getNome())) {
            medicamentos.addAll(medicamentoDAO.pesquisarNome(medicamento.getNome()));
        }
        if(medicamento.getLote() == 0) {
        }
        if(!Util.verify(medicamento.getFornecedora())) {
        }
        if(!Util.verify(medicamento.getData())) {
        }
        if(medicamento.getQuantRestante() == 0){
        }
        return null;
    }
}
