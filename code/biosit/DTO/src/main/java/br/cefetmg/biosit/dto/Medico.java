
package br.cefetmg.biosit.dto;

/**
 *
 * @author Pedro Gabriel
 */
public class Medico extends Profissional {
    
    public Medico() {
        super("medico");
    }
    
    public String getRegistro() {
        return super.getRegistro();
    }
    
    public void setRegistro(String registro) {
        super.setRegistro(registro);
    }
}
