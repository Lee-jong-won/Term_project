package TermProject;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.ListSelectionEvent;

public class Building implements Entering {
	private static final String[] NULL = null;
	Scanner keyboard = new Scanner(System.in);
	public Person[] data = new Person[3]; // 최대 데이터 저장량을 미리 정해놓는다 --> 지금은 입력된 데이터가 잘 저장되어 있는지 확인하기 위해 배열 크기를 3으로 해놨지만,
											// 실제 프로그램에서는 3을 다른 수로 바꿀 예정.
	private int student_in_building = 0; // building 객체 안에 저장된 학생 객체 수 ---> 딱히 쓰이진 않았지만 혹시 몰라서 정의해둠
	private int professor_in_building = 0; // building 객체 안에 저장된 교수 객체 수 ---> 마찬가지
	private int people_in_building = 0; // building 객체 안에 저장된 사람 객체 수 ----> 마찬가지
	private int outsider_in_building = 0; // building 객체 안에 저장된 외부인 객체 수 ---> 마찬가지
	private int cumulative_num = 0; // 1.빌딩 객체 안에 데이터를 차례로 누적시켜 저장할 때, 쓰인다. 2.person의 reference를 저장하는 배열의 0 인덱스부터
									// 차례대로 객체들이 정의되야 하므로 0으로 먼저 초기화 해놓는다.
	private String building_name; // 건물 이름이 저장된다.

	public Building(String newname) {
		// demo class에서 빌딩 객체를 정의할 때 쓰인다.
		building_name = newname;
	}

	public int register_person_in_building() {
		/*
		 * 1.누적 데이터 값이 최대 데이터 저장량을 넘는지 체크하여 넘지 않으면, 어떤 종류의 사람데이터가 person형 배열에 저장될지
		 * user에게 물어본다. 2.1번을 누르면 학생에 대한 정보를 입력받고, 2번을 누르면 교수에 대한 정보를 입력받고, 3번을 누르면 외부인
		 * 대한 정보를 입력받는다. 그리고 4번을 입력하면 입력을 종료하고 0을 반환한다. 3.반환값이 1이라는 것은 building 객체가 더이상
		 * 사람 객체를 저장할 수 없음을 의미하고, 0이라는 것은 building 객체가 아직 사람 객체를 저장할 수 있음을 의미한다.
		 * 
		 **/

		int determine;
		while (true) {
			if (cumulative_num == 3)
				return 1;

			System.out.println("Student->1, Professor->2, Outsider->3 quit->4");
			determine = keyboard.nextInt();

			if (determine == 1)
				for_Student();
			else if (determine == 2)
				for_Professor();
			else if (determine == 3)
				for_Outsider();
			else
				return 0;
		}
	}

	public int check_temperature(double temper) {
		/*
		 * student,professor,outsider의 정보를 입력받기 전, 온도를 입력받는 데 사용된다.
		 */
		if (temper >= 37.5)
			return 1;
		else
			return 0;
	}

