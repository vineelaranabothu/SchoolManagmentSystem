package com.example.demo.school.Controller;

import java.sql.Time;
import java.util.Collection;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.school.Model.StudentLogin;
import com.example.demo.school.Model.Teacher;
import com.example.demo.school.Model.TeacherLogin;
import com.example.demo.school.Service.TeacherService;

@RestController
@RequestMapping("school/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    
    public TeacherController(TeacherService teacherService) {
    	this.teacherService = teacherService ;
    }
    //Registering students into tracher table by using jdbc templete
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody Map<String, String> map ) {
        Teacher teacher = new Teacher();
        teacher.setEmpID(Long.parseLong(map.get("empID")));
        teacher.setName(map.get("name"));
        teacher.setAge(Integer.parseInt(map.get("age")));
        teacher.setContact(map.get("contact"));
        teacher.setSalary(Long.parseLong(map.get("salary")));
        teacher.setDepartment(map.get("department"));
        teacher.setDesignation(map.get("designation"));
        teacher.setSubject(map.get("subject"));
        try {
           if(teacherService.register(teacher)==1);
           return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
		
    }
    //deleting data in teacher table by using jdbc
    @PostMapping(path = "delete", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTeacher(@RequestBody Map<String, String> map)
	{
		Teacher teacher= new Teacher();
		teacher.setEmpID(Long.parseLong(map.get("empID")));
		try {
			   if(teacherService.deleteTeacher(teacher)==1) ;
			     return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
	}
    //displaying employee id and login time
    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Map<String, Long> map ) {
        Time time = new Time(System.currentTimeMillis());
        try {
	        teacherService.login(map.get("empID"), time);
	        return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 
	      
    }
    //displaying empid and logout time
    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> logout(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        try {
	        teacherService.logout(map.get("empID"), time);
	        return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 
    }
    //inserting data into teacher_login using jpa
    @PostMapping(path = "attendence", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody TeacherLogin teacherLogin ) {
        Time time = new Time(System.currentTimeMillis());
        teacherLogin.setLogintime(String.valueOf(time));
        try {
              teacherService.login(teacherLogin);
              return ResponseEntity.ok( "Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    //custom query implementation jpa
    @GetMapping(path = "logindetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TeacherLogin> getAttendanceByDate(@RequestParam String entryDate) {
        return teacherService.getAttendanceByDate(entryDate);
    }
}