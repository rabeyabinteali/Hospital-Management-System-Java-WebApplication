<%-- 
    Document   : UserHome.jsp
    Created on : Oct 26, 2022, 12:06:29 PM
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
        <title>Doctor Homepage</title>
        <style>
           table{
                border-collapse: collapse;
                width:100%;
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
            #profile{
                width: 20%;
                float: left;
            }
            div.tableHead{
                width: 100%;
                align-content: center;
                height: 10%;
            }
            table.header{
                border-collapse: collapse;
                width: 100%;
            }
            tr.header{
                background-color: #4656a2;
            }
            #body{
                width: 100%;
            }
            #menu{
                width:80%;
                float: right;
            }
            tr.menu{
                background-color: #424d80;
                border: 2px solid;
            }
            td.menu{
                font-family: Helvetica;
                color: white;
                border: 1px solid;
            }
            #appointments{
                align-content: left;
            }
            table.appointments{
                border: 1px solid;
                background-color: #a7e1f9;
            }
            
        </style>
    </head>
    <body>
        <jsp:include page="UserHomeDoctor.jsp"/>
        <header>
            <table class="header">
                <tr class="header">
                    <td rowspan='2'> <img src="logo.png" width="150px" height="150px" align="left"></td>
                    <td> <div align="left"><h1 style="color:white;">Red Cross Hospital</h1></div></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
        </tr> 
            </table>
        </header>
         <% 
           String userid= request.getParameter("userid");
           Employee ob = LoadingInformation.loadEmployeeInfo(userid); 
           LocalDateTime dtm= LocalDateTime.now();
           LocalDate d= dtm.toLocalDate();
           LocalTime t=dtm.toLocalTime();
           DateTimeFormatter flt = DateTimeFormatter.ofPattern("HH:mm:ss");
           Chart c = LoadingInformation.loadEmployeeChart(userid, d.toString());
        %>
        <div id="body">
        <div id="profile">
            <table>
                <tr><td><img src="user.png" width="100px" height="100px" alt="user image" align=></td></tr>
                <tr><td><% out.print("Full name: " +ob.firstname+" "+ob.lastname); %></td></tr>
                <tr><td><% out.print("Profession: Doctor"); %></td></tr>
                <tr><td><% out.print("Email: " +ob.email); %></td></tr>
                 <tr><td><% out.print("Address: "+ob.address); %></td></tr>
                <tr><td><% out.print("Status: "+ob.status.toUpperCase()); %></td></tr>
                <tr><td><% out.print("Date: "+d.toString()); %></td></tr>
                  <tr><td><% if(c.entry==null){
                            out.print("Today's Reporting Time: "+flt.format(t));
                      }else{
                      out.print("Today's Reporting  Time: "+c.entry);
                     } %></td>
                  </tr>
                      <tr><td><form action="logout" method='get'>
                                 
                                  <div align='center'><input type="submit" value="Logout"></div></form></a></td></tr>
            </table>
        </div>
                  <div id="menu">
                      <table>
                          <tr class="menu">
                              <td class="menu"><a href="DoctorAppointments.jsp">Appointments</a></td>
                              <td class="menu"><a href="DoctorPatients.jsp">Patients</a></td>
                          </tr>
                      </table>
                      <div id="appointments">
                          <table class="appointments">
                              <tr>
                                  <th>Patient Firstname</th>
                                  <th>Patient Lastname</th>
                                  <th>Patient email</th>
                                  <th>Date</th>
                                  <th>Time</th>
                              </tr>
                          <%
                              ArrayList<Appointment> Apps = LoadingInformation.loadDoctorAppointments(userid);
                              for(int i=0; i<Apps.size();i++){
                               out.print("<tr><td>"+Apps.get(i).patient_firstname+"</td><td>"+Apps.get(i).patient_lastname+"</td><td>"+Apps.get(i).patient_email+"</td><td>"+Apps.get(i).date+"</td><td>"+Apps.get(i).time+"</td></tr>");
                              }
                          %>
                          </table>
                      </div>
                  </div>
        </div>
    </body>
</html>
