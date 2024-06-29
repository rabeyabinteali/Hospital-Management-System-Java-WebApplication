package Database;
import java.sql.*;
import java.util.*;
public class EmployeeDatabase {
     public String tableName;
     public Connection con;
     public Statement statement;
     public ResultSet result;
     public PreparedStatement ps;
   public EmployeeDatabase(String tableName, String userid){
    //public static void main(String [] args){
		try {
                Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","rabeya");
		statement = con.createStatement();
                ps= con.prepareStatement("select * from "+tableName+" where userid = \""+userid+"\";");
                userid=userid.strip();
		result=statement.executeQuery("select * from "+tableName+" where userid = \""+userid+"\";");
                //System.out.println("Connection successful");
                }
		catch(Exception e) {
			System.out.println(e);
		}
	}
   public EmployeeDatabase(String query){
    //public static void main(String [] args){
		try {
                Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","rabeya");
		statement = con.createStatement();
                ps= con.prepareStatement(query);
		result=statement.executeQuery(query);
                //System.out.println("Connection successful");
                }
		catch(Exception e) {
			System.out.println(e);
		}
	}
   public EmployeeDatabase(){
       try {
                Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","rabeya");
                }
		catch(Exception e) {
			System.out.println(e);
		}
   }
}
