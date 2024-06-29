/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servelets;

import Database.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "appointmentupdate", urlPatterns = {"/appointmentupdate"})
public class AppointmentUpdate extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        String pid=request.getParameter("patient_id");
        String pf= request.getParameter("pf");
        String pl= request.getParameter("pl");
        String e= request.getParameter("email");
        String df = request.getParameter("df");
        String dl = request.getParameter("dl");
        String st =request.getParameter("status");
        String did= request.getParameter("did");
        String time=request.getParameter("time");
        String date=request.getParameter("date");
        PatientTable.updateAppoinment(pid,pf,pl,df,dl,did,e,date,time,st);
        Appointment p= LoadingInformation.loadAppointment(pid);
        if(p.status.equalsIgnoreCase(st)){
            out.println("<h2 align=\"center\">Patient Update Successful! Please Login Again</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.forward(request, response);
        }else{
            out.println("<h2 align=\"center\">Something went wrong. Please try agian!</h2>");
            //out.println(em.firstname);
            RequestDispatcher rd=request.getRequestDispatcher("/SeeAppointment.jsp");  
            rd.include(request, response);
        }
        
    }

}
