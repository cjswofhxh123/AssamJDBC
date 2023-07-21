package student.controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.model.dao.StrudentDao;
import student.model.vo.Student;

public class StudentController {

	private StrudentDao studnetDao;

	public StudentController() {
		studnetDao = new StrudentDao();
	}

	public List<Student> printStudentlist() {
		// TODO Auto-generated method stub
		List<Student> sList = studnetDao.selectAll();
		return sList;
	}

	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		int result = studnetDao.insertStudent(student);
		return result;
	}

	public Student printStudentById(String studentId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		return student;

		// TODO Auto-generated method stub
	}

	public List<Student> printStudentByName(String studentName) {
		// TODO Auto-generated method stub
		List<Student> sList = studnetDao.selectAllByName(studentName);
		return sList;
	}

	public int modifyStudent(Student student) {
		// TODO Auto-generated method stub
		int result = studnetDao.updatesStudent(student);
		return result;

	}

	public int deleteStudent(String studentId) {
		int result = studnetDao.deleteStudent(studentId);
		return 0;
	}

}
