
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
    private Prontuario prontuario;
    
    public Paciente(String id, String nome, Date dataNasc, String CPF) {
        
    }
    
    public String getID() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
}
