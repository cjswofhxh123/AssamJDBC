package student.model.view;

import java.util.List;
import java.util.Scanner;

import student.controller.StudentController;
import student.model.vo.Student;

public class StudentView {

	private StudentController controller;
	List<Student> sList = null;
	Student student = null;

	public StudentView() {
		controller = new StudentController();
	}

	public void startProgram() {
		while (true) {
			int choice = printMenu();
			finish: switch (choice) {
			case 1:
				sList = controller.printStudentlist();
				if (!sList.isEmpty()) {
					showAllStudent(sList);
				} else {
					displayError("학생 정보가 조회되지 않습니다.");
				}
				break;
			case 2:
				// 아이디로 조회하는 쿼리문 생각해보기(리턴형은 무엇으로? 매개변수는 무엇으로?)
				// SELECT *FROM STUDENT_TBL WHERE STUDENT_ID = 'Khuser01'
				String studentId = inputStudentId();
				student = controller.printStudentById(studentId);
				if (student != null) {
					showStudent(student);
				} else {
					displayError("학생정보가 존재하지 않습니다.");
				}
				// printStudnetById()메소드가 학생 정보를조회, dao의 메소드는 selectOneById()로 명명
				// showStudent() 메소드로 학생 정보를 출력
				break;
			case 3:
				// 쿼리문 생각해보기 (매개변수 유무,리턴형은?)
				String studentName = inputStudentByName();
				sList = controller.printStudentByName(studentName);
				if (!sList.isEmpty()) {
					showAllStudent(sList);
				} else {
					displayError("학생정보가 조회되지 않습니다.");
				}
				// printSudentByName, printSudentName();
				// selectOneByName, selectAllByName()
				// showStudent, showAllStudents ()
				break;
			case 4:
				Student student = inputStudent();
				int result = controller.insertStudent(student);
				if (result > 0) {
					// 성공메시지 출력
					displaySuccess("학생 정보 등록 성공");
				} else {
					// 실패메시지 출력
					displayError("학생 정보 등록 성공");

				}

				break;

			case 5:
//				UPDATE STUDENT_TBL SET STUDENT_PWD = 'pass11', EMAIL = 'khuser01@iei.or.kr', PHONE = '01092920303'
//				, ADDRESS = '서울시 강남구', HOBBY = '코딩,수영' WHERE STUDENT_ID = 'khsuer01';  ;
				student = modifyStudent();
				result = controller.modifyStudent(student);
				if (result > 0) {
					// 성공 메시지 출력
					displaySuccess("학생 정보가 변경되었습니다");
				} else {
					// 실패 메시지 출력
					displayError("학생 정보가 실패하엿습니다.");
				}

				break;

			case 6:
				// 쿼리문 생각해보기 (매개변수 필요 유무,반환형)
				// DELETE FROM STUDENT_TBL WHERE STUDENT_ID = 'khuser01';
				studentId = inputStudentId();
				result = controller.deleteStudent(studentId);
				if (result > 0) {
					// 성공메시지 출력
					displaySuccess("학생 정보 삭제 성공");
				} else {
					// 실패 메시지 출력
					displayError("학생 정보 삭제 실패");
				}
				break;
			case 7:
				break;
			case 8:
				break finish;
			}

		}
	}

	private Student modifyStudent() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String studentId = sc.next();
		System.out.println("아이디:");
		System.out.println("이메일:");
		String email = sc.next();
		System.out.println("전화번호:");
		String phone = sc.next();
		System.out.println("주소 :");
		String address = sc.next();
		sc.nextLine();
		System.out.println("비밀번호 :");
		String studentPw = sc.next();
		System.out.println("취미 :");
		String hobby = sc.next();
		Student student = new Student(studentId, email, phone, address, studentPw, hobby);
		return student;
	}

	private String inputStudentByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 이름으로 출력(이름으로 조회)");
		System.out.printf("학생 이름 입력");
		String getStudentName = sc.next();
		// TODO Auto-generated method stub
		return getStudentName;
	}

	private void showStudent(Student student) {
		System.out.println("학생 정보 출력(아이디로 조회)");
		System.out.printf(
				"이름 : %s, 나이 :%s, 아이디 :%s" + ", 성별: %s, " + "이메일:%s, 전화번호 :%s,주소 :%s" + ",취미 :%s, 가입날짜 : %s\n"
				, student.getStudentName(), student.getAge(), student.getStudentId(), student.getGender(),
				student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby(), student.getEnrollDate());
	}

	private String inputStudentId() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 아이디로 조회");
		System.out.println("학생 아이디 입력:");
		String studentIdString = sc.next();
		return studentIdString;
	}

//	private String inputStudentId(List<Student> sList) {
//		// TODO Auto-generated method stub
//		System.out.println("학생 이름 정보 출력");
//		for (Student student : sList) {
//			System.out.printf("이름 : %s", student.getStudentName());
//		}
//
//		return null;
//	}

	private Student inputStudent() {
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
//			Student student = new Student();
//			student.setStudentId(studentId);
		Student student = new Student(studentId, studentPw, studentName, gender, age, email, phone, address, hobby);
		return student;
	}

	private void displayError(String message) {
		// TODO Auto-generated method stub
		System.out.println("[서비스 성공] :" + message);
	}

	private void displaySuccess(String message) {
		// TODO Auto-generated method stub
		System.out.println("[서비스 실패]:" + message);

	}

	private void showAllStudent(List<Student> sList) {
		// TODO Auto-generated method stub
		System.out.println("학생 전체 정보 출력");
		for (Student student : sList) {
			System.out.printf(
					"이름 : %s, 나이 :%s, 아이디 :%s" + ", 성별: %s, " + "이메일:%s, 전화번호 :%s,주소 :%s" + ",취미 :%s, 가입날짜 : %s\n"
					, student.getStudentName(), student.getAge(), student.getStudentId(), student.getGender(),
					student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby(), student.getEnrollDate());
		}
	}

	public int printMenu() {
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
