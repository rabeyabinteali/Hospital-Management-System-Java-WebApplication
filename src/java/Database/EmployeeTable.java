/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.util.ArrayList;
import java.time.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EmployeeTable {
    public static void addEmployee(Employee ob){
       
        EmployeeDatabase ed=new EmployeeDatabase();
        EmployeeDatabase es=new EmployeeDatabase();
        String q1="insert into "+ob.profession.toLowerCase()+"(firstname,lastname,email,userid,password,status,address) values(?,?,?,?,?,?,?)";
        String q2="insert into logininfo(userid,password,profession) values(?,?,?)";
        try{
        PreparedStatement ps = ed.con.prepareStatement(q1);
        ps.setString(1,ob.firstname);
        ps.setString(2,ob.lastname);
        ps.setString(3,ob.email);
        ps.setString(4,ob.userid);
        ps.setString(5,ob.password);
        ps.setString(6,ob.status);
        ps.setString(7,ob.address);
        ps.execute();
        ed.con.close();
        PreparedStatement pd = es.con.prepareStatement(q2);
        pd.setString(1,ob.userid);
        pd.setString(2,ob.password);
        pd.setString(3,ob.profession);
        pd.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void removeEmployee(String table, String condition){
        EmployeeDatabase ed= new EmployeeDatabase("detele from "+table+" where "+condition+";");
    }
    public static void updateEmployee(String table,String key, String value,String condition){
        String query="update "+table+" set "+key+" = \""+value+"\" where "+condition+";";
        try {
            EmployeeDatabase ed= new EmployeeDatabase(query);
            int count=ed.statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateChartEntry(String userid){
        LocalDateTime dtm= LocalDateTime.now();
        LocalDate d= dtm.toLocalDate();
        LocalTime t= dtm.toLocalTime();
        //EmployeeDatabase e= new EmployeeDatabase("insert into chart(userid,date,entry) values (\""+userid+"\",\""+d+"\",\""+t+"\");");
        EmployeeDatabase ed=new EmployeeDatabase();
        String q="insert into chart(userid,date,entry) values(?,?,?)";
        try{
        PreparedStatement ps = ed.con.prepareStatement(q);
        ps.setString(1,userid);
        ps.setString(2,d.toString());
        ps.setString(3,t.toString());
        ps.execute();
        ed.con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
     public static void updateChartExit(String userid){
        try {
            LocalDateTime dtm= LocalDateTime.now();
            LocalTime t= dtm.toLocalTime();
            LocalDate d=dtm.toLocalDate();
            String query="Update chart Set departure =\""+t+"\" WHERE userid = \""+userid+"\" AND date =\""+d.toString()+"\";";
            EmployeeDatabase e= new EmployeeDatabase(query);
            int count=e.statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void createAppoinment(String p_firstname, String p_lastname, String d_firstname, String d_lastname,String d_id, String p_email,String date,String time){
        EmployeeDatabase ed=new EmployeeDatabase();
        String q="insert into appointment(patient_firstname,patient_lastname,doctor_firstname,doctor_lastname,doctor_userid,patient_email,DATE,Time) values(?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement ps = ed.con.prepareStatement(q);
        ps.setString(1,p_firstname);
        ps.setString(2,p_lastname);
        ps.setString(3,d_firstname);
        ps.setString(4,d_lastname);
        ps.setString(5,d_id);
        ps.setString(6,p_email);
        ps.setString(7,date);
        ps.setString(8,time);
        ps.execute();
        ed.con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
