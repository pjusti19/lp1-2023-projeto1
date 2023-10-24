
package br.cefetmg.biosit.dto;


import java.util.Date;



/**
 *
 * @author Pedro Gabriel
 */
public class Paciente {
    private String id;
    private String nome;
    private Date dataNasc;
    private String CPF;
    private String endereco;
    //private Prontuario prontuario;
    
    public Paciente(String nome, Date dataNasc, String CPF, String endereco) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.CPF = CPF;
        this.endereco = endereco;
    }
    public String getID() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public Date getNascimento() {
        return dataNasc;
    }
    public String getEndereco() {
        return endereco;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNascimento(Date dataNasc) {
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
