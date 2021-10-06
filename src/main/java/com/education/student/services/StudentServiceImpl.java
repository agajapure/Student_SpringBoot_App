package com.education.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.student.exceptions.ResourceNotFoundException;
import com.education.student.models.CourseModel;
import com.education.student.models.StudentModel;
import com.education.student.repository.CourseRepository;
import com.education.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentModel> getAllStudents() {
		
		List<StudentModel> list = new ArrayList<>();
		studentRepository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public StudentModel getStudentById(Long id) {
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found.")); //To check Student is available or not by Student id
		return studentRepository.findById(id).get();
	}

	@Override
	public StudentModel saveStudent(StudentModel studentModel) {
		
		return studentRepository.save(studentModel);
	}

	@Override
	public void updateStudent(Long id, StudentModel studentModel) {
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found.")); //To check Student is available or not by Student id
		StudentModel oldStudent = studentRepository.findById(id).get();
		System.out.println(oldStudent.toString());
		
		oldStudent.setStudentFirstName(studentModel.getStudentFirstName());
		oldStudent.setStudentLastName(studentModel.getStudentLastName());
		oldStudent.setAge(studentModel.getAge());
		oldStudent.setEmail(studentModel.getEmail());
		oldStudent.setMobileNumber(studentModel.getMobileNumber());
		
		studentRepository.save(oldStudent);
		
		
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found.")); //To check Student is available or not by Student id
		studentRepository.deleteById(id);
	}

	@Override
	public void addCourse(Long studentId, CourseModel courseModel) {
		studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found.")); //To check Student is available or not by Student id
		courseRepository.findById(courseModel.getCourseId()).orElseThrow(()->new ResourceNotFoundException("Course not found."));
		StudentModel sm = studentRepository.getById(studentId);
		sm.getCourseModel().add(courseModel);
		studentRepository.save(sm);
	}

	@Override
	public void addCourses(Long studentId, Set<CourseModel> courseSet) {
		StudentModel sm = studentRepository.getById(studentId);
		for (CourseModel courseModel : courseSet) {
			courseRepository.findById(courseModel.getCourseId()).orElseThrow(()->new ResourceNotFoundException("Course not found."));
			sm.getCourseModel().add(courseModel);
		}
		studentRepository.save(sm);
	}

	@Override
	public void removeCourse(Long studentId, CourseModel courseModel) {
		StudentModel sm = studentRepository.getById(studentId);
		sm.getCourseModel().remove(courseModel);
		studentRepository.save(sm);
	}
	
	@Override
	public void removeCourses(Long studentId, Set<CourseModel> courseSet) {
		StudentModel sm = studentRepository.getById(studentId);
		sm.getCourseModel().removeAll(courseSet);
		studentRepository.save(sm);
	}
	

}
