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
/**
 *
 * @author user
 */
@WebServlet(name = "userhome", urlPatterns = {"/home"})
public class UserHome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        LoginInfo li= LoadingInformation.loadEmployeeLoginInfo(request.getParameter("userid"));
        if(li.profession.equalsIgnoreCase("doctor"))
        {
        RequestDispatcher rd = request.getRequestDispatcher("/UserHomeDoctor.jsp");
        rd.forward(request,response);
        }else if(li.profession.equalsIgnoreCase("nurse")){
        RequestDispatcher rd = request.getRequestDispatcher("/UserHomeNurse.jsp");
        rd.forward(request,response);
        }else if(li.profession.equalsIgnoreCase("janitor")){
        RequestDispatcher rd = request.getRequestDispatcher("/UserHomeReceiption.jsp");
        rd.forward(request,response);
        }else if(li.profession.equalsIgnoreCase("technician")){
        RequestDispatcher rd = request.getRequestDispatcher("/UserHomeTechnician.jsp");
        rd.forward(request,response);
        }
    }
}
