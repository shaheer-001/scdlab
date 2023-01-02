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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajas
 */
public class Validation extends HttpServlet {

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
           boolean bool = login(request.getParameter("username"),request.getParameter("password"));
           if(bool == true){
               out.println("Login Success");
           }
           else{
                out.println("Login Failure");
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
public boolean login(String username, String password){
              try{
            String driverName="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/";
            String databaseName="reg";
            String userName="root";
            String pass="";
                
        Class.forName(driverName);  // MySQL database connection
        Connection conn = DriverManager.getConnection(url+databaseName, userName, pass);    
        PreparedStatement pst = conn.prepareStatement("Select username,Password from customer where username=? and Password=?");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next())           
        {
            System.out.println("Valid login credentials");
            return true;
        }
        else{
           System.out.println("Invalid login credentials"); 
        }        
   }
   catch(Exception e){       
       System.out.println("Something went wrong !! Please try again");       
   }    
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Validation</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Validation at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
return false;
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
