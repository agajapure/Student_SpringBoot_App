package com.education.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.student.models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel,Long>{

}
