package FetchEagerLazy;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
@Id
private int sid;
private String sname;
@OneToMany(mappedBy = "student")//, fetch= FetchType.EAGER)
private Collection<Laptop> laps = new ArrayList<Laptop>();

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public Collection<Laptop> getLaps() {
	return laps;
}
public void setLaps(Collection<Laptop> laps) {
	this.laps = laps;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", laps=" + laps + "]";
}
//@Override
//public String toString() {
//    // Exclude laptop details or provide a summary
//    return "Student [sid=" + sid + ", sname=" + sname + ", laptopCount=" + (laps != null ? laps.size() : 0) + "]";
//}

}
