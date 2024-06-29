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
@WebServlet(name = "patientupdate", urlPatterns = {"/patientupdate"})
public class PatientUpdate extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        String pid=request.getParameter("patient_id");
        String fn= request.getParameter("firstname");
        String ln= request.getParameter("lastname");
        String e= request.getParameter("email");
        String a= request.getParameter("age");
        String test = request.getParameter("tests");
        String med = request.getParameter("medicines");
        String di =request.getParameter("diagnosis");
        String st=request.getParameter("status");
        String doc_id=request.getParameter("userid");
        String sym=request.getParameter("symptoms");
        Patient cp=PatientTable.loadPatient(pid);
        if(cp.patient_id!=null){
        PatientTable.updatePatient(pid,fn,ln,a,di,med,test,e,st,sym,doc_id);
        }
        else{
        PatientTable.insertPatient(pid, fn, ln, a, di, med, test, e, st, sym, doc_id);
        }
        PatientTable.updateAppoinment(pid, st);
        Patient p= PatientTable.loadPatient(pid);
        if(p.status.equalsIgnoreCase(st)){
            out.println("<h2 align=\"center\">Patient Update Successful! Please Login Again</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.forward(request, response);
        }else{
            out.println("<h2 align=\"center\">Something went wrong. Please try agian!</h2>");
            //out.println(em.firstname);
            RequestDispatcher rd=request.getRequestDispatcher("/SeePatient.jsp");  
            rd.include(request, response);
        }
        
    }

}
