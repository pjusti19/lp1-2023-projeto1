/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ICadastrarEquipamento {
    
    public String cadastrar(Equipamento equipamento) throws CadastroException;
    public String atualizar(Equipamento equipamento) throws Exception;
    public String excluir(Equipamento equipamento) throws Exception;
    
    public List<Equipamento> pesquisar(Equipamento equipamento) throws Exception;
    
}
