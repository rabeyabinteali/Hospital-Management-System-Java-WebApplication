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
/**
 *
 * @author user
 */
@WebServlet(name = "registration", urlPatterns = {"/register"})
public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        String fn= request.getParameter("firstname");
        String ln= request.getParameter("lastname");
        String e= request.getParameter("email");
        String a= request.getParameter("address");
        String id = request.getParameter("userid");
        String pass = request.getParameter("password");
        String pro =request.getParameter("profession");
        //if(pro.equalsIgnoreCase("doctor")||pro.equalsIgnoreCase("nurse")||pro.equalsIgnoreCase("janitor")||pro.equalsIgnoreCase("technician")){
        Employee em= new Employee(fn,ln,e,id,pass,"Serving",a,pro);
        EmployeeTable.addEmployee(em);
        //}
        LoginInfo li= LoadingInformation.loadEmployeeLoginInfo(id);
        if(li.profession.equalsIgnoreCase(pro)){
            out.println("<h2 align=\"center\">Registrattion Successful!</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.forward(request, response);
        }else{
            out.println("<h2 align=\"center\">Something went wrong. Please try agian!</h2>");
            //out.println(em.firstname);
            RequestDispatcher rd=request.getRequestDispatcher("/Registrationpage.jsp");  
            rd.include(request, response);
        }
        
    }
}
