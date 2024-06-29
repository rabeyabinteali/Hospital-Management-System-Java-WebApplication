/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PatientTable {
    public void addMedicine(String med, String patient_id){
        String query="Select * from patient where patient_id=\""+patient_id+"\";";
        Patient p=new Patient();
        EmployeeDatabase ed= new EmployeeDatabase(query);
        try{
           while(ed.result.next()){
               p.patient_id=ed.result.getString(1);
               p.firstname=ed.result.getString(2);
               p.lastname=ed.result.getString(3);
               p.age=ed.result.getString(4);
               p.diagnosis=ed.result.getString(5);
               p.medicines=ed.result.getString(6);
               p.tests=ed.result.getString(7);
               p.email=ed.result.getString(8);
               p.status=ed.result.getString(9);
               p.symptoms=ed.result.getString(10);
               p.doc_id=ed.result.getString(11);
           }
           p.medicines=p.medicines+","+med;
           String query2="Update patient set medicines = ? where patient_id=?;";
           PreparedStatement ps= ed.con.prepareStatement(query2);
           ps.setString(1, p.medicines);
           ps.setInt(2, Integer.parseInt(patient_id));
           ps.executeUpdate();
           ed.con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void insertPatient(String pid, String pf, String pl, String age, String dig, String med, String test,String em,String st,String sym,String doc_id){
        try {
            
            String query="insert into patient (patient_id,patient_firstname, patient_lastname,age,diagnosis,medicines,tests,email,status,symptoms,doc_id) values(?,?,?,?,?,?,?,?,?,?,?)";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
             ps.setString(1,pid);
            ps.setString(2,pf);
            ps.setString(3,pl);
            ps.setString(4,age);
            ps.setString(5,dig);
            ps.setString(6,med);
            ps.setString(7,test);
            ps.setString(8,em);
            ps.setString(9,st);
            ps.setString(10, sym);
            ps.setString(11,doc_id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    public static Patient loadPatient(String patient_id){
         Patient p=new Patient();
         String query="Select * from patient where patient_id=\""+patient_id+"\";";
        EmployeeDatabase ed= new EmployeeDatabase(query);
        try{
           while(ed.result.next()){
               p.patient_id=ed.result.getString(1);
               p.firstname=ed.result.getString(2);
               p.lastname=ed.result.getString(3);
               p.age=ed.result.getString(4);
               p.diagnosis=ed.result.getString(5);
               p.medicines=ed.result.getString(6);
               p.tests=ed.result.getString(7);
               p.email=ed.result.getString(8);
               p.status=ed.result.getString(9);
               p.symptoms=ed.result.getString(10);
               p.doc_id=ed.result.getString(11);
           }
        }
        catch(Exception e){
                System.out.println(e);
        }
         return p;
    }
     public static Patient loadPatientfromAppointment(String patient_id){
         Patient p=new Patient();
         String query="Select * from appointment where patient_id=\""+patient_id+"\";";
        EmployeeDatabase ed= new EmployeeDatabase(query);
        try{
           while(ed.result.next()){
               p.patient_id=ed.result.getString(1);
               p.firstname=ed.result.getString(2);
               p.lastname=ed.result.getString(3);
               p.age=ed.result.getString(4);
               p.diagnosis=ed.result.getString(5);
               p.medicines=ed.result.getString(6);
               p.tests=ed.result.getString(7);
               p.email=ed.result.getString(8);
               p.status=ed.result.getString(9);
               p.symptoms=ed.result.getString(10);
               p.doc_id=ed.result.getString(11);
           }
        }
        catch(Exception e){
                System.out.println(e);
        }
         return p;
    }
      public static void updatePatient(String pid, String pf, String pl, String age, String dig, String med, String test,String em,String st,String sym,String doc_id){
        try {
            
            String query="update patient set patient_id = ?, patient_firstname = ?, patient_lastname =?, age = ?, diagnosis = ?, medicines = ?, tests = ?, email = ?, status = ?, symptoms = ?, doc_id = ? WHERE patient_id = ?";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,pid);
            ps.setString(2,pf);
            ps.setString(3,pl);
            ps.setString(4,age);
            ps.setString(5,dig);
            ps.setString(6,med);
            ps.setString(7,test);
            ps.setString(8,em);
            ps.setString(9,st);
            ps.setString(10,sym);
            ps.setString(11,doc_id);
            ps.setInt(12,Integer.parseInt(pid));
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
      public static void updateAppoinment(String pid,String st){
        try {
            
            String query="update appointment set status = ? WHERE patient_id = ?";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,st);
            ps.setString(2,pid);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
       public static void updateAppoinment(String pid,String pf,String pl,String df,String dl,String did,String em, String date, String time,String st){
        try {
            
            String query="update appointment set patient_firstname = ?, patient_lastname =?, doctor_firstname = ?, doctor_lastname =?, patient_email = ?,doctor_userid =?, DATE = ?, Time = ?, status = ? WHERE patient_id = ?";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,pf);
            ps.setString(2,pl);
            ps.setString(3,df);
            ps.setString(4,dl);
            ps.setString(5,em);
            ps.setString(6,did);
            ps.setString(7,date);
            ps.setString(8,time);
            ps.setString(9,st);
            ps.setString(10,pid);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
        public static void createAppoinment(String pf,String pl,String df,String dl,String did,String em, String date, String time,String st){
        try {
            
            String query="insert into appointment  (patient_firstname,patient_lastname, doctor_firstname, doctor_lastname,doctor_userid,patient_email, DATE, Time, status) values (?,?,?,?,?,?,?,?,?)";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,pf);
            ps.setString(2,pl);
            ps.setString(3,df);
            ps.setString(4,dl);
            ps.setString(5,did);
            ps.setString(6,em);
            ps.setString(7,date);
            ps.setString(8,time);
            ps.setString(9,st);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
    public static void updateMedicineInfo(String pid,String f, String l, String mg, String mng, String ma){
        try {           
            String query="update medicineinfo set patient_id = ?, firstname = ?, lastname =?, meds_given = ?, meds_not_given = ?, meds_assigned = ? WHERE patient_id = ?";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,pid);
            ps.setString(2,f);
            ps.setString(3,l);
            ps.setString(4,mg);
            ps.setString(5,mng);
            ps.setString(6,ma);
            ps.setString(7,pid);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  public static void createMedicineInfo(String pid,String f, String l, String mg, String mng, String ma){
        try {           
            String query="insert into medicineinfo (patient_id,firstname,lastname,meds_given, meds_not_given, meds_assigned) values(?,?,?,?,?,?)";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            PreparedStatement ps = ed.con.prepareStatement(query);
            ps.setString(1,pid);
            ps.setString(2,f);
            ps.setString(3,l);
            ps.setString(4,mg);
            ps.setString(5,mng);
            ps.setString(6,ma);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PatientTable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
       public static MedicineInfo loadMedicineInfo(String patient_id){
         MedicineInfo p=new MedicineInfo();
         String query="Select * from medicineinfo where patient_id=\""+patient_id+"\";";
        EmployeeDatabase ed= new EmployeeDatabase(query);
        try{
           while(ed.result.next()){
               p.patient_id=ed.result.getString(1);
               p.firstname=ed.result.getString(2);
               p.lastname=ed.result.getString(3);
               p.meds_given=ed.result.getString(4);
               p.meds_not_given=ed.result.getString(5);
               p.meds_assigned=ed.result.getString(6);
           }
        }
        catch(Exception e){
                System.out.println(e);
        }
         return p;
    }
 
}
