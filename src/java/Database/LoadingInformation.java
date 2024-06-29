package Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;
public class LoadingInformation {
    public static LoginInfo loadEmployeeLoginInfo(String userid){
        LoginInfo ob= new LoginInfo();
        try{
        EmployeeDatabase login_info_ob = new EmployeeDatabase("logininfo",userid);
        while(login_info_ob.result.next()){
            ob.userid= login_info_ob.result.getString(1);
            ob.password=login_info_ob.result.getString(2);
            ob.profession=login_info_ob.result.getString(3);
        }
       }
        catch(Exception e){
           System.out.println(e);
       }
        return ob;
    }
    public static ArrayList<LoginInfo> loadEmployeesLoginInfo(String query){
        ArrayList<LoginInfo>List= new ArrayList<LoginInfo>();
        try{
        EmployeeDatabase login_info_ob = new EmployeeDatabase(query);
        while(login_info_ob.result.next()){
            LoginInfo ob = new LoginInfo();
            ob.userid= login_info_ob.result.getString(1);
            ob.password=login_info_ob.result.getString(2);
            ob.profession=login_info_ob.result.getString(3);
            List.add(ob);
        }
       }
        catch(Exception e){
           System.out.println(e);
       }
        return List;
    }
    public static ArrayList<Employee> loadEmployeesInformation(){
        ArrayList<Employee> List = new ArrayList<Employee>();
        try{
        EmployeeDatabase login_info_ob = new EmployeeDatabase("dcotor,nurse,janitor,technician");
        while(login_info_ob.result.next()){
            Employee ob=new Employee();
            ob.firstname= login_info_ob.result.getString(2);
            ob.lastname=login_info_ob.result.getString(3);
            ob.email=login_info_ob.result.getString(4);
            ob.userid= login_info_ob.result.getString(5);
            LoginInfo li= loadEmployeeLoginInfo(ob.userid);
            ob.password=login_info_ob.result.getString(6);
            ob.status=login_info_ob.result.getString(7);
            ob.address=login_info_ob.result.getString(8);
            ob.profession=li.profession;
            List.add(ob);
            
        }
       }
        catch(Exception e){
           System.out.println(e);
       }
        return List;
    }
    public static Employee loadEmployeeInfo(String userid){
        Employee ob=new Employee();
        try{
            LoginInfo li= loadEmployeeLoginInfo(userid);
            EmployeeDatabase login_info_ob = new EmployeeDatabase(li.profession,li.userid);
            while(login_info_ob.result.next()){
            ob.firstname= login_info_ob.result.getString(2);
            ob.lastname=login_info_ob.result.getString(3);
            ob.email=login_info_ob.result.getString(4);
            ob.userid= login_info_ob.result.getString(5);
            ob.password=login_info_ob.result.getString(6);
            ob.status=login_info_ob.result.getString(7);
            ob.address=login_info_ob.result.getString(8);
            ob.profession=li.profession;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    return ob;
    }
    public static Chart loadEmployeeChart(String userid,String date){ 
         Chart ob= new Chart();
        try {
            EmployeeDatabase login_info_ob = new EmployeeDatabase("select * from chart where userid =\""+userid+"\" AND date =\""+date+"\";");
            
            while(login_info_ob.result.next()){
                ob.userid= login_info_ob.result.getString(1);
                ob.date=login_info_ob.result.getString(2);
                ob.entry=login_info_ob.result.getString(3);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoadingInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ob;
    }
    public static Appointment loadAppointment(String patient_firstname, String patient_lastname, String doctor_userid,String date){
        Appointment ob= new Appointment();
        try{
            String query= "Select * from appointment where patient_firstname =\""+patient_firstname+"\" AND patient_lastname=\""+patient_lastname+"\" AND doctor_userid=\""+doctor_userid+"\" AND date =\""+date+"\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                ob.patient_firstname= ed.result.getString(1);
                ob.patient_lastname= ed.result.getString(2);
                ob.doctor_firstname= ed.result.getString(3);
                ob.doctor_lastname= ed.result.getString(4);
                ob.patient_email= ed.result.getString(6);
                ob.doctor_userid= ed.result.getString(5);
                ob.date=ed.result.getString(7);
                ob.time=ed.result.getString(8);
                ob.patient_id=ed.result.getString(9);
                ob.status=ed.result.getString(10);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        return ob;
    }
    public static Appointment loadAppointment(String patient_id){
        Appointment ob= new Appointment();
        try{
            LocalDate d= LocalDate.now();
            String date = d.toString();
            String query= "Select * from appointment where patient_id =\""+patient_id+"\" AND date =\""+date+"\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                ob.patient_firstname= ed.result.getString(1);
                ob.patient_lastname= ed.result.getString(2);
                ob.doctor_firstname= ed.result.getString(3);
                ob.doctor_lastname= ed.result.getString(4);
                ob.patient_email= ed.result.getString(6);
                ob.doctor_userid= ed.result.getString(5);
                ob.date=ed.result.getString(7);
                ob.time=ed.result.getString(8);
                ob.patient_id=ed.result.getString(9);
                ob.status=ed.result.getString(10);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        return ob;
    }
    public static ArrayList<Appointment> loadPatientAppointments(String patient_firstname, String patient_lastname, String date){
        ArrayList<Appointment>list=new ArrayList<Appointment>();
        try{
            String query= "Select * from appointment where patient_firstname =\""+patient_firstname+"\" AND patient_lastname=\""+patient_lastname+"\" AND date =\""+date+"\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                Appointment ob= new Appointment();
                ob.patient_firstname= ed.result.getString(1);
                ob.patient_lastname= ed.result.getString(2);
                ob.doctor_firstname= ed.result.getString(3);
                ob.doctor_lastname= ed.result.getString(4);
                ob.patient_email= ed.result.getString(6);
                ob.doctor_userid= ed.result.getString(5);
                ob.date=ed.result.getString(7);
                ob.time=ed.result.getString(8);
                ob.patient_id=ed.result.getString(9);
                ob.status=ed.result.getString(10);
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    public static ArrayList<Appointment> loadDoctorAppointments(String doctor_userid){
        ArrayList<Appointment>list=new ArrayList<Appointment>();
        try{
            LocalDate d= LocalDate.now();
            String date=d.toString();
            String query= "Select * from appointment where doctor_userid =\""+doctor_userid+"\" AND date =\""+date+"\" AND NOT status =\"seen\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                Appointment ob= new Appointment();
                ob.patient_firstname= ed.result.getString(1);
                ob.patient_lastname= ed.result.getString(2);
                ob.doctor_firstname= ed.result.getString(3);
                ob.doctor_lastname= ed.result.getString(4);
                ob.patient_email= ed.result.getString(6);
                ob.doctor_userid= ed.result.getString(5);
                ob.date=ed.result.getString(7);
                ob.time=ed.result.getString(8);
                ob.patient_id=ed.result.getString(9);
                ob.status=ed.result.getString(10);
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
     public static ArrayList<Appointment> loadReceptionAppointments(){
        ArrayList<Appointment>list=new ArrayList<Appointment>();
        try{
            LocalDate d= LocalDate.now();
            String date=d.toString();
            String query= "Select * from appointment where date =\""+date+"\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                Appointment ob= new Appointment();
                ob.patient_firstname= ed.result.getString(1);
                ob.patient_lastname= ed.result.getString(2);
                ob.doctor_firstname= ed.result.getString(3);
                ob.doctor_lastname= ed.result.getString(4);
                ob.patient_email= ed.result.getString(6);
                ob.doctor_userid= ed.result.getString(5);
                ob.date=ed.result.getString(7);
                ob.time=ed.result.getString(8);
                ob.patient_id=ed.result.getString(9);
                ob.status=ed.result.getString(10);
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
     public static ArrayList<Patient> loadPatients(String userid){
          ArrayList<Patient>list=new ArrayList<Patient>();
        try{
            String query= "Select * from patient where doc_id =\""+userid+"\";";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                Patient ob= new Patient();
                ob.patient_id=ed.result.getString(1);
                ob.firstname= ed.result.getString(2);
                ob.lastname= ed.result.getString(3);
                ob.age= ed.result.getString(4);
                ob.diagnosis= ed.result.getString(5);
                ob.medicines= ed.result.getString(6);
                ob.tests= ed.result.getString(7);
                ob.email=ed.result.getString(8);
                ob.status=ed.result.getString(9);
                ob.symptoms=ed.result.getString(10);
                ob.doc_id=ed.result.getString(11);
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
     }
     public static ArrayList<Patient> loadAllPatients(){
          ArrayList<Patient>list=new ArrayList<Patient>();
        try{
            String query= "Select * from patient ;";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                Patient ob= new Patient();
                ob.patient_id=ed.result.getString(1);
                ob.firstname= ed.result.getString(2);
                ob.lastname= ed.result.getString(3);
                ob.age= ed.result.getString(4);
                ob.diagnosis= ed.result.getString(5);
                ob.medicines= ed.result.getString(6);
                ob.tests= ed.result.getString(7);
                ob.email=ed.result.getString(8);
                ob.status=ed.result.getString(9);
                ob.symptoms=ed.result.getString(10);
                ob.doc_id=ed.result.getString(11);
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
     }
      public static ArrayList<MedicineInfo> loadAllMeds(){
         
          ArrayList<MedicineInfo>list=new ArrayList<MedicineInfo>();
        try{
            String query= "Select * from medicineinfo ;";
            EmployeeDatabase ed= new EmployeeDatabase(query);
            while(ed.result.next()){
                 MedicineInfo ob= new MedicineInfo();
                ob.patient_id=ed.result.getString(1);
                ob.firstname= ed.result.getString(2);
                ob.lastname= ed.result.getString(3);
                ob.meds_given= ed.result.getString(4);
                ob.meds_not_given= ed.result.getString(5);
                ob.meds_assigned=ed.result.getString(6);
                
                list.add(ob);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
     }
}
