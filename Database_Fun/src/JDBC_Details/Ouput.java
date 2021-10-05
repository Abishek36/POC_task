package JDBC_Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ouput {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		
		String url="jdbc:mysql://localhost:3306/students_details";
		String uname= "root";
		String pass ="Connect@123";
		try {
		
		String query1 ="select studentId,FirstName,LastName,joiningDate,\r\n"
				+ "studentDob,mobileNo,email,department.Department from student\r\n"
				+ "join department on student.DepartmentId=department.DepartmentId";
		
		
		Class.forName("com.mysql.jdbc.Driver"); // class forname
		 con =DriverManager.getConnection(url,uname,pass) ;
	
		 st = con.createStatement();
		 rs =st.executeQuery(query1);
		
//		rs.next();
//		String name = rs.getString("Student_name");
		
		while (rs.next()) {
		    String ID = rs.getString("studentID");
		    String FirstName = rs.getString("firstName");
		    String LastName = rs.getString("lastName");
		    String joiningDate = rs.getString("joiningDate");
		    String studentDoB = rs.getString("studentDob");
		    String mobile = rs.getString("mobileNo");
		    String email = rs.getString("email");
		    String deptid = rs.getString("department");
		    System.out.format("%10s%15s%15s%15s%15s%15s%15s%40s\n", ID, FirstName, LastName,deptid,joiningDate,studentDoB,mobile, email);
		}
		
		st.close();
		con.close();
	 	//System.out.println(name);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		
	}

}
