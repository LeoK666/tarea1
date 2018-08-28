/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.controller;

import com.itextpdf.text.DocumentException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "GetExcel", urlPatterns = {"/GetExcel"})
public class GetExcel extends HttpServlet {

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
        response.setContentType("application/und.openxmlformat-officedocument.spreadsheetml.sheet;charset=UTF-8");
        response.setHeader("Content-Disposition","attachment; filename= Libro.xlsx");
        try {
            /* TODO output your page here. You may use following sample code. */
            OutputStream out= response.getOutputStream();
            //se crea un libro para trabajar
            XSSFWorkbook workbook = new XSSFWorkbook();
            //creando una pagina de excel
            XSSFSheet sheet = workbook.createSheet("listas");
            //tamaño de la columna
            //sheet.setColumnWidth(0, 800);
            //crear filas, entre parentesis se coloca la posicion 
            //XSSFRow row = sheet.createRow(0);
            //crear celdas, entre parentesis
            //XSSFCell cell = row.createCell(0);
            //Ingresar valor a la celdda
            //cell.setCellValue("Hola");
            String[] titulos = {"ID", "Contraseña","Tipo", "Nombre", "Apellido" };       
            // Creamos una fila en la hoja en la posicion 0
            XSSFRow fila = sheet.createRow(0);
            // Creamos el encabezado
            for(int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion 
            // indicada por el contador del ciclo
            XSSFCell celda = fila.createCell(i);
            // Indicamos el estilo que deseamos 
            // usar en la celda, en este caso el unico 
            // que hemos creado 
            celda.setCellValue(titulos[i]);
            }

            java.util.List<Usuario> list = UserDAO.getUsuarios("select * from usuarios");
            for(int i=1; i<=list.size();i++)
            {
                sheet.autoSizeColumn(i);
                XSSFRow row= sheet.createRow(i);
                XSSFCell celda = row.createCell(0);
                celda.setCellValue(list.get(i-1).getId());
                XSSFCell celda1 = row.createCell(1);
                celda1.setCellValue(list.get(i-1).getContrasena());
                XSSFCell celda2 = row.createCell(2);
                celda2.setCellValue(list.get(i-1).getTipo());
                XSSFCell celda3 = row.createCell(3);
                celda3.setCellValue(list.get(i-1).getNombre());
                XSSFCell celda4 = row.createCell(4);
                celda4.setCellValue(list.get(i-1).getApellido());
                
                
            }
            // Y colocamos los datos en esa fila
            
            
            
            //ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            workbook.write(out);
            
            /*int i;
            for(i=0;i<list.size();i++)
            {
            
            out.print("<h1> ID: " + String.valueOf(list.get(i).getId()) + "</h1>");
            out.println("<h1> Tipo: " + list.get(i).getTipo() + "</h1>");
            out.println("<h1> Nombre: " + list.get(i).getNombre()+ "</h1>");
            out.println("<h1> ApellidoP: " + list.get(i).getApellido() + "</h1>");
            out.println("<h1> ApellidoM: " + list.get(i).getContrasena()+ "</h1>");
            
            out.println("<h1>---------------------------------------------------- </h1>");
            
        }*/
        }
        catch (IOException ex) {
            Logger.getLogger(GetExcel.class.getName()).log(Level.SEVERE, null, ex);
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
