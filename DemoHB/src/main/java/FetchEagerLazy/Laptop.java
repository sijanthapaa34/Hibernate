package FetchEagerLazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
@Id
private int lid;
private String brand;
private int price;
@ManyToOne
private Student student;
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}

@Override
public String toString() {
    // Exclude student details to prevent recursion
    return "Laptop [lid=" + lid + ", brand=" + brand + ", price=" + price + "]";
}

}
