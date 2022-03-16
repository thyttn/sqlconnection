package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTestConnection {
	public static void main(String args[]) throws SQLException {
		//Lay ra doi tuong connection connect voi db
		Connection conn = MySqLConnUtils.getMySQLConnection();
		
		Statement statement = conn.createStatement();
		
		String sql = "SELECT EMP_ID,FIRST_NAME,LAST_NAME FROM automationfc.employee;";
		
		//Thuc thi cau lenh sql va tra ve doi tuong ResultSet
		ResultSet rs = statement.executeQuery(sql);
		
		//Duyet ket qua tra ve
		while(rs.next()) {
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("LAST_NAME");
			
			System.out.println("---------");
			
			System.out.println("EmpID: " + empId);
			System.out.println("empFirstName: " + empFirstName);
			System.out.println("empLastName: " + empLastName);
		}
		conn.close();
	}
}
