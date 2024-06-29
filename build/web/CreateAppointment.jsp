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
        <title>Create Appointment</title>
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
        Appointment p= LoadingInformation.loadAppointment(id);
        %>
        <form action="createappointment" method="post">
                <table align="center">
                    <tr align='right'>
                    <td><label for="name">Your UserID:  </label></td>
                    <td><input type="text" name="userid" ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Patient First Name: </label></td>
                    <td><input type="text" name="pf" value= <%=p.patient_firstname%> ></td>
                </tr>
               <tr align='right'>
                    <td><label for="name">Patient Last Name: </label></td>
                    <td><input type="text" name="pl" value= <%=p.patient_lastname%> ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Doctor First Name: </label></td>
                    <td><input type="text" name="df" value= <%=p.doctor_firstname%> ></td>
               </tr>
                <tr align='right'>
                    <td><label for="name">Doctor Last Name: </label></td>
                    <td><input type="text" name="dl" value= <%=p.doctor_lastname%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Email: </label></td>
                    <td><input type="text" name="email" value= <%=p.patient_email%> ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">Date </label></td>
                    <td><input type="text" name="date" value= <%=p.date%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Time: </label></td>
                    <td><input type="text" name="time" value= <%=p.time%>></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Doctor UserID:  </label></td>
                    <td><input type="text" name="did" value= <%=p.doctor_userid%> ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Status: </label></td>
                    <td><input type="text" name="status" value= <%=p.status%> ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Update"></div>
            </form>
    </body>
</html>
