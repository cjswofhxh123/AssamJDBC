package student.model.vo;

public class Student {
	private String studentId;
	private String studentPwd;
	private String studentName;
	private char gender;
	private String age;
	private String phone;
	private String address;
	private String hobby;
	private String email;
	private String enrollDate;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String studentPwd, String phone, String address, String hobby, String email) {
		super();
		this.studentId = studentId;
		this.studentPwd = studentPwd;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.email = email;
	}

	public Student(String studentId, String studentPwd, String studentName, char gender, String age, String phone,
			String address, String hobby, String email) {
		super();
		this.studentId = studentId;
		this.studentPwd = studentPwd;
		this.studentName = studentName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	@Override
	public String toString() {
		return "학생 [아이디=" + studentId + ", 비번=" + studentPwd + ", 이름=" + studentName
				+ ", 성별=" + gender + ", 나이=" + age + ", 이메일=" + email+ ", 폰번호=" + phone + ", 주소="
				+ address + ", 취미=" + hobby + ", enrollDate=" + enrollDate + "]";
	}




	
	
}
