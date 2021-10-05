package JDBC_Details;
import java.sql.*;
public class StudentD {
	static final String DB_URL = "jdbc:mysql://localhost:3306/students_details";
	static final String USER ="root";
	static final String PASS ="Connect@123";
	
	public static void main(String[] args) throws SQLException {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
//            Creating Table
         /*String sql = "CREATE TABLE  STUDENT " +
                    "(studentId smallint not NULL, " +
                    " FirstName VARCHAR(25), " +
                    "LastName VARCHAR(25),"+
                    "DepartmetId int ,"+
                    "joiningDate  date not NULL, "+
                    "studentDob date," +
                    "mobileNo bigint,"+
                    " email VARCHAR(255),"+
                    " PRIMARY KEY ( studentId,joiningDate ))";
                 stmt.executeUpdate(sql);
            
            System.out.println("Created table .."); */
            
            System.out.println("Inserting records ..."); 
            
            String sql1 = "INSERT INTO STUDENT VALUES (1, 'Anbu', 'D', 1,'2021-10-05','1997-10-05',8658902164,'anbu@email.com')";
            stmt.executeUpdate(sql1);
            sql1 = "INSERT INTO STUDENT VALUES (2, 'Velu', 'M', 5,'2021-11-05','1998-10-08',8658902165,'velu@email.com')";
            stmt.executeUpdate(sql1);
            sql1 = "INSERT INTO STUDENT VALUES (3, 'Selva', 'K', 2,'2021-11-05','1995-05-08-',8658902166,'selva@email.com')";
            stmt.executeUpdate(sql1);
            
            
         
            
            //System.out.println("Inserted records ...");
      
	} catch (Exception e) {
        e.printStackTrace();
    }
}
}
