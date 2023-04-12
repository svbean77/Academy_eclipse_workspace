package com.shinhan.vo;

// DTO, VO, JavaBeans: data를 저장해 전송하기 위함
public class AdminVO {
	private String email;
	private String manager_name;
	private String pass;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminVO [email=").append(email).append(", manager_name=").append(manager_name).append(", pass=")
				.append(pass).append("]");
		return builder.toString();
	}

	public AdminVO() {
System.out.println("** AdminVO default 생성자 **");
	}

	public AdminVO(String email, String manager_name, String pass) {
		super();
		this.email = email;
		this.manager_name = manager_name;
		this.pass = pass;
	}

	public String getEmail() {
		System.out.println("getEmail: " + email);
		return email;
	}

	public void setEmail(String email) {
		System.out.println("setEmail: " + email);
		this.email = email;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
