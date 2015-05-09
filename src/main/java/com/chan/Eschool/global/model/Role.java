package com.chan.Eschool.global.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	private long id;
	private String name;
	private String authority;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
