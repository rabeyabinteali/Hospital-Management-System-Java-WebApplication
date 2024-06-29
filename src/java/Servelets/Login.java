/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import Database.LoadingInformation;
import Database.LoginInfo;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.*;
import Database.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author user
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        String id = request.getParameter("userid");
        String password = request.getParameter("password");
        LocalDateTime dtm= LocalDateTime.now();
        LocalDate d= dtm.toLocalDate();
        LocalTime t= dtm.toLocalTime();
        LoginInfo l= LoadingInformation.loadEmployeeLoginInfo(id);
        Chart c = LoadingInformation.loadEmployeeChart(id, d.toString());
        if(id.equals(l.userid)&&password.equals(l.password)){
                RequestDispatcher rd = request.getRequestDispatcher("/home");
                rd.forward(request,response);
                if(c.userid==null){EmployeeTable.updateChartEntry(id);}
            }
        else{
            out.println("<h2 align=\"center\">Wrong Credentials. Try Again</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.include(request, response);
            }
        }
}