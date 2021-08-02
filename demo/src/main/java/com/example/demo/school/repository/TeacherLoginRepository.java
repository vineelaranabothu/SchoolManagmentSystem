package com.example.demo.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.school.Model.TeacherLogin;
import java.util.Collection;
public interface TeacherLoginRepository extends CrudRepository<TeacherLogin,String>{
	 @Query("SELECT t FROM teacher_login t WHERE t.date = ?1")
	    Collection<TeacherLogin> getAttendanceByDate(String date);

}
