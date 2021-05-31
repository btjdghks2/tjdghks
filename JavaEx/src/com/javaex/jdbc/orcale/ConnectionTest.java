package com.javaex.jdbc.orcale;


import java.sql.*;	//	JDBC API

public class ConnectionTest {
	
	public static void main(String[] args) {
		String dbuser = "hr";
		String dbpass = "hr";
		Connection conn = null;
		
		try {
			// Driver Load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	Connection ����
			conn = DriverManager.getConnection(DBConfig.DBURL,	//	db ���� url
												dbuser,
												dbpass);
			System.out.println(conn);
			System.out.println("���� ����!");
		} catch (ClassNotFoundException e) {
			System.err.println("����̹� �ε� ����!");
		} catch (SQLException e) {
			System.err.println("SQLError!");
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}