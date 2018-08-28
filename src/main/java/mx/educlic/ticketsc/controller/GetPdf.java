/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "GetPdf", urlPatterns = {"/GetPdf"})
public class GetPdf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     extension ttf
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. 
            ingresar diferentes fuentes externas con extension ttf*/
            //String arial_path = request.getServletContext().getRealPath("")+"/font/arial.ttf";
            //BaseFont arial_bf = BaseFont.createFont(arial_path,BaseFont.CP1252,BaseFont.EMBEDDED);
            //Font font1 = new Font(arial_bf,8,Font.BOLD);
            //Font font2 = new Font(arial_bf,12,Font.BOLD);
            String city_path = request.getServletContext().getRealPath("") + "/font/city.ttf";
            BaseFont city_bf = BaseFont.createFont(city_path,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font font1 = new Font(city_bf,16);
            String comicate_path = request.getServletContext().getRealPath("") + "/font/comicate.ttf";
            BaseFont comicate_bf = BaseFont.createFont(comicate_path,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font font2 = new Font(comicate_bf,16);
            String sixty_path = request.getServletContext().getRealPath("") + "/font/sixty.ttf";
            BaseFont sixty_bf = BaseFont.createFont(sixty_path,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font font3 = new Font(sixty_bf,16);
            String stocky_path = request.getServletContext().getRealPath("") + "/font/stocky.ttf";
            BaseFont stocky_bf = BaseFont.createFont(stocky_path,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font font4 = new Font(stocky_bf,16);
            //especifica el tamaño del pdf, en este caso de milimetros
            Rectangle page = new Rectangle(Utilities.millimetersToPoints(54),Utilities.millimetersToPoints(20));
            //crea un documento pdf con el tamaño de page y se colocan los margenes sup,inf,izquierda,derecha
            Document doc = new Document(page,0,0,0,0);
            //crea el documento en pdf con tamaño carta  sup,inf,izquierda,derecha
            Document doc1 = new Document(PageSize.LETTER,50,10,10,20);
            //se encarga de mandar a imprimir a la pantalla lo que tenemos
            PdfWriter writer = PdfWriter.getInstance(doc,response.getOutputStream());
            PdfWriter writer1 = PdfWriter.getInstance(doc1,response.getOutputStream());
            //trabajo con parrafos
            //doc.open();
            //Paragraph p1= new Paragraph("hola mundo");
            //doc.add(p1);
            //doc.close();
            //trabajo con tablas
            doc1.open();
            PdfPTable container = new PdfPTable(4);
            PdfPCell cell = new PdfPCell (new Paragraph ("Parrafo con fuente city",font1));
            //multiplos de cuatro ya que tiene cuatro columnas
            container.addCell(cell);
            container.addCell(cell);
            container.addCell(cell);
            container.addCell(cell);
            PdfPCell cell1 = new PdfPCell (new Paragraph ("Parrafo con fuente comicate",font2));
            //multiplos de cuatro ya que tiene cuatro columnas
            container.addCell(cell1);
            container.addCell(cell1);
            container.addCell(cell1);
            container.addCell(cell1);
           // doc1.add(container);
            PdfPCell cell2 = new PdfPCell (new Paragraph ("Parrafo con fuente sixty",font3));
            //multiplos de cuatro ya que tiene cuatro columnas
            container.addCell(cell2);
            container.addCell(cell2);
            container.addCell(cell2);
            container.addCell(cell2);
            //doc1.add(container);
            PdfPCell cell3 = new PdfPCell (new Paragraph ("Parrafo con fuente stocky",font4));
            //multiplos de cuatro ya que tiene cuatro columnas
            container.addCell(cell3);
            container.addCell(cell3);
            container.addCell(cell3);
            container.addCell(cell3);
            doc1.add(container);
            doc1.close();
            
        } catch (DocumentException ex) {
            Logger.getLogger(GetPdf.class.getName()).log(Level.SEVERE, null, ex);
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
