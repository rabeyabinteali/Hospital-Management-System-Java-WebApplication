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
@WebServlet(name = "medicineupdate", urlPatterns = {"/medicineupdate"})
public class MedicineUpdate extends HttpServlet {   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        String pid=request.getParameter("patient_id");
        String fn= request.getParameter("firstname");
        String ln= request.getParameter("lastname");
        String medg = request.getParameter("meds_given");
        String medng =request.getParameter("meds_not_given");
        String meda=request.getParameter("meds_assigned");
        MedicineInfo cp=PatientTable.loadMedicineInfo(pid);
        if(cp.firstname!=null){
        PatientTable.updateMedicineInfo(pid,fn,ln,medg,medng,meda);
        }else{
        PatientTable.createMedicineInfo(pid, fn, ln, medg, medng, meda);
        }
        MedicineInfo p= PatientTable.loadMedicineInfo(pid);
        if(p.meds_given.equalsIgnoreCase(medg)){
            out.println("<h2 align=\"center\">Patient Update Successful! Please Login Again</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
            rd.forward(request, response);
        }else{
            out.println("<h2 align=\"center\">Something went wrong. Please try agian!</h2>");
            //out.println(em.firstname);
            RequestDispatcher rd=request.getRequestDispatcher("/SeeMedicines.jsp");  
            rd.include(request, response);
        }
        
    }

}
