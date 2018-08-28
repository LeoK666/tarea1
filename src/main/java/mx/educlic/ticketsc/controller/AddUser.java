/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.educlic.ticketsc.dao.safeDAO;
import mx.educlic.ticketsc.vo.User;

/**
 *
 * @author Leo
 */
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class AddUser extends HttpServlet {

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
          SimpleDateFormat format= new SimpleDateFormat ("dd-MM-yyyy");
            try {
                java.util.Date date = format.parse(request.getParameter("date"));
          
          String name = request.getParameter("name");
          String firstname = request.getParameter("firstname");
          String secondname = request.getParameter("secondtname");
          Long birthTown = Long.parseLong(request.getParameter("birthTown"));
          String bloodFactor = request.getParameter("bloodFactor");
          String gender = request.getParameter("gender");
          String curp = request.getParameter("curp");
          Byte status = Byte.parseByte(request.getParameter("status"));
          java.sql.Date date1 = new java.sql.Date(date.getTime());
          User user = new User();
          user.setBirthDate(date1);
          user.setBirthTown(birthTown);
          user.setBloodFactor(bloodFactor);
          user.setCurp(curp);
          user.setFirstName(firstname);
          user.setGender(gender);
          user.setName(name);
          user.setSecondName(secondname);
          user.setStatus(status);
          safeDAO.addUser(user);
          out.print("Exito");
            } catch (ParseException ex) {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            }
          
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
