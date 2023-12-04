
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
   private String especialidade;
   private String rg;
   private String dataAdmissao;
   private String instituicao;
   private String anoGrad;
   private String tel;

    public Profissional(String cargo) {
        this.cargo = cargo;
        this.registro = "";
        this.salario = 0;
        this.especialidade = "";
        this.rg = "";
        this.instituicao = "";
        this.anoGrad = "";
        this.tel = "";
    }
    
    public boolean equals(Profissional profissional) {
        return cpf.equals(profissional.getCpf());
    }

    public String viewCargo() {
        switch (cargo) {
            case "medico":
                return "Médico";
            case "secretario":
                return "Secretário";
            case "gerente":
                return "Gerente";
        }
        return Character.toUpperCase(cargo.charAt(0)) + cargo.substring(1);
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
    public String getEspecialidade() {
        return especialidade;
    }
    public String getRG() {
        return rg;
    }
    public String getAdmissao() {
        return dataAdmissao;
    }
    public String getInstituicao() {
        return instituicao;
    }
    public String getAnoGrad() {
        return anoGrad;
    }
    public String getTel(){
        return tel;
    }

    public void setCargo(String cargo) {
        if (cargo == null) return;
        this.cargo = cargo;
    }
    public void setCpf(String cpf) {
        if (cpf == null) return;
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        if (email == null) return;
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNascimento(String nascimento) {
        if (nascimento == null) return;
        this.nascimento = nascimento;
    }
    public void setNome(String nome) {
        if (nome == null) return;
        this.nome = nome;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setRegistro(String registro) {
        if (registro == null) return;
        this.registro = registro;
    }
    public void setEspecialidade(String especialidade) {
        if (especialidade == null) return;
        this.especialidade = especialidade;
    }
    public void setRG(String rg) {
        if (rg == null) return;
        this.rg = rg;
    }
    public void setAdmissao(String data) {
        if (data == null) return;
        this.dataAdmissao = data;
    }
    public void setInstituicao(String instituicao) {
        if (instituicao == null) return;
        this.instituicao = instituicao;
    }
    public void setAnoGrad(String anoGrad) {
        if (anoGrad == null) return;
        this.anoGrad = anoGrad;
    }
    public void setTel(String tel) {
        if (tel == null) return;
        this.tel = tel;
    }
    
}
