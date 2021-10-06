package com.education.student.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.student.models.CourseModel;
import com.education.student.models.StudentModel;
import com.education.student.services.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<StudentModel>> getAllStudents() {

		List<StudentModel> list = studentService.getAllStudents();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable Long id) {

		return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel studentModel) {

		StudentModel studentModel1 = studentService.saveStudent(studentModel);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("studentModel", "api/student" + studentModel1.getId());

		return new ResponseEntity<>(studentModel1, httpHeaders, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable("id") Long id,
			@RequestBody StudentModel studentModel) {

		studentService.updateStudent(id, studentModel);
		return new ResponseEntity<StudentModel>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable("id") Long id) {

		studentService.deleteStudent(id);
		return new ResponseEntity<StudentModel>(HttpStatus.OK);

	}
	
	@PostMapping("/{id}/addCourse")
	public ResponseEntity<String> addCourse(@PathVariable("id") Long id,@RequestBody CourseModel courseModel){
		studentService.addCourse(id, courseModel);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/{id}/addCourses")
	public ResponseEntity<String> addCourses(@PathVariable("id") Long id,@RequestBody Set<CourseModel> courseSet){
		studentService.addCourses(id, courseSet);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/{id}/removeCourse")
	public ResponseEntity<String> removeCourse(@PathVariable("id") Long id,@RequestBody CourseModel courseModel){
		studentService.removeCourse(id, courseModel);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/{id}/removeCourses")
	public ResponseEntity<String> removeCourses(@PathVariable("id") Long id,@RequestBody Set<CourseModel> courseSet){
		studentService.removeCourses(id, courseSet);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
