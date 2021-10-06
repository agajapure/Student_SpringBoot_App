package com.education.student;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

import com.education.student.models.CourseModel;
import com.education.student.models.StudentModel;
import com.education.student.repository.CourseRepository;
import com.education.student.repository.StudentRepository;

@SpringBootApplication
@EntityScan(basePackageClasses = { StudentRestApiApplication.class, Jsr310Converters.class })
public class StudentRestApiApplication {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(StudentRestApiApplication.class, args);
	}
	
	@Bean
	InitializingBean createSampleData() {
		return ()->{
			
			if(courseRepository.count()==0) {
				CourseModel c1 = new CourseModel(0, "Java", "Java", 120, "Mayur", "3 month");
				CourseModel c2 = new CourseModel(0, "Python", "Python", 150, "Shruti", "5 month");
				courseRepository.save(c2);
				
				Set<CourseModel> courseSet = new HashSet<>();
				courseSet.add(c1);
				StudentModel s1 = new StudentModel(0, "Akash", "Gajapure", 25, "agg@gmail.com", "3333333333", courseSet);
				
				s1 = studentRepository.save(s1);
				System.out.println("Student :"+s1);
			}
			
			
			
		};
	}

}
