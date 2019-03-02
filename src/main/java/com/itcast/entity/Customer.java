package com.itcast.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体类
 * @author Administrator
 *
 */
public class Customer {
	private Integer cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	//在客户实体类里面表示多个联系人，一个客户有多个联系人
	  //hibernate要求使用集合表示多的数据，使用set集合，不建议用list集合
	private Set<LinkMen> setLinkMen = new HashSet<LinkMen>();
	
	public Set<LinkMen> getSetLinkMen() {
		return setLinkMen;
	}
	public void setSetLinkMen(Set<LinkMen> setLinkMen) {
		this.setLinkMen = setLinkMen;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", custName=" + custName
				+ ", custLevel=" + custLevel + ", custSource=" + custSource
				+ ", custPhone=" + custPhone + ", custMobile=" + custMobile
				+ "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

}
