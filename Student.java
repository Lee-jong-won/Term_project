import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Student extends Person {
	Scanner keyboard = new Scanner(System.in);
	public int Student_number;

	public String[] introduce = new String[5];
	
	public Student() {
		Person_type = "Student";
	}

	@Override
	public void input_data() {
		System.out.println("input entering time:");
		Entering_time = keyboard.nextLine(); // 시:분:초 형식으로 입력하지 않으면 예외를 발생시키는 defensive coding 필요
		System.out.println("\n");

		System.out.println("input student_number");
		Student_number = keyboard.nextInt();

		/*
		 * fileio function call --> argument:학번 (고유번호이므로 fileio function에 인자로학번만 전달해도 될거
		 * 같음) input_Data로부터 입력받은 학번을 바탕으로 명부 텍스트에서 학번에 대응되는 이름,전화번호,강의리스트를 입력받는다.
		 */
		if(Fileio(Student_number) == false)
		{
			FirstWindow window = new FirstWindow("error_message");
			window.setVisible(true);
		}
	}

	public boolean Fileio(int new_number)// 매개변수는 학번으로.
	{
		/*
		 * 입력받은 학번을 토대로 txt 파일에서 학번과 일치하는 학생의 데이터를 모두 읽어와서 멤버 변수에 모두 저장한다. [과정] 1. 한 줄씩
		 * 입력받아 정보를 임시로 변수에 저장한다 1-1. 이때 강의는 듣는 강의의 개수만큼만 저장한다
		 * 
		 * 2. 입력받은 정보의 학번이 매개변수의 학번과 같다면 멤버 변수에 입력받은 정보를 저장한다. 2-2. 강의 개수가 3개 미만이면 나머지는
		 * null로 채워진다 -->예) 만약 강의를 2개 듣는 학생이라면 Lecture_list[2]에는 null이 저장된다. (출력시 null
		 * 아닌 값만 출력)
		 * 
		 * 3.flag는 처음 입력한 학번에 부합하는 정보가 text파일에 존재하는지 여부를 나타내는 변수이다.
		 *  이 변수를 input 함수에서 활용하여, flag가 false면 error 화면을 띄우고, true면 학번에 부합하는 정보를 text파일에서 찾아 저장한다. 
		 */
		String fileName = "Student.txt";
		Scanner inputStream = null;
		boolean flag = false;

		try {
			inputStream = new Scanner(new File(fileName));
			// txt file의 내용을 설명하는 첫번째 줄은 생략한다
			String line = inputStream.nextLine();

			while (inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				String[] data = line.split(","); // ,를 기준으로 정보를 잘라 저장한다

				int StuNumber = Integer.parseInt(data[0]);
				String name = data[1];
				String Phone = data[2];
				String[] lecture = new String[3];
				for(int i = 3; i < data.length; i++) {
					lecture[i - 3] = data[i]; 
				}
				
				if (Integer.compare(new_number, StuNumber) == 0) // 학번과 일치할 경우 정보를 객체의 member 변수에 저장한다
				{
					Name = name;
					phone_number = Phone;
					Lecture_list = lecture;
					
					introduce[0] = Integer.toString(Student_number);
					introduce[1] = name;
					introduce[2] = Phone;
					introduce[3] = Entering_time;
					introduce[4] = Arrays.toString(lecture);
					flag = true;

				}
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file " + fileName);
		}
		inputStream.close();
		
		if(flag == true)
			return true;
		else
			return false;
	}
	
	

}

