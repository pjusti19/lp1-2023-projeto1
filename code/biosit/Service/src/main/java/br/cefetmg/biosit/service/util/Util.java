/**
 * Classe utilitária
 */
package br.cefetmg.biosit.service.util;

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
    
}
