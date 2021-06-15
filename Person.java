import java.util.Arrays;

abstract public class Person {
	public String phone_number;
	public String Name;
	public String[] Lecture_list = new String[3]; // 보통 수업 3개를 같은 건물에서 계속 듣는 경우는 없으므로, list에 있는 데이터는 총 3개로 설정하였다.
	public String Person_type;
	public String Entering_time; // 시:분:초 형식
	public String studentNumber;
	

	abstract public void input_data();

	public String get_phone_number() {
		return phone_number;
	}

	public String get_Name() {
		return Name;
	}

	public String get_person_type() {
		return Person_type;
	}

	public String[] get_lecture_list() {
		return Lecture_list;
	}

}

