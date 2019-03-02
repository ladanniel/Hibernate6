package com.itcast.entity;
/**
 * 联系人实体类
 * @author Administrator
 *
 */
public class LinkMen {
	private Integer lkm_id;//联系人号码
	private String lkm_name;
	private String lkm_gender;
	private String lkm_phone;
	//在联系人里表示联系人所属的客户
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "LinkMen [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name
				+ ", lkm_gender=" + lkm_gender + ", lkm_phone=" + lkm_phone
				+ "]";
	}
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	
	

}
