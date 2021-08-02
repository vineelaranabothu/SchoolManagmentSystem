package com.example.demo.school.Controller;

import java.sql.Time;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.school.Model.AdministrativeStaff;
import com.example.demo.school.Model.PaymentDetails;
//import com.example.demo.school.Model.Teacher;
import com.example.demo.school.Service.AdministrativeStaffService;



@RestController
@RequestMapping("school/administrative")

public class AdministrativeStaffController {
	
    private final AdministrativeStaffService administrativeStaffService;
    
    public AdministrativeStaffController(AdministrativeStaffService administrativeStaffService) {
    	this.administrativeStaffService = administrativeStaffService;
    }
    //Printing employee id and login time
    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Map<String, Long> map ) {
        Time time = new Time(System.currentTimeMillis());
        try {
	        administrativeStaffService.login(map.get("empID"), time);
	        return ResponseEntity.ok( "Login Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
    }
    // insering data in to payment_details using jpa
    @PostMapping(path = "payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> payment(@RequestBody PaymentDetails paymentDetails) {
    	 Time time = new Time(System.currentTimeMillis());
    	 paymentDetails.setTime(time);  
    	 try {
    	       administrativeStaffService.payment(paymentDetails);
    	       return ResponseEntity.ok( "Payment Successful");
         }catch(RuntimeException e) {
         	System.out.println(e);
         	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         } 	
    }
    //empid and logouttime
    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> logout(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        try {
	        administrativeStaffService.logout(map.get("empID"), time);
	        return ResponseEntity.ok( "Logout Successful");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
	 }
    
    @PostMapping(path = "feecollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> feeCollection(@RequestBody Map<String, Long> map ) {
        int feeCollected = 10000;
        try {
		        administrativeStaffService.feeCollection(map.get("rollno"), feeCollected);
		        return ResponseEntity.ok( " Fee collected");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
    }
   
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody Map<String, String> map ) {
        AdministrativeStaff administrativeStaff = new AdministrativeStaff();
        administrativeStaff.setEmpID(Long.parseLong(map.get("empID")));
        administrativeStaff.setName(map.get("name"));
        administrativeStaff.setAge(Integer.parseInt(map.get("age")));
        administrativeStaff.setContact(map.get("contact"));
        administrativeStaff.setSalary(Long.parseLong(map.get("salary")));
        administrativeStaff.setDepartment(map.get("department"));
        administrativeStaff.setDesignation(map.get("designation"));
        try {
		        if(administrativeStaffService.register(administrativeStaff)==1)
		        	return ResponseEntity.ok( "Registration Successful");
		        else
		        	return ResponseEntity.ok( "error");
        }catch(RuntimeException e) {
        	System.out.println(e);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 	
    }
    
}



