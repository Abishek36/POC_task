package JDBC_Details;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Input{
public static void main(String[]args){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "Connect@123");
 Statement st=con.createStatement();

FileInputStream fstream = new FileInputStream("C:\\Users\\abishek.murugesan\\Desktop\\Txt\\details.txt");
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    ArrayList list=new ArrayList();
    while ((strLine = br.readLine()) != null){
    list.add(strLine);
    }
  Iterator itr;
  
    for (itr=list.iterator(); itr.hasNext(); ){
  String str=itr.next().toString();  
  //System.out.println("inside");
    String[] splitSt =str.split("\t");
   
    System.out.println(splitSt.length);
    
    String studentId="",firstname="",lastname="",departmentId="",joiningDate ="",studentDob="",mobileNo="",email="";
    
      for (int i = 0 ; i < splitSt.length ; i++) {
    	  
     studentId=splitSt[0];
     firstname=splitSt[1];
     lastname=splitSt[2];
     departmentId=splitSt[3];
     joiningDate=splitSt[4];
     studentDob=splitSt[5];
     mobileNo= splitSt[6];
     email=splitSt[7];
    }
      ResultSet rs= st.executeQuery("select * from DEPARTMENT");
      while(rs.next()) {
      if(departmentId.equals(rs.getString("Department"))) {
    	  departmentId = (rs.getString("DEPTID"));
      }
      }
  
int k=st.executeUpdate("insert into student(studentId,Firstname,Lastname,DepartmentId,joiningDate,studentDob,mobileNo,email) values('"+studentId+"','"+firstname+"','"+lastname+"','"+departmentId+"','"+joiningDate+"','"+studentDob+"','"+mobileNo+"','"+email+"')");

rs.close();


}
}
catch(Exception e){
	e.printStackTrace();
}
}
}