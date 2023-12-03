<%-- 
    Document   : profissional
    Created on : 3 de dez. de 2023, 02:53:44
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profissional</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <link rel="stylesheet" href="estilos/profissional.css">
        <%@ page import="br.cefetmg.biosit.dto.*" %>
        <%@ page import="java.util.ArrayList" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main>
            <%  
                Profissional pro = (Profissional) request.getAttribute("profissional");
                if(pro == null) {System.out.println("deu erro");}
            %> <%= pro.getNome() %> <%=pro.viewCargo() %> <%= pro.getCpf() %>
        </main>
    </body>
</html>
