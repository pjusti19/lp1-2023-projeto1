package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author David Eller
 */
public class BaixarRelatorio {

    public static String execute(HttpServletRequest request) {
        String jsp = "/financeiro.jsp";
        
        return jsp;
    }
}
