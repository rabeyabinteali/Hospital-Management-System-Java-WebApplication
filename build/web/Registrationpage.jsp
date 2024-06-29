<%-- 
    Document   : register
    Created on : Oct 27, 2022, 11:33:25 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
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
            body{
                background-image: url(bg2.png);
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <body>
            <div align="center"><img src="logo.png" width="200px" height="200px"><h3 style="color:blue"> Red Cross Hospital</h3></div>
            <div align=center><h2 style="color: chocolate">Registration Form</h2> </div>
            <form action="register" method="post">
                <table align="center">
                <tr align='right'>
                    <td><label for="name">First Name:</label></td>
                    <td><input type="text" name="firstname" ></td>
                </tr>
               <tr align='right'>
                    <td><label for="name">Last Name:</label></td>
                    <td><input type="text" name="lastname" ></td>
               </tr>
               <tr align='right'>
                    <td><label for="name">Email :</label></td>
                    <td><input type="text" name="email" ></td>
                </tr> 
                <tr align='right'>
                    <td><label for="name">User ID:</label></td>
                    <td><input type="text" name="userid" ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Password:</label></td>
                    <td><input type="password" name="password" ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Profession:</label></td>
                    <td><input type="text" name="profession" ></td>
                </tr>
                <tr align='right'>
                    <td><label for="name">Address:</label></td>
                    <td><input type="text" name="address" ></td>
                </tr>
                </table>
                <div align='center'><input type="submit" value="Register"></div>
            </form>
        <br>
        <br>
        <br>
        <br> 
        <br>
        <br>
        <br> 
        <br>
        <br>
    </body>
    </body>
</html>
