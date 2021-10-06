package com.education.student.services;

import java.util.List;

import com.education.student.models.CourseModel;

public interface CourseService {

	List<CourseModel> getAllCourses();

	CourseModel getCourseById(Long courseId);

	CourseModel saveCourse(CourseModel courseModel);

	void updateCourse(Long courseId, CourseModel courseModel);

	void deleteCourse(Long courseId);
}
