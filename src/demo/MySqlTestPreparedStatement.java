package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTestPreparedStatement {
	public static void main(String args[]) throws SQLException {
		//Lay ra doi tuong connection connect voi db
		Connection conn = MySqLConnUtils.getMySQLConnection();
		
		String sqlParam = "SELECT EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM automationfc.employee "
				+ "where FIRST_NAME like ? and DEPT_ID = ?;";
		
		PreparedStatement pStatement = conn.prepareStatement(sqlParam);
		
		pStatement.setString(1, "%n");
		pStatement.setInt(2, 1);
		//Thuc thi cau lenh sql va tra ve doi tuong ResultSet
		ResultSet rs = pStatement.executeQuery();
		
		//Duyet ket qua tra ve
		while(rs.next()) {
			System.out.println("---------");
			
			System.out.println("EmpID: " + rs.getInt(1));
			System.out.println("First Name: " + rs.getString(2));
			System.out.println("Last Name: " + rs.getString(3));
			System.out.println("Department id : " + rs.getInt(4));
		}
		conn.close();
	}
}
