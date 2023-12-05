package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.dto.Profissional;
import br.cefetmg.biosit.service.IAgendarConsulta;
import br.cefetmg.biosit.service.implement.AgendarConsulta;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.controller.AdicionarNotificacao;
import br.cefetmg.biosit.service.implement.ManterPaciente;
import br.cefetmg.biosit.service.implement.ManterProfissional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */

// ISSO DAQUI TA MUITO FEIO, MAS FUNCIONA!
public class CadastrarConsulta {

    public static String execute(HttpServletRequest request) {
        String jsp = "/index.jsp";

        try {
            String nomePaciente = request.getParameter("nomePaciente");
            String descricao = request.getParameter("descricao");
            String urgencia = request.getParameter("urgencia");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            String medico = request.getParameter("medico");
            Consulta consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);

            IAgendarConsulta agendarConsulta = new AgendarConsulta();
            agendarConsulta.cadastrar(consulta);
            
            AdicionarNotificacao.adicionar(consulta, request);

            List<Profissional> profissionais = new ArrayList<>();
            List<Paciente> pacientes = new ArrayList<Paciente>();
            Paciente paciente = new Paciente(null, null, null, null);

            ManterPaciente manterPaciente = new ManterPaciente();
            pacientes = manterPaciente.pesquisar(paciente);
            ManterProfissional manterProfissional = new ManterProfissional();
            profissionais = manterProfissional.pesquisarTodos();

            request.setAttribute("pacientes", pacientes);
            request.setAttribute("profissionais", profissionais);

            request.setAttribute("success", "Consulta cadastrada com sucesso");
        } catch (MedicoIndisponivelException e) {
            try {
                List<Profissional> profissionais = new ArrayList<>();
                List<Paciente> pacientes = new ArrayList<Paciente>();
                Paciente paciente = new Paciente(null, null, null, null);
                ManterPaciente manterPaciente = new ManterPaciente();
                pacientes = manterPaciente.pesquisar(paciente);
                ManterProfissional manterProfissional = new ManterProfissional();
                profissionais = manterProfissional.pesquisarTodos();
                request.setAttribute("pacientes", pacientes);
                request.setAttribute("profissionais", profissionais);

                request.setAttribute("tperror", "cadastrarConsulta");
                request.setAttribute("error", e.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (CadastroException e) {
            try {
                List<Profissional> profissionais = new ArrayList<>();
                List<Paciente> pacientes = new ArrayList<Paciente>();
                Paciente paciente = new Paciente(null, null, null, null);
                ManterPaciente manterPaciente = new ManterPaciente();
                pacientes = manterPaciente.pesquisar(paciente);
                ManterProfissional manterProfissional = new ManterProfissional();
                profissionais = manterProfissional.pesquisarTodos();
                request.setAttribute("pacientes", pacientes);
                request.setAttribute("profissionais", profissionais);

                request.setAttribute("tperror", "cadastrarConsulta");
                request.setAttribute("error", e.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            try {
                List<Profissional> profissionais = new ArrayList<>();
                List<Paciente> pacientes = new ArrayList<Paciente>();
                Paciente paciente = new Paciente(null, null, null, null);
                ManterPaciente manterPaciente = new ManterPaciente();
                pacientes = manterPaciente.pesquisar(paciente);
                ManterProfissional manterProfissional = new ManterProfissional();
                profissionais = manterProfissional.pesquisarTodos();
                request.setAttribute("pacientes", pacientes);
                request.setAttribute("profissionais", profissionais);

                request.setAttribute("tperror", "cadastrarConsulta");
                request.setAttribute("error", "Não foi possível realizar o cadastro, tente novamente");
            } catch (Exception ex) {
                Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return jsp;
    }
}

