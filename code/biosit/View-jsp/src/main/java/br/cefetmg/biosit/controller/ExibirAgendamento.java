package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.service.implement.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;

public class ExibirAgendamento {

    public static String execute(HttpServletRequest request) {

        String jsp = "/consulta.jsp";

        try {
            List<Medico> medicos = new ArrayList<>();
            List<Paciente> pacientes = new ArrayList<Paciente>();

            Paciente paciente = new Paciente(null, null, null, null);
            // Medico medico = new Medico(null, null, null, null);
            ManterPaciente manterPaciente = new ManterPaciente();
            pacientes = manterPaciente.pesquisar(paciente);
            // ManterMedico manterMedico = new ManterMedico());
            // medicos = manterMedico.pesquisar(medico);
            request.setAttribute("pacientes", pacientes);
            request.setAttribute("medicos", medicos);

        } catch (Exception e) {
            request.setAttribute("tperror", "buscarConsulta");
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }

        return jsp;
    }
}
