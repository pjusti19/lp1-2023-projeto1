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
    
    public static boolean verify(Equipamento equipamento) {
        return Util.verify(equipamento.getNome()) && Util.verify(equipamento.getData()) && Util.verify(equipamento.getFornecedora()) && Util.verify(equipamento.getSetor());
    }
    
    public static String converter(String dataInicial) {
        DateTimeFormatter formatoInicial = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data = LocalDate.parse(dataInicial, formatoInicial);
        return data.format(formatoSaida);
    }
}
