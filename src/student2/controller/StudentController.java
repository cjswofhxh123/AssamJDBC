package student2.controller;

import java.util.List;

import student2.model.dao.StudentDao;
import student2.model.vo.Student;

public class StudentController {
	private StudentDao sDao;
	public StudentController() {
		sDao = new StudentDao();
	}
	public List<Student> selectAllStudents(){
		List<Student> sList = sDao.seletAll();		
		return sList;
		
	}
	public Student selectOneById(String studnetId) {
		// TODO Auto-generated method stub
		Student student = sDao.selectOneById(studnetId);
		
		
		return student;
	
}
	public List<Student> selectAllByName(String studnetName) {
		// TODO Auto-generated method stub
		List<Student> sList = sDao.seletAllByName(studnetName);		
		return sList;
	}
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		int result = sDao.insertStudent(student);
		return result;
	}
	public int deleteStudent(String studentId ) {
		// TODO Auto-generated method stub
		int result = sDao.deleteStudent(studentId);
		return result;
	}
	public int updateStudnet(Student student) {
		// TODO Auto-generated method stub
		int result = sDao.updateStudnet(student);
		return result;
	}
	public Student studnetLogin(Student student) {
		// TODO Auto-generated method stub
		Student result = sDao.studnetLoginInfo(student);
		return result;
	}


}









