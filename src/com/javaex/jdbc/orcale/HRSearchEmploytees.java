package com.javaex.jdbc.orcale;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

//	Scanner�� Ű���� �Է�
//	first_name, last_name �ʵ� ��� �κ� �˻�
//	�̸� ��, Email, ��ȭ��ȣ, �Ի��� ���
public class HRSearchEmployees {

	public static void main(String[] args) {
		Connection conn = null;	//	Ŀ�ؼ�
		Statement stmt = null;	//	����
		ResultSet rs = null;	//	��� ��
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			
			System.out.print("�˻���:");
			String keyword = scanner.next();
			
			String sql = "SELECT first_name, last_name, " +
					"email, phone_number, hire_date " +
					" FROM employees " +
					" WHERE lower(first_name) LIKE '%" + keyword.toLowerCase() + "%' OR " +
					" lower(last_name) LIKE '%" + keyword.toLowerCase() + "%'";
			System.out.println("QUERY:" + sql);
			
			stmt = conn.createStatement();
			//	���� ����
			rs = stmt.executeQuery(sql);
			//	Loop
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String hireDate = rs.getString("hire_date");	
				
				//	���
				System.out.printf("%s %s: %s, %s, %s%n", 
						firstName, lastName, email, phoneNumber, hireDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}

}