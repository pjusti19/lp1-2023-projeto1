package br.cefetmg.biosit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/DownloadExcelServlet")
public class BaixarRelatorio extends HttpServlet {

    static String execute(HttpServletRequest request, HttpServletRequest response) {
       // Configurar a resposta para um tipo de conteúdo de Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        request.setHeader("Content-Disposition", "attachment; filename=exemplo.xlsx");

        // Criar uma nova pasta de trabalho do Excel
        try (Workbook workbook = new XSSFWorkbook(); OutputStream outputStream = response.getOutputStream()) {
            // Criar uma planilha e adicionar algumas informações
            Sheet sheet = workbook.createSheet("ExemploSheet");
            Row headerRow = sheet.createRow(0);

            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("Nome");

            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Idade");

            Row dataRow = sheet.createRow(1);

            Cell dataCell1 = dataRow.createCell(0);
            dataCell1.setCellValue("Exemplo");

            Cell dataCell2 = dataRow.createCell(1);
            dataCell2.setCellValue(25);

            // Escrever a pasta de trabalho no fluxo de saída
            workbook.write(outputStream);
        }
        return "financeiro.jsp";
    }
 } 