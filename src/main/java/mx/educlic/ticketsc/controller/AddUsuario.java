/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.educlic.ticketsc.dao.UserDAO;
import mx.educlic.ticketsc.vo.Usuario;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Leo
 */
@WebServlet(name = "AddUsuario", urlPatterns = {"/AddUsuario"})
public class AddUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*Usuario usuario = new Usuario();
            usuario.setId(Long.valueOf(9));
            usuario.setContrasena("lkjfasf");
            usuario.setTipo("lkjfasf");
            usuario.setNombre("lkjfasf");
            usuario.setApellido("lkjfasf");
            UserDAO.addUsuario(usuario);
            out.print("Exito");*/
            FileInputStream file = new FileInputStream(new File("C:/Users/Leo/Documents/NetBeansProjects/TicketsC/excel.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numfilas = sheet.getLastRowNum();
            Usuario usuario = new Usuario();
            for(int a=0; a<=numfilas;a++){
            
                XSSFRow fila = sheet.getRow(a+1);
                XSSFCell celda0 = fila.getCell(0);
                XSSFCell celda1 = fila.getCell(1);
                XSSFCell celda2 = fila.getCell(2);
                XSSFCell celda3 = fila.getCell(3);
                XSSFCell celda4 = fila.getCell(4);
                usuario.setId((new Double(celda0.getNumericCellValue())).longValue());
                usuario.setContrasena(celda1.getStringCellValue());
                usuario.setTipo(celda2.getStringCellValue());
                usuario.setNombre(celda3.getStringCellValue());
                usuario.setApellido(celda4.getStringCellValue());
                UserDAO.addUsuario(usuario);
                
                
            }
            //out.print("Exito");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
