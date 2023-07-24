package student2.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import student2.model.vo.Student;

public class StudentDao {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";

	public List<Student> seletAll() {
		String query = "SELECT *FROM STUDENT_TBL";
		//
		List<Student> sList = new ArrayList<>();
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER_NAME);
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			stmt =conn.prepareStatement(query);
			//
			stmt.executeQuery(query);
			//

			while (rset.next()) {
				Student student = resToStudnet(rset);
				sList.add(student);
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		}
		return sList;
	}

	private Student resToStudnet(ResultSet rset) throws SQLException {
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

	public Student selectOneById(String studnetId) {
		// 1. 위치홀더 셋팅
		// 2. PreparedStatement 객체 생성 with query
		// 3. 입력값 셋팅
		// 4. 쿼리문 실행 및 결과 받기 (feat. method())
		String query = "SELECT *FROM STUDENT_TBL WHERE STUDENT_ID= ?";
		Student student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, studnetId);
			pstmt.executeQuery();
			// Statement stmt = conn.createStatement();
			// ResultSet rset =stmt.executeQuery(query);
			if (rset.next()) {
				student = resToStudnet(rset);

			}

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return student;

	}

	public List<Student> seletAllByName(String studnetName) {
		// TODO Auto-generated method stub
		//
		String query = "SELECT *FROM STUDENT_TBL WHERE STUDENT_NAME= ?";
		//
		List<Student> sList = new ArrayList<Student>();
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, studnetName);
			pstmt.executeQuery();
			//
			// Statement stmt = conn.createStatement();
			// ResultSet rset =stmt.executeQuery(query);
			while (rset.next()) {
				Student student = resToStudnet(rset);
				sList.add(student);
			}

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}
		return sList;
	}

	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO STUDENT_TBL VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// INSERT INTO STUDENT_TBL
		try {
			Class.forName(DRIVER_NAME);
			// Statement stmt = conn.createStatement();
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, student.getStudentId());
			pstmt.setString(2, student.getStudentPwd());
			pstmt.setString(3, student.getStudentName());
			pstmt.setString(4, String.valueOf(student.getStudentName()));
			pstmt.setString(5, student.getAge());
			pstmt.setString(6, student.getEmail());
			pstmt.setString(7, student.getPhone());
			pstmt.setString(8, student.getAddress());
			pstmt.setString(9, student.getHobby());
			result = pstmt.executeUpdate();
			// ********************쿼리문 실행 뺴먹지 않기

			// ResultSet rset = pstmt.executeQuery();

			// result = stmt.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public int deleteStudent(String studentId) {

		String query = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID =?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, studentId);
			result = pstmt.executeUpdate();
			// Statement stmt = conn.createStatement();
			// result = stmt.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public int updateStudnet(Student student) {
		// TODO Auto-generated method stub
		String query = "UPDATE STUDENT_TBL SET STUDENT_PWD =?,EMAIL = ?,ADDRESS =?,  HOBBY =?,  WHERE  STDUENT_ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = -1;

		try {
			Class.forName(DRIVER_NAME);

			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, student.getStudentPwd());
			pstmt.setString(2, student.getEmail());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getHobby());
			pstmt.setString(5, student.getStudentId());
			result = pstmt.executeUpdate();

			// Statement stmt = conn.createStatement();
			// result = stmt.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public Student studnetLoginInfo(Student student) {
		// TODO Auto-generated method stub
		String query = "SELECT *FROM STUDENT_TBL WHERE STUDENT_ID= ? AND STUDENT_PWD =?";
		Student result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, student.getStudentId());
			pstmt.setString(2, student.getStudentPwd());
			// 시작은 1로 하고 마지막 수는 물음표의 갯수와 같다. (물음표 = 위치홀더)
			pstmt.executeQuery(query);
			// Statement stmt = conn.createStatement();
			// ResultSet rset =stmt.executeQuery(query);
			if (rset.next()) {
				result = resToStudnet(rset);
			}

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}

}