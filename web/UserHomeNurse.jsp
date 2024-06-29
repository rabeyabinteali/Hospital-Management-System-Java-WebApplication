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
        <title>Nurse Homepage</title>
        <style>
           table.profile{
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
            #medicines{
                align-content: left;
            }
            #patietns{
                align-content: left;
            }
            table.medicines{
                width: 100%;
                td,th{
                    border: 2px solid;
                }
            }
            table.patients{
                width: 100%;
                td,th{
                    border: 2px solid;
                }
            }
             tr.medicines:nth-child(even){
                    border: 1px solid;
                    background-color: #1cc6d9;
                }
                tr.patients:nth-child(even){
                    border: 1px solid;
                    background-color: #1cc6d9;
                }
                tr.patients:nth-child(odd){
                    border: 1px solid;
                    background-color: #a0eff7;
                }
                tr.medicines:nth-child(odd){
                    border: 1px solid;
                    background-color: #a0eff7;
                }
            table.menu{
                width:100%;
            }
            
        </style>
    </head>
    <body action="userhome" method="post">
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
            <table class="profile">
                <tr><td><img src="user.png" width="100px" height="100px" alt="user image" align=></td></tr>
                <tr><td><% out.print("Full name: " +ob.firstname+" "+ob.lastname); %></td></tr>
                <tr><td><% out.print("Profession: Nurse"); %></td></tr>
                <tr><td><% out.print("Email: " +ob.email); %></td></tr>
                 <tr><td><% out.print("Address: "+ob.address); %></td></tr>
                <tr><td><% out.print("Status: "+ob.status.toUpperCase()); %></td></tr>
                <tr><td><% out.print("Date: "+d.toString()); %></td></tr>
                 <tr><td><% out.print("Current Login Time: "+flt.format(t)); %></td></tr>
                  <tr><td><% if(c.entry==null){
                            out.print("Today's Reporting Time: "+flt.format(t));
                      }else{
                      out.print("Today's Reporting  Time: "+c.entry);
                     } %></td>
                  </tr>
                  <%
                      %>
                      <tr><td><form action="logout" method='get'>
                                 
                                  <div align='center'><input type="submit" value="Logout"></div></form></a></td></tr>
            </table>
        </div>
                  <div id="menu">
                      <table class="menu">
                          <tr class="menu">
                              <td class="menu">Patients</td>
                          </tr>
                      </table>
                      
                          <table class="patients">
                              <tr class="patients">
                                  <th>Patient Name</th>
                                  <th>Email</th>
                                  <th>Symptoms</th>
                                  <th>Age</th>
                                  <th>Diagnosis</th>
                                  <th>Medicines</th>
                                  <th>Action</th>
                              </tr>
                          <%
                               ArrayList<Patient> Apps = LoadingInformation.loadAllPatients();
                              for(int i=0; i<Apps.size();i++){
                               out.print("<tr class=\"patients\"><td>"+Apps.get(i).firstname+" "+Apps.get(i).lastname+"</td><td>"+Apps.get(i).email+"</td><td>"+Apps.get(i).symptoms+"</td><td>"+Apps.get(i).age+"</td><td>"+Apps.get(i).diagnosis+"</td><td>"+Apps.get(i).medicines+"</td><td><a href=\"SeeMedicines.jsp?id="+Apps.get(i).patient_id+"\">See Medicines</a></td></tr>");
                              }
                          %>
                          </table>
                           <table class="menu">
                          <tr class="menu">
                              <td class="menu">Medicines</td>
                          </tr>
                          
                          <table class="patients">
                              <tr class="patients">
                                  <th>Patient Name</th>
                                  <th>Medicines Given</th>
                                  <th>Medicines Not Given</th>
                                  <th>Medicines Assigned</th>
                                  <th>Action</th>
                              </tr>
                          <%
                              ArrayList<MedicineInfo> App = LoadingInformation.loadAllMeds();
                              for(int i=0; i<App.size();i++){
                               out.print("<tr class=\"patients\"><td>"+App.get(i).firstname+" "+App.get(i).lastname+"</td><td>"+App.get(i).meds_given+"</td><td>"+App.get(i).meds_not_given+"</td><td>"+App.get(i).meds_assigned+"</td><td><a href=\"SeeMedicines.jsp?id="+App.get(i).patient_id+"\">See Medicines</a></td></tr>");
                              }
                          %>
                          </table>
                      </div>
                      </table>
                  </div>
        </div>
    </body>
</html>
