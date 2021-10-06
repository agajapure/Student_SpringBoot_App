package com.education.student.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Table(name ="student")
@Entity(name = "student")
public class StudentModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "firstName")
	private String studentFirstName;
	
	@NotNull
	@Column(name = "lastName")
	private String studentLastName;
	
	@NotNull
	@Column(name = "age")
	private Integer age;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "mobile")
	private String mobileNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="STUDENT_COURSE", joinColumns = {@JoinColumn(name="STUDENT_ID")}, 
	inverseJoinColumns = {@JoinColumn(name="COURSE_ID")})
	private Set<CourseModel> courseModel;
	

	public StudentModel(long id, String studentFirstName, String studentLastName, Integer age, String email,
			String mobileNumber, Set<CourseModel> courseModel) {
		super();
		this.id = id;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.age = age;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.courseModel = courseModel;
	}



	public StudentModel() {
		super();
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CourseModel> getCourseModel() {
		return courseModel;
	}

	public void setCourseModel(Set<CourseModel> courseModel) {
		this.courseModel = courseModel;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", age=" + age + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", courseModel=" + courseModel + "]";
	}


	

	
}
