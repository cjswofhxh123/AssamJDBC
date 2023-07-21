package student.model.dao;

import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import student.model.vo.Student;

public class StrudentDao {

	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";

	public List<Student> selectAll() {

		/*
		 * 1.드라이버 등록 2.DB 연결 생성 3.쿼리문 실행 준비 4.쿼라문 실행 및 5.결과 받기 6.자원해제(close))
		 */
		String query = "SELECT * FROM STUDENT_TBL";
		List<Student> sList = null;
		Student student = null;

		try {
			// 1.드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB 연결 생성(DriverManger)
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 쿼리문 실행 준비
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			sList = new ArrayList<Student>();
			while (rset.next()) {
				student = rsetToStudent(rset);
				sList.add(student);
//				System.out.printf("아이디 : %s,,이름: %s\n", rset.getString("STUDENT_ID"), rset.getString("STUDENT_NAME"));
			}
			// 자원 해제
			rset.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sList;

	}

	public int insertStudent(Student student) {
//		INSERT INTO STUDENT_TBL VALUES('Khuser01','pass01','일용자','M', 11, 'khuser01@kh.com', '01082829222'
//				, '서울시 중구 남대문로 120', '독서,수영', SYSDATE);

		String query1 = "INSERT INTO STUDENT_TBL VALUES('" + "'" + student.getStudentId() + "','" + "'"
				+ student.getStudentPwd() + "','" + "'" + student.getStudentName() + "','" + "'" + student.getGender()
				+ "','" + "'" + student.getAge() + "','" + "'" + student.getPhone() + "','" + "'" + student.getAddress()
				+ "','" + "'" + student.getHobby() + "','" + "'" + student.getEnrollDate() + "";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query1);
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Student selectOneByle(String studentId) {
		// SELECT *FROM STUDENT_TBL WHERE STUDENT_ID = 'Khuser01'
		String query = "SELECT *FROM STUDENT_TBL WHERE STUDENT_ID = '" + studentId + "'";
		Student student = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			// 한개일떄는 if문을 써야한다.
			if (rset.next()) {
				student = rsetToStudent(rset);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	public Student rsetToStudent(ResultSet rset) throws SQLException {
		Student student = new Student();
		student.setStudentId(rset.getString("STUDENT_ID"));
		student.setStudentPwd(rset.getString("STUDENT_PWD"));
		student.setStudentName(rset.getString("STUDENT_NAME"));
		student.setAge(rset.getString("Age"));
		student.setEmail(rset.getString("Email"));
		student.setPhone(rset.getString("Phone"));
		student.setGender(rset.getString("GENDER").charAt(0));
		student.setAddress(rset.getString("ADDRESS"));
		student.setHobby(rset.getString("hobby"));
		student.setEnrollDate(rset.getString("ENROLL_DATE"));
		return student;
	}

	public List<Student> selectAllByName(String studentName) {
		String query = "SELECT *FROM STUDENT_TBL WHERE STUDENT_NAME = '" + studentName + "'";
		List<Student> sList = new ArrayList<Student>();
		Student student = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				student = rsetToStudent(rset);
				sList.add(student);
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sList;
	}

//
//	try {
//		Class.forName(DRIVER_NAME);
//		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
//		Statement stmt = conn.createStatement();
//		ResultSet rset = stmt.executeQuery(query);
//		
//		rset.close();
//		stmt.close();
//		conn.close();

	public int deleteString(String studentId) {
		// TODO Auto-generated method stub
		// DELETE FROM STUDENT_TBL WHERE STUDENT_ID = 'khuser01';
		String query = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID = '" + studentId + "'";
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public int updatesStudent(Student student) {
		// TODO Auto-generated method st
		String query = "UPDATE STUDENT_TBL SET" + "STUDENT_PWD = " + "'" + student.getStudentPwd() + "'," + "EMAIL = "
				+ "'" + student.getEmail() + "'," + "PHONE = " + "'" + student.getPhone() + "'," + "ADDRESS = " + "'"
				+ student.getAddress() + "'," + "HOBBY = " + "'" + student.getHobby() + "'," + "AGE = " + "'"
				+ student.getAge() + "'," + "EnrollDate = " + "'" + student.getEnrollDate() + "'," + "StudentName = "
				+ "'" + student.getStudentName() + "'," + "StudentID = " + "'" + student.getStudentId() + "',";
		// UPDATE STUDENT_TBL SET STUDENT_PWD = 'pass11', EMAIL = 'khuser01@iei.or.kr',
		// PHONE = '01092920303'
//				, ADDRESS = '서울시 강남구', HOBBY = '코딩,수영' WHERE STUDENT_ID = 'khsuer01';  ;
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteStudent(String studentId) {
		String query = "";
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
