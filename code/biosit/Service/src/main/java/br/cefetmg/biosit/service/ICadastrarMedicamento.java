/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ICadastrarMedicamento {
    
    public String cadastrar(Medicamento medicamento) throws CadastroException;
    public String atualizar(Medicamento medicamento) throws Exception;
    public String excluir(Medicamento medicamento) throws Exception;
    
    public List<Medicamento> pesquisar(Medicamento medicamento) throws Exception;
    
}
