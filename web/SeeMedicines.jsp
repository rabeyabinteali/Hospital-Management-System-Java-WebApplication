<%-- 
    Document   : See Patient
    Created on : Nov 3, 2022, 4:01:40 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Database.*"%>
<%@page import= "java.util.*"%>
<%@page import = "java.time.*"%>
<%@page import = "java.time.format.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See Medicines Form</title>
        <style>
            table{
                border-collapse: collapse;
                width:30%;
            }
            th,td{
                padding:8px;
                text-align:center;
                border-bottom:1px solid #ddd;
            }
            tr:nth-child(even){
                background-color: #bcf6fa;
            }
            tr:nth-child(odd){
                background-color: #c5cbff;
            }
       </style>
    </head>
    <body>
        <%
        String id= request.getParameter("id");
        MedicineInfo p= PatientTable.loadMedicineInfo(id);
        if(p.meds_given!=null){
        %>
        <form action="medicineupdate" method="post">
                <table align="center">
                    <tr align='right'>
                    <td><label for="name">Your UserID:  </label></td>
                    <td><input type="text" name="userid" ></td>
                </tr>
                 <tr align='right'>
                    <td><label for="name">Patient ID: </label></td>
                    <td><input type="text" name="patient_id" value= <%=p.patient_id%>  ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">First Name: </label></td>
                    <td><input type="text" name="firstname" value= <%=p.firstname%> ></td>
                </tr>
               <tr align='right'>
                    <td><label for="name">Last Name: </label></td>
                    <td><input type="text" name="lastname" value= <%=p.lastname%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Medicines Given: </label></td>
                    <td><input type="text" name="meds_given" value= <%=p.meds_given%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Medicines Not Given: </label></td>
                    <td><input type="text" name="meds_not_given" value= <%=p.meds_not_given%> ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">Medicines Assigned: </label></td>
                    <td><input type="text" name="meds_assigned" value= <%=p.meds_assigned%> ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Update"></div>
            </form>
                    <%
                        }else{
                        Patient ap=PatientTable.loadPatient(id);
                        %>
            <form action="medicineupdate" method="post">
                <table align="center">
                    <tr align='right'>
                    <td><label for="name">Your UserID:  </label></td>
                    <td><input type="text" name="userid" ></td>
                </tr>
                 <tr align='right'>
                    <td><label for="name">Patient ID: </label></td>
                    <td><input type="text" name="patient_id" value= <%=ap.patient_id%>  ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">First Name: </label></td>
                    <td><input type="text" name="firstname" value= <%=ap.firstname%> ></td>
                </tr>
               <tr align='right'>
                    <td><label for="name">Last Name: </label></td>
                    <td><input type="text" name="lastname" value= <%=ap.lastname%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Medicines Given: </label></td>
                    <td><input type="text" name="meds_given" value= <%=p.meds_given%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Medicines Not Given: </label></td>
                    <td><input type="text" name="meds_not_given" value= <%=p.meds_not_given%> ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">Medicines Assigned: </label></td>
                    <td><input type="text" name="meds_assigned" value= <%=ap.medicines%> ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Update"></div>
            </form>
                    <% 
                    
                        }
                    %>
    </body>
</html>
