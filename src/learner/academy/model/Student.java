package learner.academy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rollNo;
	
	@JoinColumn(name="ClassId")
	@OneToOne
	private MyClass Myclass;
	
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date  dob;
	private String address;
	private Long phone;
	public Long getRollNo() {
		return rollNo;
	}
	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}
	public MyClass getMyclass() {
		return Myclass;
	}
	public void setMyclass(MyClass myclass) {
		Myclass = myclass;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", Myclass=" + Myclass + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", address=" + address + ", phone=" + phone + "]";
	}
	public Student(MyClass myclass, String firstName, String lastName, Date dob, String address, Long phone) {
		super();
		Myclass = myclass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
	}
	public Student() {
		super();
	}
	
	
	
	
	
}
