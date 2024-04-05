/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;
import jakarta.servlet.RequestDispatcher;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class LoginServlet extends HttpServlet {

    
   
  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepprointerviewreadiness","root","root");
            String sql ="SELECT username,password FROM user WHERE username=?";
            PreparedStatement ps =connection.prepareStatement(sql);
           ps.setString(1,username);
         ResultSet rs = ps.executeQuery();
          String validUser = rs.getString("üsername");
           String validPassword = rs.getString("password");
           ps.close();
           if(password.equals(validPassword)){
               RequestDispatcher disp = request.getRequestDispatcher("menu.jsp");
               disp.forward(request, response);
           }else{
               String invalid = "invalid username or password";
               session.setAttribute("invalid", invalid);
                RequestDispatcher disp = request.getRequestDispatcher("invalid.jsp");
               disp.forward(request, response);

               
           }
          
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
