package br.cefetmg.biosit.dto;

/**
 *
 * @author aluno
 */

import java.util.Date;
    public class Equipamento  {
        private String fornecedora;
        private String nome;
        private Date data;
        private String setor;
        private int quant;

    public String getFornecedora() {
        return fornecedora;
    }

    public void setFornecedora(String fornecedora) {
        this.fornecedora = fornecedora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
        
        public Equipamento (String nome, Date data,int quant, String fornecedora, String setor) {

        }

        

        public String getNome() {
            return nome;
        }
    
}

