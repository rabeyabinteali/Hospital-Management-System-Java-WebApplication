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
        <title>See Patient Form</title>
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
        Patient p= PatientTable.loadPatient(id);
        if(p.firstname!=null){
        %>
        <form action="patientupdate" method="post">
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
                    <td><label for="name">Age: </label></td>
                    <td><input type="text" name="age" value= <%=p.age%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Email: </label></td>
                    <td><input type="text" name="email" value= <%=p.email%> ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">Symptoms: </label></td>
                    <td><input type="text" name="symptoms" value= <%=p.symptoms%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Diagnosis: </label></td>
                    <td><input type="text" name="diagnosis" value= <%=p.diagnosis%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Medicines: </label></td>
                    <td><input type="text" name="medicines" value= <%=p.medicines%>></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Tests: </label></td>
                    <td><input type="text" name="tests" value= <%=p.tests%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Status: </label></td>
                    <td><input type="text" name="status" value= <%=p.status%> ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Update"></div>
            </form>
        <%
            }else{
            Appointment ap= LoadingInformation.loadAppointment(id);
                                      
        %>
        <form action="patientupdate" method="post">
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
                    <td><input type="text" name="firstname" value= <%=ap.patient_firstname%> ></td>
                </tr>
               <tr align='right'>
                    <td><label for="name">Last Name: </label></td>
                    <td><input type="text" name="lastname" value= <%=ap.patient_lastname%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Age: </label></td>
                    <td><input type="text" name="age" ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Email: </label></td>
                    <td><input type="text" name="email" value= <%=ap.patient_email%> ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">Symptoms: </label></td>
                    <td><input type="text" name="symptoms" ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Diagnosis: </label></td>
                    <td><input type="text" name="diagnosis"></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Medicines: </label></td>
                    <td><input type="text" name="medicines"></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Tests: </label></td>
                    <td><input type="text" name="tests"  ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Status: </label></td>
                    <td><input type="text" name="status" value= <%=ap.status%> ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Update"></div>
            </form>
                    <%
                        }
                        %>
    </body>
</html>
