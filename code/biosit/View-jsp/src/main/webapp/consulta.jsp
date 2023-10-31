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
                    <label id="nome-medico">Médico:<br>
                        <input type="text" name="nome" maxlength="50">
                    </label>
                    <label id="especialidade">Especialidade:<br>
                        <input type="text" name="especialidade" maxlength="50">
                    </label>
                    <label id="consultorio">Consultório:<br>
                        <input type="text" name="consultorio">
                    </label>
                    <label id="nome-paciente">Paciente:<br>
                        <input type="text" name="data-nascimento">
                    </label>
                    <label id="data-hora">Data e hora:<br>
                        <input type="text" name="data-hora" maxlength="50">
                    </label>
                 
                    <button id="envia-consulta" type="submit" value="agendarConsulta">Agendar</button>
                    
                    
              
                    