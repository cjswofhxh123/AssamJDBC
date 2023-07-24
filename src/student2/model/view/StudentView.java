package student2.model.view;

import java.util.List;
import java.util.Scanner;

import student2.controller.StudentController;
import student2.model.vo.Student;

public class StudentView {
	private StudentController controller;

	public StudentView() {
		controller = new StudentController();
	}

	public void studentProgram() {
		List<Student> sList = null;
		Student student = null;
		int result = 0;
		theEnd: while (true) {
			int input = printMenu();
			switch (input) {
			case 1:
				sList = controller.selectAllStudents();
				printAllStudent(sList);
				break;
			case 2:
				// SELECT * FROM STUDENT_TBL WHERE STDUENT_ID = 'khuser01'
				String studentId = inputStdId("검색");
				student = controller.selectOneById(studentId);
				printOneStudnet(student);
				break;
			case 3:
				// SELECT * FROM STUDENT_TBL WHERE STDUENT_NAME = '일용자'
				String studnetName = inputStdName();
				sList = controller.selectAllByName(studnetName);
				printAllStudent(sList);
				break;
			case 4:
				//INSERT INTO STUDENT_TBL
				student = inputStudent();
				result = controller.insertStudent(student);
				break;
			case 5:
				// SELECT * FROM STUDNET_TBL WHERE STUDNET_ID ='khuser01'
				studentId = inputStdId("수정");
				student = controller.selectOneById(studentId);
				if(student != null) {
					//있는거
					student = modifyStudnet();
					student.setStudentId(studentId);
					result = controller.updateStudnet(student);
					if(result >0) {
					}else {
					
					}//없는거
				}else {
					
				}
				break;
			case 6:
				studentId = inputStdId("삭제");
				result  = controller.deleteStudent(studentId);
				if(result >0) {
					//성공
				}else {
					//실패
				}
				break;
			case 9:
				student = inputLoginInfo();
				student = controller.studnetLogin(student);
				if(student != null){
					displaySuccess("로그인 성공");
					//로그인 성공
				}else {
					displayError("해당 정보가 존재하지 않습니다.");
					//로그인 실패
				}
					
				break;
				

			
			case 0:
				break theEnd;

			}
		}

	}

	
	private void displayError(String message) {
		// TODO Auto-generated method stub
		System.out.println("서비스 성공 :" +message );
	}

	private void displaySuccess(String message) {
		// TODO Auto-generated method stub
		System.out.println("서비스 실패 :" +message );

	}

	private Student inputLoginInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		String studentPw = sc.next();
		System.out.print("이름 : ");
		String studentId = sc.next();
		Student student = new Student(studentPw, studentId);
		System.out.println(student.toString());
		return student;
	}
	
	private Student modifyStudnet() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		String studentPw = sc.next();
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		System.out.print("나이 : ");
		String age = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine(); // 공백 제거, 엔터 제거
		String address = sc.nextLine();
		System.out.print("취미(,로 구분) : ");
		String hobby = sc.next();
		Student studnet = new Student(studentPw, studentName, 
				gender, age, email, phone, address, hobby);
		
		return studnet;
	}

	private Student inputStudent() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String studentId = sc.next();
		System.out.print("비밀번호 : ");
		String studentPw = sc.next();
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		System.out.print("나이 : ");
		String age = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine(); // 공백 제거, 엔터 제거
		String address = sc.nextLine();
		System.out.print("취미(,로 구분) : ");
		String hobby = sc.next();
		Student student = new Student(studentId, studentPw, studentName, 
				gender, age, email, phone, address, hobby);
		return student;
	}

	private String inputStdName() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름 입력:");
		String studentName = sc.next();
		return studentName;
	}

	private void printOneStudnet(Student student) {
		// TODO Auto-generated method stub
		System.out.println("학생아이디로 조회");
		System.out.printf(
				"이름 : %s, 나이 :%s, 아이디 :%s" + ", 성별: %s, " + "이메일:%s, 전화번호 :%s,주소 :%s" + ",취미 :%s, 가입날짜 : %s\n",
				student.getStudentName(), student.getAge(), student.getStudentId(), student.getGender(),
				student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby(),
				student.getEnrollDate());
	}

	private String inputStdId(String category) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(category +"검색할 아이디 입력:");
		String studentId = sc.next();
		return studentId;
	}


	private void printAllStudent(List<Student> sList) {
		// TODO Auto-generated method stub
		System.out.println("학생 전체 조회");
		for (Student student : sList) {
			System.out.printf(
					"이름 : %s, 나이 :%s, 아이디 :%s" + ", 성별: %s, " + "이메일:%s, 전화번호 :%s,주소 :%s" + ",취미 :%s, 가입날짜 : %s\n",
					student.getStudentName(), student.getAge(), student.getStudentId(), student.getGender(),
					student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby(),
					student.getEnrollDate());
		}
	}

	private int printMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("학생관리 프로그램");
		System.out.println("1.학생전체 조회");
		System.out.println("2.학생 아이디로 조회");
		System.out.println("3.학생 이름으로 조회");
		System.out.println("4.학생 정보 등록");
		System.out.println("5.학생정보 수정 ");
		System.out.println("6.학생정보 삭제 ");
		System.out.print("메뉴 삭제 ");
		int input = sc.nextInt();
		return input;
	}
}
