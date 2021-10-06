package com.education.student.services;

import java.util.List;
import java.util.Set;

import com.education.student.models.CourseModel;
import com.education.student.models.StudentModel;

public interface StudentService {

	List<StudentModel> getAllStudents();
	
	StudentModel getStudentById(Long id);
	
	StudentModel saveStudent(StudentModel studentModel);
	
	void updateStudent(Long id, StudentModel studentModel);
	
	void deleteStudent(Long id);

	void addCourse(Long id, CourseModel courseModel);

	void addCourses(Long id, Set<CourseModel> courseSet);

	void removeCourse(Long studentId, CourseModel courseModel);
	
	void removeCourses(Long studentId, Set<CourseModel> courseSet);
	
}
