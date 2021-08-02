package com.example.demo.school.Service;

import java.sql.Time;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.example.demo.school.Model.StudentLogin;
import com.example.demo.school.Model.Teacher;
import com.example.demo.school.Model.TeacherLogin;
import com.example.demo.school.repository.TeacherLoginRepository;
import com.example.demo.school.repository.TeacherRepository;


@Service
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	private final TeacherLoginRepository teacherLoginRepository;
	private final RestTemplate restTemplate;
	public TeacherService(TeacherRepository teacherRepository ,TeacherLoginRepository teacherLoginRepository ,RestTemplate restTemplate) {
		this.teacherRepository = teacherRepository;
		this.teacherLoginRepository = teacherLoginRepository;
		this.restTemplate = restTemplate;
	}
	
	public int register(Teacher teacher) {
		return teacherRepository.registerTeacher(teacher);
        
    }
	
	public int deleteTeacher(Teacher teacher) {
		return teacherRepository.deleteTeacher(teacher);
	}

	
	public void login(long empID, Time loginTime) {
        System.out.println("EmployeeID: " + empID + "\nLogin Time: " + loginTime);
    }

    public void logout(long empID, Time logoutTime) {
    	
        System.out.println("EmployeeID: " + empID + "\nLogout Time: " + logoutTime);
    }
    public void login(TeacherLogin teacherLogin) {
    	 System.out.println("EmployeeID: " + teacherLogin.getEmpID() + "\nLogin Time: " + teacherLogin.getLogintime());
        ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8081/school/teacher/attendence",teacherLogin,String.class);
        System.out.println("making call on service running on 8081");
        System.out.println(entity.getBody());
        teacherLoginRepository.save(teacherLogin);
    }
    public Collection<TeacherLogin> getAttendanceByDate(String entryDate) {
        return teacherLoginRepository.getAttendanceByDate(entryDate);
    }
}
