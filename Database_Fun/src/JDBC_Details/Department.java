package JDBC_Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
	static final String DB_URL = "jdbc:mysql://localhost:3306/students_details";
	static final String USER ="root";
	static final String PASS ="Connect@123";
	
	public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
//            Creating Table
//       String sql = "CREATE TABLE DEPARTMENT" +
//                    "(DepartmentId int not NULL, " +
//                    " Department  VARCHAR(255), " +
//                    " PRIMARY KEY ( DepartmentId ))";
//            stmt.executeUpdate(sql);
//            System.out.println("DEPARTMENT TABLE CREATED.....");
//            
            String sql="";
            System.out.println("Inserting department records into the table...");
             sql = "INSERT INTO DEPARTMENT VALUES (1, 'CS')";
            stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (2, 'EEE')";
             stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (3, 'IT')";
             stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (4, 'ECE')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO DEPARTMENT VALUES (5, 'Arch')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO DEPARTMENT VALUES (6, 'Mech')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO DEPARTMENT VALUES (7, 'Mining')";
            stmt.executeUpdate(sql);
          
	
            System.out.println("Inserted department records ...");
        	
        	

        	Statement st = conn.createStatement();
         /*   ResultSet res = st.executeQuery("SELECT *FROM " + "students" + " NATURAL JOIN " + "department");
            System.out.println("ID" + " FirstName " + "LastName" + "Department" + "DeptID");
            while (res.next()) {
                String ID = res.getString("ID");
                String FirstName = res.getString("FirstName");
                String LastName = res.getString("LastName");
                String Department = res.getString("Department");
                String DeptID = res.getString("DeptID");
                // Beautification of output
                System.out.format(
                        "%10s%10s%10s%10s%20s\n", ID, FirstName, LastName, Department, DeptID);
            }*/
	} catch (SQLException e) {
        e.printStackTrace();
    }
}
}



