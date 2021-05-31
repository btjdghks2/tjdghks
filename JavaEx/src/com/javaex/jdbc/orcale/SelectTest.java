package com.javaex.jdbc.orcale;


import java.sql.*;
//	departments ���̺�κ��� ��� ���ڵ带 �ҷ��ͼ�
//	department_id:department_name ���� ���
public class SelectTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//	���ڵ� ��ü
		
		try {
			//	Ŀ�ؼ� ȹ��
			conn = DBConfig.getConnection();
			//	statement ����
			stmt = conn.createStatement();	//	connection -> statement
			//  ���� ����
			String sql = "SELECT department_id, department_name " +
						" FROM departments";
			rs = stmt.executeQuery(sql);	//	SELECT - executeQuery -> ResultSet ��ȯ
			//	��� ��ü �޾ƿ���
			//	��� ���
			while (rs.next()) {	//	�� �� ���ڵ� �޾ƿ���
				//	�� �޾ƿ���: �÷��� Ÿ�Ժ� get �޼��� ����
				Long deptId = rs.getLong(1);	//	1��° �÷��� Long ������
				String deptName = rs.getString("department_name");	//	�÷��� ǥ���̸����� �� �޾ƿ���
				
				System.out.printf("%d:%s%n", deptId, deptName);
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
