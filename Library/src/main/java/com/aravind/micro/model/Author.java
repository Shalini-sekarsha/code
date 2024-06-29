package com.aravind.micro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@Column(name="Author Name")
	private String aname;
	
	@Column(name="Specifications")
	private String spec;

	public Author() {
		super();
		
	}

	public Author(int aid, String aname, String spec) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.spec = spec;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", aname=" + aname + ", spec=" + spec + "]";
	}
	
	
	

}
