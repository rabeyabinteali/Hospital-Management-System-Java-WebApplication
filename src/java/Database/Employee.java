/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author user
 */
public class Employee {
   public String firstname;
   public String lastname;
   public String email;
   public String userid;
   public String password;
   public String status;
   public String address;
   public String profession;
   public Employee(){
       
   }
   public Employee(String f, String l, String e, String i, String p, String s, String a, String pr){
       firstname=f;
       lastname=l;
       email=e;
       userid=i;
       password=p;
       status=s;
       address=a;
       profession=pr;
   }
}
