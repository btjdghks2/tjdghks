package com.javaex.jdbc.orcale.dao;

// DTO ��ü : �ڹ��� ������ ������ ������ ����ϴ� ��ü
// �ʵ�, getter/setter, toString, equals ������ �޼��常 �ۼ�
// �ݵ�� �⺻ �����ڰ� �־�� ��
// �Ϲ������� ���� �޼���� �ۼ����� �ʴ´�
public class AuthorVO {
	private Long id; //pk
	private String authorName;
	private String authorDesc;
	
	//������
	public AuthorVO() {
		
	}
	
	public AuthorVO(Long id, String authorName) {
		this.id = id;
		this.authorName = authorName;
		
	}
	
	//��ü �ʵ� ������
	private AuthorVO(Long i , 
			String authorName, 
			String authorDesc) {
		this(id, authorName);
		this .au
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	@Override
	public String toString() {
		return "AuthorVO [id=" + id + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
