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
	public Person[] data = new Person[3]; // �ִ� ������ ���差�� �̸� ���س��´� --> ������ �Էµ� �����Ͱ� �� ����Ǿ� �ִ��� Ȯ���ϱ� ���� �迭 ũ�⸦ 3���� �س�����,
											// ���� ���α׷������� 3�� �ٸ� ���� �ٲ� ����.
	private int student_in_building = 0; // building ��ü �ȿ� ����� �л� ��ü �� ---> ���� ������ �ʾ����� Ȥ�� ���� �����ص�
	private int professor_in_building = 0; // building ��ü �ȿ� ����� ���� ��ü �� ---> ��������
	private int people_in_building = 0; // building ��ü �ȿ� ����� ��� ��ü �� ----> ��������
	private int outsider_in_building = 0; // building ��ü �ȿ� ����� �ܺ��� ��ü �� ---> ��������
	private int cumulative_num = 0; // 1.���� ��ü �ȿ� �����͸� ���ʷ� �������� ������ ��, ���δ�. 2.person�� reference�� �����ϴ� �迭�� 0 �ε�������
									// ���ʴ�� ��ü���� ���ǵǾ� �ϹǷ� 0���� ���� �ʱ�ȭ �س��´�.
	private String building_name; // �ǹ� �̸��� ����ȴ�.

	public Building(String newname) {
		// demo class���� ���� ��ü�� ������ �� ���δ�.
		building_name = newname;
	}

	public int register_person_in_building() {
		/*
		 * 1.���� ������ ���� �ִ� ������ ���差�� �Ѵ��� üũ�Ͽ� ���� ������, � ������ ��������Ͱ� person�� �迭�� �������
		 * user���� �����. 2.1���� ������ �л��� ���� ������ �Է¹ް�, 2���� ������ ������ ���� ������ �Է¹ް�, 3���� ������ �ܺ���
		 * ���� ������ �Է¹޴´�. �׸��� 4���� �Է��ϸ� �Է��� �����ϰ� 0�� ��ȯ�Ѵ�. 3.��ȯ���� 1�̶�� ���� building ��ü�� ���̻�
		 * ��� ��ü�� ������ �� ������ �ǹ��ϰ�, 0�̶�� ���� building ��ü�� ���� ��� ��ü�� ������ �� ������ �ǹ��Ѵ�.
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
		 * student,professor,outsider�� ������ �Է¹ޱ� ��, �µ��� �Է¹޴� �� ���ȴ�.
		 */
		if (temper >= 37.5)
			return 1;
		else
			return 0;
	}

	public void for_Student() {
		// TODO Auto-generated method stub
		/*
		 * 1.���� �µ��� �Է¹ް�, �Էµ� �µ��� 37.5���� �ѱ��� ������, person �迭�� student ��ü�� �����Ѵ�. 2.student
		 * ��ü�� reference�� ����� person �迭�� element�� method�� input_data�� ȣ���Ͽ�, �����͸� �Է¹޴´�.
		 */
		double read_temper;
		System.out.println("�µ��� ���� �Է��մϴ�:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("�µ��� 37.5�� �Ѿ ������ �Ұ��մϴ�.");
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
		 * ���� for_student�� ���� ��ġ
		 */

		double read_temper;
		System.out.println("�µ��� ���� �Է��մϴ�:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("�µ��� 37.5�� �Ѿ ������ �Ұ��մϴ�.");
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
		 * ���� professor�� ������ġ
		 */
		double read_temper;
		System.out.println("�µ��� ���� �Է��մϴ�:");
		read_temper = keyboard.nextDouble();

		if (check_temperature(read_temper) == 1)
			System.out.println("�µ��� 37.5�� �Ѿ ������ �Ұ��մϴ�.");
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
							"�� �ð�:" + temp.Entering_time + " " + "�й�:" + temp.Professor_number + " �̸�:" + temp.Name
									+ " ��ȭ��ȣ:" + temp.phone_number + " ����list:" + Arrays.toString(temp.Lecture_list));
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
					System.out.println("�� �ð�:" + temp.Entering_time + " " + "��ȭ��ȣ:" + temp.phone_number + " "
							+ "�ܺ��� �̸�:" + temp.Name);

				}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////\
	// �л� //

	Student temp;

	private String[] searchStudent(int studentNumber) { // ���� �л� ���� �迭
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

	// Ȯ���� ���� ���
	public void infectedStudent(int studentNumber) {
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {
			System.out.println();
			System.out.println("Ȯ���ڰ� �ӹ� ���ǽ�: " + building_name);
			System.out.println("Ȯ���� ����: " + Arrays.toString(searchStudent(studentNumber)));
			System.out.println();
		}
	}

	public void searchTime(int studentNumber) { // �ð��� ��ģ �л� ���
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {

			String[] time = searchStudent(studentNumber)[3].split(":");
			LocalTime infectedStudentTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
					Integer.parseInt(time[2])); // ������ �ð�

			LocalTime pluse2Time = infectedStudentTime.plus(2, ChronoUnit.HOURS); // ������ �ð� +2
			LocalTime minus2Time = infectedStudentTime.minus(2, ChronoUnit.HOURS); // ������ �ð� -2

			// �� �迭 �ð� ��
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Student temp = (Student) data[i];

					String[] ArrStudentTime = temp.Entering_time.split(":");
					LocalTime StudentTime = LocalTime.of(Integer.parseInt(ArrStudentTime[0]),
							Integer.parseInt(ArrStudentTime[1]), Integer.parseInt(ArrStudentTime[2]));

					if (StudentTime.isAfter(minus2Time) && StudentTime.isBefore(pluse2Time)) {
						if (Arrays.deepEquals(searchStudent(studentNumber), temp.introduce) == false) {
							System.out.println("Ȯ���ڿ� ���� �ǹ� +-2�ð� ������: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
				}
			}
		}
	}

	public void searchLecture(int studentNumber) { // ���ǰ� ��ģ �л� ���
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchStudent(studentNumber), standard) == false) {
			
			
			// ������ ���� String -> Array
			String[] ArrLecture = searchStudent(studentNumber)[4].split(",");
			ArrLecture[0] = ArrLecture[0].substring(1, ArrLecture[0].length()).trim(); // [ ����
			ArrLecture[1] = ArrLecture[1].trim();
			ArrLecture[2] = ArrLecture[2].substring(0, ArrLecture[2].length()-1).trim(); // ] ����
			
			List<String> listInfectedStudentLecture = new ArrayList<String>(Arrays.asList(ArrLecture));
			listInfectedStudentLecture.remove("null"); // Ȯ���� ���� �� null�� ����
			
			System.out.println("�����ڰ� ���� ����: " + listInfectedStudentLecture);
			System.out.println();
			
			
			
			// �� �迭 ���� ��
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Student temp = (Student) data[i];
					
					String[] studentLecture = Arrays.toString(temp.Lecture_list).split(",");
					studentLecture[0] = studentLecture[0].substring(1, studentLecture[0].length()).trim(); // [ ����
					studentLecture[1] = studentLecture[1].trim();
					studentLecture[2] = studentLecture[2].substring(0, studentLecture[2].length()-1).trim(); // ] ����
					
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
							System.out.println("�����ڿ� ���ǰ� ��ģ �л�: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
							
					
				}

			}

		}

	}
	/////////////////////////////////////////////////////////////////////////////
	// ����
	
	Professor temp1;

	private String[] searchProfessor(int professorNumber) { // ���� ���� ���� �迭
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

	// Ȯ���� ���� ���
	public void infectedProfessor(int professorNumber) {
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {
			System.out.println();
			System.out.println("Ȯ���ڰ� �ӹ� ���ǽ�: " + building_name);
			System.out.println("Ȯ���� ����: " + Arrays.toString(searchProfessor(professorNumber)));
			System.out.println();
		}
	}

	public void searchProfessorTime(int professorNumber) { // �ð��� ��ģ ���� ���
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {

			String[] time = searchProfessor(professorNumber)[3].split(":");
			LocalTime infectedProfessorTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
					Integer.parseInt(time[2])); // ������ �ð�

			LocalTime pluse2Time = infectedProfessorTime.plus(2, ChronoUnit.HOURS); // ������ �ð� +2
			LocalTime minus2Time = infectedProfessorTime.minus(2, ChronoUnit.HOURS); // ������ �ð� -2

			// �� �迭 �ð� ��
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Student) {
					Professor temp = (Professor) data[i];

					String[] ArrProfessorTime = temp.Entering_time.split(":");
					LocalTime ProfessorTime = LocalTime.of(Integer.parseInt(ArrProfessorTime[0]),
							Integer.parseInt(ArrProfessorTime[1]), Integer.parseInt(ArrProfessorTime[2]));

					if (ProfessorTime.isAfter(minus2Time) && ProfessorTime.isBefore(pluse2Time)) {
						if (Arrays.deepEquals(searchProfessor(professorNumber), temp.introduce) == false) {
							System.out.println("Ȯ���ڿ� ���� �ǹ� +-2�ð� ������: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
				}
			}
		}
	}

	public void searchProfessorLecture(int professorNumber) { // ���ǰ� ��ģ ���� ���
		String[] standard = new String[5];
		if (Arrays.deepEquals(searchProfessor(professorNumber), standard) == false) {
			
			
			// ������ ���� String -> Array
			String[] ArrLecture = searchProfessor(professorNumber)[4].split(",");
			ArrLecture[0] = ArrLecture[0].substring(1, ArrLecture[0].length()).trim(); // [ ����
			ArrLecture[1] = ArrLecture[1].trim();
			ArrLecture[2] = ArrLecture[2].substring(0, ArrLecture[2].length()-1).trim(); // ] ����
			
			List<String> listInfectedProfessorLecture = new ArrayList<String>(Arrays.asList(ArrLecture));
			listInfectedProfessorLecture.remove("null"); // Ȯ���� ���� �� null�� ����
			
			System.out.println("�����ڰ� ���� ����: " + listInfectedProfessorLecture);
			System.out.println();
			
			
			
			// �� �迭 ���� ��
			for (int i = 0; i < cumulative_num; i++) {
				if (data[i] instanceof Professor) {
					Professor temp = (Professor) data[i];
					
					String[] ProfessorLecture = Arrays.toString(temp.Lecture_list).split(",");
					ProfessorLecture[0] = ProfessorLecture[0].substring(1, ProfessorLecture[0].length()).trim(); // [ ����
					ProfessorLecture[1] = ProfessorLecture[1].trim();
					ProfessorLecture[2] = ProfessorLecture[2].substring(0, ProfessorLecture[2].length()-1).trim(); // ] ����
					
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
							System.out.println("�����ڿ� ���ǰ� ��ģ ����: " + Arrays.toString(temp.introduce));
							System.out.println();
						}
					}
							
					
				}

			}

		}

	}
}
