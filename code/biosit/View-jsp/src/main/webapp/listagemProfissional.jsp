<%-- 
    Document   : listagemProfissional
    Created on : 2 de dez. de 2023, 15:21:31
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <%@ page import="br.cefetmg.biosit.dto.Profissional" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% 
            ArrayList<Profissional> lista = (ArrayList<Profissional>) request.getAttribute("profissionais");
            if(lista == null) {
        %>  Erro
        <%
            } else if(lista.size() == 0) {
        %> Nenhum profissional encontrado
        <% 
            } else {
            for(Profissional pro : lista) {
        %> <%= pro.getNome() %>
        <% }} %>
    </body>
</html>
