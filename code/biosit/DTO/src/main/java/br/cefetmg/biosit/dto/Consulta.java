package br.cefetmg.biosit.dto;

/**
 *
 * @author pjusti19
 */
public class Consulta {
    private String medico;
    private String descricao;
    private String dataHora;
    private String nomePaciente;
    private String urgencia;
    
    public Consulta(String medico, String descricao, String dataHora, String nomePaciente, String urgencia){
        this.medico = medico;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.nomePaciente = nomePaciente;
        this.urgencia = urgencia;
}

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }
    
    
}

     