package dto;

/**
 *
 * @author aluno
 */

import java.util.Date;
    public class estoque  {
        private String fornecedora;
        private String nome;
        private Date data;
        private String setor;
        private int quant;
        private Paciente teste;

    public Paciente metodoFoda() {
        teste = new Paciente("1", "Sla", new Date(), "");
        return teste;
    }
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
        
        public estoque (String fornecedora, String nome, Date data, String setor, int quant) {

        }

        

        public String getNome() {
            return nome;
        }
    
}

