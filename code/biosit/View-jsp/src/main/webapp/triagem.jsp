<%-- 
   Document   : triagem
   Created on : 16 de out. de 2023, 15:18:46
   Author     : Aluno
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" href="estilos/triagem.css">
      <title>Triagem</title>
      <link rel="stylesheet" href="estilos/mae.css">
      <style>
         .cadastro  {
         margin-left: 450px;
         margin-right: 450px;
         }
         .cadastro h3 {
         margin-left: 90px;
         font-size: 30px;
         }
         .cadastro button {
         width: 320px;}
         .cadastro form {
         margin-left: 85px;
         }
         input {
         width: 310px;}
         textarea {
         resize: none;
         }
         label {
         margin-bottom: 0; /* Remove a margem na parte inferior da label */
         }
         .dropdown {
         position: relative;
         display: inline-block;
         }
         .dropbtn {
         background-color: #f9f9f9;
         padding: 10px 20px;
         font-size: 16px;
         border: none;
         cursor: pointer;
         }
         .dropdown-content {
         display: none;
         position: absolute;
         background-color: #f9f9f9;
         min-width: 160px;
         box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
         z-index: 1;
         }
         .dropdown-content img {
         width: 15px; /* ou qualquer outra unidade que você preferir */
         height: 15px;
         }
         .dropdown-content a {
         padding: 5px 10px;
         text-decoration: none;
         font-size: 20px;
         display: block;
         }
         .dropdown-content a:hover {
         background-color: #f1f1f1;
         }
         .dropdown:hover .dropdown-content {
         display: block;
         }
      </style>
   </head>
   <body>
      <%@include file="header.jsp" %>
      <div class="cinza" style="background-color: rgb(209, 209, 209);">
         <div class="cadastro" style="display: flex;">
            <div class= "div-cadastro" style="flex: 1; padding: 20px; background-color: white; margin: 2%; align-items: center;">
               <form action="Facade" method="GET" >
                  <h3>Triagem</h3>
                  <label id="paciente-triagem">Paciente:</label><br>
                  <input type="text" id="paciente" name="nome" required><br>
                  <label id="sintomas-triagem">Sintomas:</label><br>
                  <textarea id="sintomas" name="sintomas" rows="4" cols="40" required></textarea>
                  <label for="sintomas" style="display: block;"id="urgencia-triagem">Urgência:</label>
                  <div class="dropdown">
                     <button class="dropbtn">Selecionar</button>
                     <div class="dropdown-content">
                        <a href="#" onclick="selecionarOpcao('Leve')"> <img src="imgs/leve.png"> Leve </a>
                        <a href="#" onclick="selecionarOpcao('Moderado')"> <img src="imgs/moderado.png"> Moderado </a>
                        <a href="#" onclick="selecionarOpcao('Grave')"> <img src="imgs/grave.png"> Grave </a>
                     </div>
                  </div>
                  <br>
                  <br>
                  <button type="button" id="confirmar">Confirmar</button>
               </form>
            </div>
         </div>
      </div>
      <script src="scripts/triagem.js"></script>
   </body>
</html>
