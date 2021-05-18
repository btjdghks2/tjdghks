package com.javaex.jdbc.orcale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.sun.jdi.connect.spi.Connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//	PreparedStatement�� Ȱ���� �޿� �˻� ���α׷�
//	����ڷκ��� �ּ� �޿��� �ִ� �޿��� �Է�
//	�޿��� �� ���� ���� ���ϴ� ����� ��� ���
public class HRSalaryPstmt {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ּұ޿�:");
		int minSalary = scanner.nextInt();
		System.out.print("�ִ�޿�:");
		int maxSalary = scanner.nextInt();
		
		if (minSalary > maxSalary) {
			//	���� ������ �ش�
			int temp = minSalary;
			minSalary = maxSalary;
			maxSalary = temp;
		}
		
		scanner.close();
		
		try {
			conn = DBConfig.getConnection();
			
			//	���� ��ȹ �غ�
			String template = "SELECT first_name || ' ' || last_name as name, salary " +
					"FROM employees WHERE salary BETWEEN ? AND ? ORDER BY salary DESC";	//	�������� ������ ������ ���� ? ǥ��
			pstmt = conn.prepareStatement(template);
			//	���� ������ ���ε�
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			
			//	���� ����
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString(1);
				int salary = rs.getInt(2);
				
				//	���
				System.out.printf("%s - %d%n", name, salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}

}

