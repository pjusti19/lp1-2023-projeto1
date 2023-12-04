<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de paciente</title>
    <link rel="stylesheet" href="estilos/mae.css">
    <link rel="stylesheet" href="estilos/consulta.css">
    <%@ page import="br.cefetmg.biosit.dto.*" %>
    <%@ page import="java.util.ArrayList" %>
</head>
<body>
    <%@include file="header.jsp" %>
    <main id="consulta">
        <section class="agendamento">
            <form action="Facade" method="GET"> 
                <h3>AGENDAR CONSULTA</h3>
                <label id="nome-paciente">Paciente:<br>
                    <select name="nomePaciente" maxlength="100">
                        <% 
                        ArrayList<Paciente> pacientes = (ArrayList<Paciente>) request.getAttribute("pacientes");
                        if (pacientes != null) {
                            for (Paciente paciente: pacientes) { %>
                                <option value='<%=paciente.getNome()%>' name="nomePaciente"><%=paciente.getNome()%></option>
                            <% }
                        } %>
                    </select>
                </label>
                <label id="descricao">Descrição:<br>
                    <input type="text" name="descricao" maxlength="200">
                </label>
                <label id="urgencia">Urgência:<br>
                    <select name="urgencia">
                        <option value="leve" id="leve">Leve</option>
                        <option value="média" id="media">Média</option>
                        <option value="grave" id="grave">Grave</option>
                    </select>
                </label>
                <label id="nome-medico">Médico:<br>
                    <select name="medico" maxlength="100">
                        <% 
                        ArrayList<Profissional> profissionais = (ArrayList<Profissional>) request.getAttribute("profissionais");
                        if (profissionais != null) {
                            for (Profissional profissional: profissionais) { %>
                                <option value='<%=profissional.getNome()%>'><%=profissional.getNome()%></option>
                            <% }
                        } %>
                    </select>
                </label> 
                <label id="data">Data:<br>
                    <input type="date" name="data" maxlength="10">
                </label>
                <label id="hora">Horário:<br>
                    <input type="text" name="horario" maxlength="10">
                </label>
                <button id="enviaConsulta" type="submit" name="act" value="cadastrarConsulta">Agendar</button>
                <% 
                String error2 = (String) request.getAttribute("error");
                String tperror2 = (String) request.getAttribute("tperror");
                if (error2 != null && !error2.isEmpty() && tperror2.equals("cadastrarConsulta")) { %>
                    <div class="mensagem-erro">
                        <%= error2 %>
                    </div>
                <% } else {
                    String success = (String) request.getAttribute("success");
                    if (success != null && !success.isEmpty()) { %>
                        <div class="mensagem-sucesso">
                            <%= success %>
                        </div>
                <% }
                } %>
            </form>
        </section>
    </main>
</body>
</html>
