package com.example.demo.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.school.Model.StudentLogin;




public interface StudentLoginRepository  extends CrudRepository<StudentLogin,String>{
	@Query("SELECT s FROM student_login s WHERE s.rollno = ?1")
    Optional<StudentLogin> getByID(String rollno);

}