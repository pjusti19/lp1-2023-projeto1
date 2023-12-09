/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.dto;

/**
 *
 * @author joaop
 */
public class Internacao {
    
    private String idinter;
    private String nome;
    private String cpf;
    private String dtnasc;
    private String quarto;
    private String leito;
    private String dat_ent;
    private String motivo;
    private String historico;

     public Internacao() {
         super();

    }

    public String getIdinter() {
        return idinter;
    }

    public void setIdinter(String idinter) {
        this.idinter = idinter;
    }
     
    public Internacao(String idinter,String nome, String cpf, String dtnasc, String quarto, String leito, String dat_ent, String motivo, String historico) {
         super();
         this.idinter = idinter;
        this.nome = nome;
        this.cpf = cpf;
        this.dtnasc = dtnasc;
        this.quarto = quarto;
        this.leito = leito;
        this.dat_ent = dat_ent;
        this.motivo = motivo;
        this.historico = historico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getDat_ent() {
        return dat_ent;
    }

    public void setDat_ent(String dat_ent) {
        this.dat_ent = dat_ent;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
     
}
