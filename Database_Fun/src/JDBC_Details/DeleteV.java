package Fun;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeleteV {
	static final String Db_URL = "jdbc:mysql://localhost:3306/test";
	static final String User = "root";
	static final String Pass = "Connect@123";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(Db_URL, User, Pass);
				Statement stmt = conn.createStatement();) {
			System.out.println("\nConnection Success!\n");
			PreparedStatement stmt1 = null;
			stmt1 = conn.prepareStatement("delete from rough where studentId = ?");

			FileInputStream filestream = new FileInputStream(
					"C:\\Users\\abishek.murugesan\\Desktop\\POC-Data\\deletestudent.txt");
			DataInputStream in = new DataInputStream(filestream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int count = in.available();
			String s;
			ArrayList list = new ArrayList();
			while ((s = br.readLine()) != null) {
				list.add(s);
				System.out.println(s);
				stmt1.executeUpdate("delete from rough where studentId=" + s);
			}
		} catch (SQLException | FileNotFoundException throwables) {
			throwables.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}