	public void for_Student() {
		// TODO Auto-generated method stub
		/*
		 * 1.먼저 온도를 입력받고, 입력된 온도가 37.5도를 넘기지 않으면, person 배열에 student 객체를 저장한다. 2.student
		 * 객체의 reference가 저장된 person 배열의 element의 method인 input_data를 호출하여, 데이터를 입력받는다.
		 */
		double read_temper;
		System.out.println("온도를 먼저 입력합니다:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("온도가 37.5를 넘어서 출입이 불가합니다.");
		else {
			System.out.println("Input student's information:\n\n");
			data[cumulative_num] = new Student();
			data[cumulative_num].input_data(); // polymorphism

			cumulative_num++;
			people_in_building++;
			student_in_building++;
		}
	}

	public void for_Professor() {
		// TODO Auto-generated method stub
		/*
		 * 위의 for_student와 설명 일치
		 */

		double read_temper;
		System.out.println("온도를 먼저 입력합니다:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("온도가 37.5를 넘어서 출입이 불가합니다.");
		else {
			System.out.println("Input Professor's information:\n\n");
			data[cumulative_num] = new Professor();
			data[cumulative_num].input_data(); // polymorphism

			cumulative_num++;
			people_in_building++;
			professor_in_building++;
		}
	}

	public void for_Outsider() {
		// TODO Auto-generated method stub
		/*
		 * 위의 professor와 설명일치
		 */
		double read_temper;
		System.out.println("온도를 먼저 입력합니다:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("온도가 37.5를 넘어서 출입이 불가합니다.");
		else {
			System.out.println("Input Outsider's information:\n\n");
			data[cumulative_num] = new Outsider();
			data[cumulative_num].input_data(); // polymorphism

			cumulative_num++;
			people_in_building++;
			outsider_in_building++;
		}
	}

	public void data_print_out_student() {
		if (student_in_building == 0)
			System.out.println("there is no student in this building" + "->" + building_name);
		else {
			System.out.println("Student_Data print out in " + building_name);
			for (int i = 0; i < cumulative_num; i++)
				if (data[i] instanceof Student) {
					Student temp = (Student) data[i];
					System.out.println(Arrays.toString(temp.introduce));
				}
		}
	}

	public void data_print_out_professor() {
		if (professor_in_building == 0)
			System.out.println("there is no professor in this building" + "->" + building_name);
		else {
			System.out.println("Professor_Data print out in " + building_name);
			for (int i = 0; i < cumulative_num; i++)
				if (data[i] instanceof Professor) {
					Professor temp = (Professor) data[i];
					System.out.println(
							"들어간 시간:" + temp.Entering_time + " " + "학번:" + temp.Professor_number + " 이름:" + temp.Name
									+ " 전화번호:" + temp.phone_number + " 강의list:" + Arrays.toString(temp.Lecture_list));
				}
		}
	}

	public void data_print_out_outsider() {
		if (outsider_in_building == 0)
			System.out.println("there is no outsider in this building" + "->" + building_name);
		else {
			System.out.println("Outsider_Data print out in " + building_name);
			for (int i = 0; i < cumulative_num; i++)
				if (data[i] instanceof Outsider) {
					Outsider temp = (Outsider) data[i];
					System.out.println("들어간 시간:" + temp.Entering_time + " " + "전화번호:" + temp.phone_number + " "
							+ "외부인 이름:" + temp.Name);

				}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////\
	// 학생 //

	Student temp;

	private String[] searchStudent(int studentNumber) { // 감염 학생 정보 배열
		String[] infectedStudent = new String[5];
		for (int i = 0; i < cumulative_num; i++)
			if (data[i] instanceof Student) {
				temp = (Student) data[i];
				if (Integer.compare(studentNumber, temp.Student_number) == 0) {
					infectedStudent = temp.introduce;
				}
			}
		return infectedStudent;
	}

	// 확진자 정보 출력
	public void infectedStudent(int studentNumber) {
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {
			System.out.println();
			System.out.println("확진자가 머문 강의실: " + building_name);
			System.out.println("확진자 정보: " + Arrays.toString(searchStudent(studentNumber)));
			System.out.println();
		}
	}

	public void searchTime(int studentNumber) { // 시간이 겹친 학생 출력
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {

			String[] time = searchStudent(studentNumber)[3].split(":");
			LocalTime infectedStudentTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
					Integer.parseInt(time[2])); // 감염자 시간

			LocalTime pluse2Time = infectedStudentTime.plus(2, ChronoUnit.HOURS); // 감염자 시간 +2
			LocalTime minus2Time = infectedStudentTime.minus(2, ChronoUnit.HOURS); // 감염자 시간 -2

			// 각 배열 시간 비교
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Student temp = (Student) data[i];

					String[] ArrStudentTime = temp.Entering_time.split(":");
					LocalTime StudentTime = LocalTime.of(Integer.parseInt(ArrStudentTime[0]),
							Integer.parseInt(ArrStudentTime[1]), Integer.parseInt(ArrStudentTime[2]));

					if (StudentTime.isAfter(minus2Time) && StudentTime.isBefore(pluse2Time)) {
						if (Arrays.deepEquals(searchStudent(studentNumber), temp.introduce) == false) {
							System.out.println("확진자와 같은 건물 +-2시간 출입자: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
				}
			}
		}
	}

	public void searchLecture(int studentNumber) { // 강의가 겹친 학생 출력
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {
			
			
			// 감염자 강의 String -> Array
			String[] ArrLecture = searchStudent(studentNumber)[4].split(",");
			ArrLecture[0] = ArrLecture[0].substring(1, ArrLecture[0].length()).trim(); // [ 제거
			ArrLecture[1] = ArrLecture[1].trim();
			ArrLecture[2] = ArrLecture[2].substring(0, ArrLecture[2].length()-1).trim(); // ] 제거
			
			List<String> listInfectedStudentLecture = new ArrayList<String>(Arrays.asList(ArrLecture));
			listInfectedStudentLecture.remove("null"); // 확진자 강의 중 null값 제거
			
			System.out.println("감염자가 들은 강의: " + listInfectedStudentLecture);
			System.out.println();
			
			
			
			// 각 배열 강의 비교
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Student temp = (Student) data[i];
					
					String[] studentLecture = Arrays.toString(temp.Lecture_list).split(",");
					studentLecture[0] = studentLecture[0].substring(1, studentLecture[0].length()).trim(); // [ 제거
					studentLecture[1] = studentLecture[1].trim();
					studentLecture[2] = studentLecture[2].substring(0, studentLecture[2].length()-1).trim(); // ] 제거
					
					boolean check = false;
					
					loopOut:
					for (int j = 0; j < studentLecture.length; j++) {
						for (int z = 0; z < listInfectedStudentLecture.size(); z++) {
							if (studentLecture[j].equals(listInfectedStudentLecture.get(z))) {
								check = true;
								break loopOut;
							} 
						}

					}
					if (check == true) {
						if (Arrays.deepEquals(searchStudent(studentNumber), temp.introduce) == false) {
							System.out.println("감염자와 강의가 겹친 학생: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
							
					
				}

			}

		}

	}
	/////////////////////////////////////////////////////////////////////////////
	// 교수
	
	Professor temp1;

	private String[] searchProfessor(int professorNumber) { // 감염 교수 정보 배열
		String[] infectedProfessor = new String[5];
		for (int i = 0; i < cumulative_num; i++)
			if (data[i] instanceof Student) {
				temp1 = (Professor) data[i];
				if (Integer.compare(professorNumber, temp1.Professor_number) == 0) {
					infectedProfessor = temp1.introduce;
				}
			}
		return infectedProfessor;
	}

	// 확진자 정보 출력
	public void infectedProfessor(int professorNumber) {
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {
			System.out.println();
			System.out.println("확진자가 머문 강의실: " + building_name);
			System.out.println("확진자 정보: " + Arrays.toString(searchProfessor(professorNumber)));
			System.out.println();
		}
	}

	public void searchProfessorTime(int professorNumber) { // 시간이 겹친 교수 출력
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {

			String[] time = searchProfessor(professorNumber)[3].split(":");
			LocalTime infectedProfessorTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
					Integer.parseInt(time[2])); // 감염자 시간

			LocalTime pluse2Time = infectedProfessorTime.plus(2, ChronoUnit.HOURS); // 감염자 시간 +2
			LocalTime minus2Time = infectedProfessorTime.minus(2, ChronoUnit.HOURS); // 감염자 시간 -2

			// 각 배열 시간 비교
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Professor temp = (Professor) data[i];

					String[] ArrProfessorTime = temp.Entering_time.split(":");
					LocalTime ProfessorTime = LocalTime.of(Integer.parseInt(ArrProfessorTime[0]),
							Integer.parseInt(ArrProfessorTime[1]), Integer.parseInt(ArrProfessorTime[2]));

					if (ProfessorTime.isAfter(minus2Time) && ProfessorTime.isBefore(pluse2Time)) {
						if (Arrays.deepEquals(searchProfessor(professorNumber), temp.introduce) == false) {
							System.out.println("확진자와 같은 건물 +-2시간 출입자: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
				}
			}
		}
	}

	public void searchProfessorLecture(int professorNumber) { // 강의가 겹친 교수 출력
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {
			
			
			// 감염자 강의 String -> Array
			String[] ArrLecture = searchProfessor(professorNumber)[4].split(",");
			ArrLecture[0] = ArrLecture[0].substring(1, ArrLecture[0].length()).trim(); // [ 제거
			ArrLecture[1] = ArrLecture[1].trim();
			ArrLecture[2] = ArrLecture[2].substring(0, ArrLecture[2].length()-1).trim(); // ] 제거
			
			List<String> listInfectedProfessorLecture = new ArrayList<String>(Arrays.asList(ArrLecture));
			listInfectedProfessorLecture.remove("null"); // 확진자 강의 중 null값 제거
			
			System.out.println("감염자가 맡은 강의: " + listInfectedProfessorLecture);
			System.out.println();
			
			
			
			// 각 배열 강의 비교
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Professor) {
					Professor temp = (Professor) data[i];
					
					String[] ProfessorLecture = Arrays.toString(temp.Lecture_list).split(",");
					ProfessorLecture[0] = ProfessorLecture[0].substring(1, ProfessorLecture[0].length()).trim(); // [ 제거
					ProfessorLecture[1] = ProfessorLecture[1].trim();
					ProfessorLecture[2] = ProfessorLecture[2].substring(0, ProfessorLecture[2].length()-1).trim(); // ] 제거
					
					boolean check = false;
					
					loopOut:
					for (int j = 0; j < ProfessorLecture.length; j++) {
						for (int z = 0; z < listInfectedProfessorLecture.size(); z++) {
							if (ProfessorLecture[j].equals(listInfectedProfessorLecture.get(z))) {
								check = true;
								break loopOut;
							} 
						}

					}
					if (check == true) {
						if (Arrays.deepEquals(searchProfessor(professorNumber), temp.introduce) == false) {
							System.out.println("감염자와 강의가 겹친 교수: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
							
					
				}

			}

		}

	}
}
