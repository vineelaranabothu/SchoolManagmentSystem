package com.example.demo.school.Controller;

import java.sql.Time;
import java.util.Optional;

import org.springframework.http.HttpStatus;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.school.Model.StudentLogin;
import com.example.demo.school.Service.StudentService;

@RestController
@RequestMapping("school/student")
public class StudentLoginController {

    
    private final StudentService studentService;
    public StudentLoginController(StudentService studentService) {
    	this.studentService = studentService;
    }
    // insering values in to student login by jpa
    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody StudentLogin studentLogin ) {
        Time time = new Time(System.currentTimeMillis());
        studentLogin.setLogintime(String.valueOf(time));
        try {
             studentService.login(studentLogin);
             return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
    }
    //getting data from studentlogin by rollno
    @GetMapping(path = "attendance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentLogin getAttendanceByID(@RequestParam String rollNo) {
        Optional<StudentLogin> studentLogin = studentService.findByID(rollNo);
        if (!studentLogin.isEmpty()) {
            return studentLogin.get();
        } else {
            return null;
        }
    }

}
