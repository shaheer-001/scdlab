/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajas
 */
public class userinformation extends HttpServlet {

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
           boolean check = feedback(request.getParameter("user"),request.getParameter("email"),request.getParameter("message"));
           if(check == true){
               out.println("Feedback Recieved");
           } 
           else{
               out.println("Something went wrong!");
           }
           /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet userinformation</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet userinformation at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }
public boolean feedback(String name, String email, String message){
            try{
            String driverName="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/";
            String databaseName="reg";
            String userName="root";
            String pass="";
                
        Class.forName(driverName);  // MySQL database connection
        Connection conn = DriverManager.getConnection(url+databaseName, userName, pass);    
        PreparedStatement pst = conn.prepareStatement("insert into userinfodata values(?,?,?)");
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, message);
        pst.executeUpdate();   
                System.out.println("Success");
        return true;
   }
   catch(ClassNotFoundException | SQLException e){       
       System.out.println("Something went wrong !! Please try again");  
       return false;
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
