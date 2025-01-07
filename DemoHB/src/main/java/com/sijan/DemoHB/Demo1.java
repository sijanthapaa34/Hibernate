package com.sijan.DemoHB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Demo2") //change the name of table
public class Demo1 {
	@Id
	private int id;
	//@Column(name = "Full_name") to specify column name
	//private String name;
	private Name aname;
	//@Transient doesnot store data
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
public Name getAname() {
		return aname;
	}
	public void setAname(Name aname) {
		this.aname = aname;
	}
	//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	@Override
	public String toString() {
		return "Demo1 [id=" + id + ", name=" + aname + ", address=" + address + "]";
	}
	
	

}
