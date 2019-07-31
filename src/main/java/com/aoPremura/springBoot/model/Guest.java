package com.aoPremura.springBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idguest")
	private long idguest;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tel")
	private String tel;
	
	@Override
	public String toString() {
		return "名前: " + name + "\n" + "E-mail: " + email + "\n" + "電話番号: " + tel + "\n";
	}
	
	// GET && SET //
	
	public Guest() {
		
	}

	public Guest(String name, String email, String tel) {
		this.name = name;
		this.email = name;
		this.tel = tel;
	}

	public long getIdguest() {
		return idguest;
	}

	public void setIdguest(long idguest) {
		this.idguest = idguest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}	

}
