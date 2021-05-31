package com.javaex.jdbc.orcale;


import java.sql.*;
public class DBConfig {
	public static String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DBUSER = "hr";
	public static String DBPASS = "hr";
	
	static Connection getConnection() throws SQLException {	//	default ������
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			System.err.println("����̹� �ε� ����!");
		}
		
		return conn;
	}
}