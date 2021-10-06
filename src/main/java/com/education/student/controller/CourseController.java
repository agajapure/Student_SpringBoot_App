package com.education.student.controller;

import java.util.List;

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
import com.education.student.services.CourseService;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
	
	CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping
	public ResponseEntity<List<CourseModel>> getAllCourses() {

		List<CourseModel> list = courseService.getAllCourses();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseModel> getCourseById(@PathVariable Long courseId) {

		return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CourseModel> saveCourse(@RequestBody CourseModel courseModel) {

		CourseModel courseModel1 = courseService.saveCourse(courseModel);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("courseModel", "api/courses" + courseModel1.getCourseId());

		return new ResponseEntity<>(courseModel1, httpHeaders, HttpStatus.CREATED);

	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<CourseModel> updateCourse(@PathVariable("courseId") Long courseId,
			@RequestBody CourseModel courseModel) {

		courseService.updateCourse(courseId, courseModel);
		return new ResponseEntity<CourseModel>(courseService.getCourseById(courseId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<CourseModel> deleteCourse(@PathVariable("courseId") Long courseId){
		
		courseService.deleteCourse(courseId);
		return new ResponseEntity<CourseModel>(HttpStatus.OK);
			
	}


}
