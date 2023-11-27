
package br.cefetmg.biosit.dto;

/**
 *
 * @author Pedro Gabriel
 */
public class Profissional {
   private String nome;
   private String nascimento;
   private String cpf;
   private String id;
   private String email;
   private String cargo;
   private String registro;
   private double salario;

    public Profissional(String cargo) {
        this.cargo = cargo;
    }
    
    public boolean equals(Profissional profissional) {
        return cpf.equals(profissional.getCpf());
    }

    public String getCargo() {
        return cargo;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }
    public String getNascimento() {
        return nascimento;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }
    public String getRegistro() {
        return registro;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }
   
}
