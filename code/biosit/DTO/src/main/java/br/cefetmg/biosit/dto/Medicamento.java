package br.cefetmg.biosit.dto;

/**
 *
 * @author aluno
 */

import java.util.Date;
    public class Medicamento  {
        private String fornecedora;
        private String nome;
        private Date dataValidade;
        private int lote;
        private int quantRestante;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
        
    public String getFornecedora() {
        return fornecedora;
    }

    public void setFornecedora(String fornecedora) {
        this.fornecedora = fornecedora;
    }

    public Date getData() {
        return dataValidade;
    }

    public void setData(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getQuantRestante() {
        return quantRestante;
    }

    public void setQuantRestante(int quantRestante) {
        this.quantRestante = quantRestante;
    }
        
    public Medicamento (String nome, String data, int quant, String fornecedora, int lote) {

    }

    
}

