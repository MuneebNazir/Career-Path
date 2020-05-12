/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet.*;
import java.sql.*;
import static javax.management.Query.value;


/**
 *
 * @author Muneeb
 */
public class Register extends HttpServlet {

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

           
            String type= request.getParameter("reg_as");
            String name= request.getParameter("user_name");
            String email= request.getParameter("email");
            String password= request.getParameter("pass");
            String passConfirm= request.getParameter("pass_confirm");
            
            
            out.println(name);
            out.println(email);
            out.println(password);
            out.println(passConfirm);
            out.println(type);
            
            //connection code......
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                String conn="jdbc:sqlserver://localhost:1433;databaseName=CareerCounsellingSystem";
                
                Connection con= DriverManager.getConnection(conn, "new_user", "123");
                
                //query
                
                String q="INSERT INTO [Profile] (userName, email, [password], userType) values(?,?,?,?)";
                
                PreparedStatement pstmt=con.prepareStatement(q);
                
                pstmt.setString(1,name);
                pstmt.setString(2,email);
                pstmt.setString(3,password);
                pstmt.setString(4,type);
                
                pstmt.executeUpdate();
                
                if(type=="student"){
                response.sendRedirect("http://localhost:9494/TestProject/Studenthome.jsp");
                }
                out.println("Done");
                
                response.sendRedirect("http://localhost:9494/TestProject/");
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
                out.println("error");
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
