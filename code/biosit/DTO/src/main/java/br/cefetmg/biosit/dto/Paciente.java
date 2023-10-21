
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
    //private Prontuario prontuario;
    
    public Paciente(String nome, Date dataNasc, String CPF, String endereco) {
        
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
    
}
