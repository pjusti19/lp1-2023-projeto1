
package br.cefetmg.biosit.dto;

public class Exame {
    private String exame;
    private String paciente;
    private String dataHora;
    
    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    public Exame (String exame, String paciente, String dataHora){
        
    }
}
