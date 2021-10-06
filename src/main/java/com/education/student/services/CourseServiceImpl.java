package com.education.student.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.student.exceptions.ResourceNotFoundException;
import com.education.student.models.CourseModel;
import com.education.student.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public List<CourseModel> getAllCourses() {
		
		List<CourseModel> list = new ArrayList<>();
		
		courseRepository.findAll().forEach(list::add);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public CourseModel getCourseById(Long courseId) {
		courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		return courseRepository.findById(courseId).get();
	}

	@Override
	public CourseModel saveCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		return courseRepository.save(courseModel);
	}

	@Override
	public void updateCourse(Long courseId, CourseModel courseModel) {
		courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		CourseModel oldCourse = courseRepository.findById(courseId).get();
		
		System.out.println(oldCourse.toString());
		
		oldCourse.setCourseName(courseModel.getCourseName());
		oldCourse.setDescription(courseModel.getDescription());
		oldCourse.setCourseFees(courseModel.getCourseFees());
		oldCourse.setCourseTeacher(courseModel.getCourseTeacher());
		oldCourse.setCourseDuration(courseModel.getCourseDuration());
		
		courseRepository.save(oldCourse);
		
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		courseRepository.deleteById(courseId);
	}

}
