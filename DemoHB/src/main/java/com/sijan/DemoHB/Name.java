package com.sijan.DemoHB;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
private String Fname;
private String lname;
private String mname;
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
@Override
public String toString() {
	return "Name [Fname=" + Fname + ", lname=" + lname + ", mname=" + mname + "]";
}

}
