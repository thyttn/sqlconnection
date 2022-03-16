package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTestStatementMethod {
	public static void main(String args[]) throws SQLException {
		//Lay ra doi tuong connection connect voi db
		Connection conn = MySqLConnUtils.getMySQLConnection();
		
		Statement statement = conn.createStatement();
		
		String sql = "SELECT * FROM automationfc.department;";
		
		String insertValue = "insert into automationfc.department(NAME) values('Development');";
		
		int rowCount = statement.executeUpdate(insertValue);
		System.out.println("row number : " + rowCount);
		
		//Thuc thi cau lenh sql va tra ve doi tuong ResultSet
		ResultSet rs = statement.executeQuery(sql);
		
		//Duyet ket qua tra ve
		while(rs.next()) {
			int depId = rs.getInt(1);
			String depName = rs.getString(2);
			
			System.out.println("---------");
			
			System.out.println("EmpID: " + depId);
			System.out.println("empFirstName: " + depName);
		}
		conn.close();
	}
}
