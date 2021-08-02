package com.example.demo.school.Service;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.school.Model.Student;
import com.example.demo.school.Model.StudentLogin;
import com.example.demo.school.repository.StudentLoginRepository;
import com.example.demo.school.repository.StudentRepository;



@Service
public class StudentService {

	private final StudentLoginRepository studentLoginRepository;
	private final StudentRepository studentRepository;
    public StudentService(StudentLoginRepository studentLoginRepository ,StudentRepository studentRepository) {
    	this.studentRepository = studentRepository;
    	this.studentLoginRepository = studentLoginRepository;
    }
   
	public void login(StudentLogin studentLogin) {
		
        
        studentLoginRepository.save(studentLogin);
    }
	
	public int registerStudent(Student student) {
		return studentRepository.registerStudent(student);
        
    }

	public Optional<StudentLogin> findByID(String rollNo) {
        return studentLoginRepository.findById(rollNo);
    }

}