package com.javaex.jdbc.orcale.dao;

import java.util.List;

// 설계도
public interface AuthorDAO {
	public List<AuthorVO> getList(); // 단순 select
	public List<AuthorVO> search(String keyword); // like 검색
	public AuthorVO get(Long id); // pk로 가져오기
	public boolean insert(AuthorVO vo); // INSERT
	public boolean delete(Long id); // pk로 삭제
	public boolean update(AuthorVO vo)
}
