package com.itcast.many_to_many;

import java.util.HashSet;
import java.util.Set;
/**
 * user��roleֻ����һ����дtoString����
 * @author Administrator
 *
 */
public class Role {
	private Integer role_id;
	private String role_name;
	private String role_descrbie;//��ɫ����
	
	
	//һ����ɫ�����ж���û��ı�ʾ
	private Set<User> setUser = new HashSet<User>();
	
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_descrbie() {
		return role_descrbie;
	}
	public void setRole_descrbie(String role_descrbie) {
		this.role_descrbie = role_descrbie;
	}
	
	
	

}
