
package br.cefetmg.biosit.dto;


import java.util.Date;



/**
 *
 * @author Pedro Gabriel
 */
public class Paciente {
    private String nome;
    private String dataNasc;
    private String CPF;
    private String endereco;
    //private Prontuario prontuario;
    
    public Paciente(String nome, String dataNasc, String CPF, String endereco) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.CPF = CPF;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public String getNascimento() {
        return dataNasc;
    }
    public String getEndereco() {
        return endereco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNascimento(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public boolean equals(Paciente paciente) {
        return this.getCPF().equals(paciente.getCPF());
    }
}
