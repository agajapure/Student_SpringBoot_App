package com.education.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.student.models.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel, Long>{

	CourseModel findByCourseName(String courseName);
}
