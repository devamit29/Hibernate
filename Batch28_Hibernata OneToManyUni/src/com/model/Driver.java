package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	
	private String dname;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Vehicle> vlist=new ArrayList<Vehicle>();

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Vehicle> getVlist() {
		return vlist;
	}

	public void setVlist(List<Vehicle> vlist) {
		this.vlist = vlist;
	}

	@Override
	public String toString() {
		return "Driver [did=" + did + ", dname=" + dname + ", vlist=" + vlist + "]";
	}
	
	

}
