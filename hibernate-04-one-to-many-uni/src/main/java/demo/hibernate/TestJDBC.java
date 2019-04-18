package demo.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user = "hbstudent";
		String pwd = "hbstudent";
		try {
			System.out.println("Connecting to database " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pwd);
			System.out.println("Connection Successful");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
