/**
 * Classe utilitária
 */
package br.cefetmg.biosit.service.util;

import br.cefetmg.biosit.dto.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Pedro Gabriel
 */
import java.util.Date;
public class Util {
    
    public static boolean verify(String string) {
        return (string == null || string.equals(""));
    }
    
    public static boolean verify(Date date) {
        return (date == null || date.toString().equals(""));
    }
    
    public static boolean verify(Paciente paciente) {
        return Util.verify(paciente.getCPF()) && Util.verify(paciente.getEndereco()) && Util.verify(paciente.getNome()) && Util.verify(paciente.getNascimento());
    }
    
    public static boolean verify(Profissional pro) {
        return Util.verify(pro.getCpf()) && Util.verify(pro.getCargo()) && Util.verify(pro.getEmail()) && Util.verify(pro.getNascimento()) && Util.verify(pro.getNome());
    }
    
    public static boolean verify(Equipamento equipamento) {
        return Util.verify(equipamento.getNome()) && Util.verify(equipamento.getData()) && Util.verify(equipamento.getFornecedora()) && Util.verify(equipamento.getSetor());
    }
    
    public static boolean verify(Financeiro financeiro) {
        return Util.verify(financeiro.getCategoria()) && Util.verify(financeiro.getData()) && Util.verify(financeiro.getDataFinal());
    }
    
     public static boolean verify(Consulta consulta) {
        return Util.verify(consulta.getNomePaciente()) && Util.verify(consulta.getDescricao()) && Util.verify(consulta.getUrgencia())&& 
                Util.verify(consulta.getMedico()) && Util.verify(consulta.getData()) && Util.verify(consulta.getHorario());
    }
    
    public static String converter(String dataInicial) {
        DateTimeFormatter formatoInicial = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data = LocalDate.parse(dataInicial, formatoInicial);
        return data.format(formatoSaida);
    }
}
