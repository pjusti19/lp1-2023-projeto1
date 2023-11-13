<%-- 
   Document   : triagem
   Created on : 16 de out. de 2023, 15:18:46
   Author     : Aluno
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      
      <title>Triagem</title>
      <script>
        let sintomasSelecionados = [];

        function atualizarSintomas(sintomaCheckbox, marcado) {
            if (marcado) {
                sintomasSelecionados.push(sintomaCheckbox.value);
            } else {
                sintomasSelecionados = sintomasSelecionados.filter(item => item !== sintomaCheckbox.value);
            }

            avaliarGravidade();
        }

        function avaliarGravidade() {
            let gravidade = "Baixo";

            if (sintomasSelecionados.includes("Dor no Peito")) {
                gravidade = "Urgente";
            } else if (sintomasSelecionados.some(sintoma => moderada.includes(sintoma))) {
                gravidade = "Moderado";
            } else if (sintomasSelecionados.some(sintoma => urgente.includes(sintoma))) {
                gravidade = "Urgente";
            }

            atualizarInterface(gravidade);
        }

        function atualizarInterface(gravidade) {
            // Atualiza o conteúdo do parágrafo com a gravidade calculada
            document.getElementById("gravidade").innerHTML = "Urgência: " + gravidade;
        }
    </script>
    
    
    
      <link rel="stylesheet" href="estilos/mae.css">
      <link rel="stylesheet" href="estilos/novopacienteTriagem.css">
     
   </head>
   <body>
      <%@include file="header.jsp" %>
      <div class="cinza" style="background-color: rgb(209, 209, 209);">
         <div class="cadastro" style="display: flex;">
            <div class= "cadastrotriagem">
               <form action="Facade" method="GET" >
                  <h3>Novo Paciente</h3>
                  <label id="nome-cadastrotriagem">Paciente:</label><br>
                  <input type="text" id="nome" name="nome" required><br>
                  
                  <label id="datanasc-cadastrotriagem">Data de nascimento:</label><br>
                  <input type="date" id="datanasc" name="datanasc"><br>
                  
                  <label id="rg-cadastrotriagem">RG:</label><br>
                  <input type="number" id="rg" name="rg"><br>
                  
                  <label id="sintomas-triagem">Sintomas:</label><br>
                  <textarea id="sintomas" name="sintomas" rows="4" cols="40" required></textarea>
                  
                  <label> 
                  <input type="checkbox" value="Febre" onchange="atualizarSintomas(this, this.checked)">
                     Febre
                  </label>
                  
                  <label>
        <input type="checkbox" value="Dor no Peito" onchange="atualizarSintomas(this, this.checked)">
        Dor no Peito
    </label>
                  
                  
              
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
                  <p id="gravidade">Urgência: Baixo</p>
                  <button class="botaotriagem" type="submit" name="act" value="cadastrarTriagem">Confirmar</button>
               </form>
            </div>
         </div>
      </div>
      <script src="scripts/triagem.js"></script>
   </body>
</html>
