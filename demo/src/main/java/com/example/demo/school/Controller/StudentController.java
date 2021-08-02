package com.example.demo.school.Controller;

//import java.sql.Time;
import java.util.Map;

import org.springframework.http.HttpStatus;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.school.Model.Student;

import com.example.demo.school.Service.StudentService;
@RestController
@RequestMapping("school/student")
public class StudentController {
     private final StudentService studentService;
     public StudentController(StudentService studentService) {
    	 this.studentService = studentService;
     }
     //inserting data in to student using jdbc
     @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<String> register(@RequestBody Map<String, String> map ) {
         Student student = new Student();
         student.setRollno(map.get("rollno"));
         student.setName(map.get("name"));
         student.setAge(Integer.parseInt(map.get("age")));
         student.setAddress(map.get("address"));
         student.setGender(map.get("gender"));
         student.setGrade(Integer.parseInt(map.get("grade")));
         try {
               if(studentService.registerStudent(student)==1)
                  return ResponseEntity.ok( "Successful");
               else
            	   return ResponseEntity.ok( "error");
         }catch(RuntimeException e) {
         	System.out.println(e);
         	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         } 	
 		
     }  
}

