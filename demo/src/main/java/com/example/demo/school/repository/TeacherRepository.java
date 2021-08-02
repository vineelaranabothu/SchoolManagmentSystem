package com.example.demo.school.repository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.school.Model.Teacher;

@Repository
public class TeacherRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int registerTeacher(Teacher teacher) {
		
		String query = "insert into teacher(empID,name,age,contact,salary,department,designation,subject)values(?,?,?,?,?,?,?,?);";
		int insert = jdbcTemplate.update(query,teacher.getEmpID(),teacher.getName(),teacher.getAge(),teacher.getContact(),teacher.getSalary(),teacher.getDepartment(),teacher.getDesignation(),teacher.getSubject());
		return insert;
		}
	public int deleteTeacher(Teacher teacher)
	{
		String query = "delete from teacher  where empID = ?";
		int insert = jdbcTemplate.update(query, teacher.getEmpID());
		return insert;
	}
}
