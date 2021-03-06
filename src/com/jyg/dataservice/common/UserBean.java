package com.jyg.dataservice.common;

import java.util.Date;

public class UserBean implements DataBean{

	public UserBean(){
		
	}
	
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "username = " + getUsername() + "password = " + getPasswd() + "createTime = " + getCreatedTime(); 
				
	}

	private long id;
	
	private String username;
	
	private String passwd;
	
	private Date createdTime;
}
