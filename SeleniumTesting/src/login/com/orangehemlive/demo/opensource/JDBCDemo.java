package login.com.orangehemlive.demo.opensource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCDemo {
	
	@Test
	public static void test() throws Exception{
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Hamsika07");
	        System.out.println("Connection is successful");
	        Statement st=con.createStatement();
	        //ResultSet rs=st.executeQuery("select * from orangehrmlogin");
	        //ResultSet rs=st.executeUpdate();
	         st.executeUpdate("update orangehrmlogin set username='sagar' where username='vijetha'");
	        /*while(rs.next()) {
	         String username=rs.getString("username");
	         String password=rs.getString("password");
	         System.out.println(username);
	         System.out.println(password);
	        }*/
	        
	        System.out.println("JDBC is success");
	    }catch(Exception e) {
	        System.out.println("Connection is not established"+e.getMessage());
	    }
	    
	}
	

}
