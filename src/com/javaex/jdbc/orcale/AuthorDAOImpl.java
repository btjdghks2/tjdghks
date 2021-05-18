package com.javaex.jdbc.orcale;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
	//	���� ���� �޼���
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//	����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,
					"C##TEST",
					"1234");
		} catch (ClassNotFoundException e) {
			System.err.println("����̹� �ε� ����!");
		}
		
		return conn;
	}
	
	@Override
	public List<AuthorVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		//	SELECT
		ResultSet rs = null;
		//	��� ��ü
		List<AuthorVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			//	����
			String sql = "SELECT author_id, author_name, author_desc " +
						"FROM author";
			//	���� ����
			rs = stmt.executeQuery(sql);
			
			//	ResultSet -> Java ��ü�� ��ȯ
			while(rs.next()) {	//	���� ���ڵ尡 ������ ��ȯ
				Long id = rs.getLong(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				
				//	DTO ��ü
				AuthorVO vo = new AuthorVO(id, authorName, authorDesc);
				//	DTO ��ü -> List�� �߰�
				list.add(vo);
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
		return list;
	}

	@Override
	public List<AuthorVO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorVO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(AuthorVO vo) {
		// .executeUpdate �޼��� -> int (���Ե� ���ڵ� ��)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			//	���� ��ȹ
			String sql = "INSERT INTO author VALUES(seq_author_id, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			//	�ĸ����� ���ε�
			pstmt.setString(1, vo.getAuthorName());
			pstmt.setString(2, vo.getAuthorDesc());
			
			//	���� ����
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
		return 1 == insertedCount;	//	���Ե� ���ڵ尡 1���� ����
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deleted Count = 0
				
				try {
					conn = getConnection();
					SAtring sql = "DELETE FROM author WHERE author_id=?";
					pstmt =conn.prepareStarement(sql);
					pstmt.setLong(1, id);
					
					deletedCount = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.print
				}
		return false;
	}

	@Override
	public boolean update(AuthorVO vo) {
		Connection conn = null;
		preparedStatement pstmt = null;
		int updatedCount = 0;
		
		try {
			con = getConnection();
			// ���� ��ȹ
			String sql = "UPDATE author SET author_desc=? WHERE author_id=?";
			pstmt = conn.prepareStatement(sql);
			//�Ķ���� ���ε�
			pstmt.setString(1, vo.getAuthorDesc());
			pstmt.setLong(2, vo.getId());
			
			updatedCount = pstmt .executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			
		
		
			}
		}
		return 1 == updatedCount;
	}

}