package com.education.student.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Table(name = "course")
@Entity(name = "course")
public class CourseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;
	
	@NotNull
	@Column(name = "course")
	private String courseName;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "fees")
	private long courseFees;
	
	@NotNull
	@Column(name = "teacher")
	private String courseTeacher;
	
	@NotNull
	@Column(name = "duration")
	private String CourseDuration;
	

	public CourseModel(long courseId, String courseName, String description, long courseFees, String courseTeacher,
			String courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseFees = courseFees;
		this.courseTeacher = courseTeacher;
		this.CourseDuration = courseDuration;
	}

	public CourseModel() {
		super();
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(long courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public String getCourseDuration() {
		return CourseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		CourseDuration = courseDuration;
	}

	

	@Override
	public String toString() {
		return "CourseModel [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", courseFees=" + courseFees + ", courseTeacher=" + courseTeacher + ", CourseDuration="
				+ CourseDuration + "]";
	}


	
}
