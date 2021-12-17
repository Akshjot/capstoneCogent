package com.nt.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private String authority;
	
	public Authority(String a)
	{
		this.authority = a;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
