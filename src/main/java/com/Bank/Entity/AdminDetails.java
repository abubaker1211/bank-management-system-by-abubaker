package com.Bank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String adminemailid;
	@Column(nullable=false)
	private String adminpassword;
	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDetails(Integer id, String adminemailid, String adminpassword) {
		super();
		this.id = id;
		this.adminemailid = adminemailid;
		this.adminpassword = adminpassword;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminemailid() {
		return adminemailid;
	}
	public void setAdminemailid(String adminemailid) {
		this.adminemailid = adminemailid;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "AdminDetails [id=" + id + ", adminemailid=" + adminemailid + ", adminpassword=" + adminpassword + "]";
	}
	
	
	

}
