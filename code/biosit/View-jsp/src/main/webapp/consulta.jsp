<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de paciente</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/consulta.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="consulta">
            <section class="agendamento">
              <form action="Facade" method="GET"> 
                    <h3>AGENDAR CONSULTA</h3>
                    <label id="nome-paciente">Paciente:<br>
                        <select name="nomePaciente" maxlength="100">
                        <% ArrayList<Paciente> pacientes = (ArrayList<Medico>) request.getAttribute("pacientes");
                            for (Paciente paciente: pacientes){ %>
                            <option value='<%=paciente.getNome()%>' name="nomePaciente"><%=paciente.getNome()%></option>
                            <% } %>
                        </select>
                    </label>
                    <label id="descricao">Descrição:<br>
                        <input type="text" name="descricao" maxlength="200">
                    </label>
                    <label id="urgencia">Urgência:<br>
                        <select name="urgencia">
                            <option value="leve" id="leve">leve</option>
                            <option value="média" id="media">média</option>
                            <option value="grave" id="grave">grave</option>
                        </select>
                    </label
                    <label id="nome-medico">Médico:<br>
                        <select name="medico" maxlength="100">
                            <% ArrayList<Medico> medicos = (ArrayList<Medico>) request.getAttribute("medicos");
                            for (Medico medico: medicos){ %>
                            <option value='<%=medico.getNome()%>'><%=medico.getNome()%></option>
                            <% } %>
                        </select>
                    </label> 
                    <label id="data">Data:<br>
                        <input type="text" name="data" maxlength="10">
                    </label>
                    <label id="hora">Horário:<br>
                        <input type="text" name="horario" maxlength="10">
                    </label>
                    <button id="enviaConsulta" type="submit" name="act" value="cadastrarConsulta">Agendar</button>
                    <%
                    String error2 = (String) request.getAttribute("error");
                    String tperror2 = (String) request.getAttribute("tperror");
                    if (error2 != null && !error2.isEmpty() && tperror2.equals("cadastrarConsulta")) {
                    %>
                    <div class="mensagem-erro">
                        <%= error2 %>
                    </div>
                    <%
                    } else {
                        String sucess = (String) request.getAttribute("sucess");
                        if(sucess != null && !sucess.isEmpty()) {
                    %>
                    <div class="mensagem-sucesso">
                        <%= sucess %>
                    </div>
                    <%
                        } }
                    %>
              </form>
            </section>
                    
              
                    