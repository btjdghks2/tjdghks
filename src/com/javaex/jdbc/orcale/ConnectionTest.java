package com.javaex.jdbc.orcale;

import java.sql.*; //JDNC API

public class ConnectionTest {

	public static void main(String[] args) {
		
		String dbuser = "hr";
		String dbpass = "hr";
		Connection conn = null;
		
		// Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connenction 생성
		conn= DriverManager.gerConnection(DBConfig.DBURL, //db 접속 ㅕ기
													dbuser,
													dbpass);
		System.out.println(conn);
		System.out.println("연결성공!");
		
	} catch (ClassNotFoundException e) {
		System.err.println("드라이버 로드 실패!");
		catch (SQLException e) {
			System.err.println("SQLError!");
			
		} finally {
			try {
				conn.close();
				
			} catch (close()  {
				e.printStackTrace();
			}
		
	}
	}}

