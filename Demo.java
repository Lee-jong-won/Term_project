import java.util.Arrays;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Building vision_Tower = new Building("vision_Tower");
		Building itconvergence = new Building("itconvergence");
		Building Global_center = new Building("Global_center");
		Building Gachon_hall = new Building("Gachon_hall");

		String person_type; // 확진자를 입력하여 접촉자를 출력하는 2번 모드에서 person_type 값에 따라 입력을 요구하는 질문을 다르게 출력할 때 쓰인다.
		int mode; // 건물 출입인 입력모드, 확진자 입력 및 접촉자 출력 모드를 결정할 때 쓰인다.
		int building_select; // 건물 출입인 입력모드에서 어떤 건물의 출입인을 입력할 것인지 결정할 떄 쓰인다.
		int end_bit_vision = 0; // bit = 0 -> 건물이 더 많은 출입인 데이터를 수용할 수 있다. bit = 1 -> 건물이 더 많은 출입인 데이터를 수용할 수 없다.
		int end_bit_it = 0; // 위와 일치
		int end_bit_global = 0; // 위와 일치
		int end_bit_gachon = 0; // 위와 일치
		int unique_number = 0; // 확진자 입력 및 접촉자 출력 모드에서 학생 또는 교수가 확진됬을 때, 학번을 입력 받는 경우 사용된다.
		String outsider_phone_number; // 확진자 입력 및 접촉자 출력 모드에서 외부인이 확진됬을 때, 핸드폰 번호를 입력 받는 경우 사용된다.

		while (true) {
			/*
			 * while문이 어떻게 동작되는가?) 1.처음에 1번을 입력하면, 건물에 출입하는 사람들의 데이터를 입력하는 모드로 넘어간다. 1-1.건물에
			 * 출입하는 사람들의 데이터를 입력하는 모드로 넘어가면, 건물에 대응되는 번호를 입력한다. 1-2.1을 입력하면, it 대학에 출입하는
			 * 사람들의 데이터를 입력하는 모드로 넘어간다. 1-3.it 대학에 출입하는 사람들의 데이터를 입력하는 모드로 넘어가면, 먼저 어떤 종류의
			 * 사람이 건물에 들어갈 것인지 입력받는다. 1-4.사람 유형을 정하면, 이후에 온도를 입력받는다. 온도가 37.5도 이상이면, 입력을 받지
			 * 않고 다시 사람 유형을 정하는 창으로 넘어간다. // 온도가 37.5이하이면 이후 추가적인 데이터를 입력받는다.
			 * 
			 * 2.건물에 사람 데이터를 입력받는 것이 종료되는 경우는 두가지이다. 수용할 수 있는 최대 데이터를 넘는 경우, 사용자가 인위적으로 3번을
			 * 눌러 입력을 종료하는 경우 2-1.건물데이터당 수용할 수 있는 최대 데이터를 넘는 경우, data is full이라는 경고 메시지가
			 * 출력된다. 2-2.사용자는 데이터를 입력받다가 3번을 눌러서 잠시 입력모드를 종료하고, 2번을 눌러 확진정보를 입력하여 접촉자를 출력할 수
			 * 있다.
			 * 
			 * 3.확진자를 출력한 이후에도 추가적으로 데이터를 더 입력받을 수 있고, 그렇게 갱신된 데이터를 토대로도 확진자와 접촉한 사람들의 정보들을
			 * 출력할 수 있다.
			 * 
			 * 4.3번을 누르면 프로그램이 종료된다.
			 */

			System.out.println("모드를 설정하시오 1번 data 입력, 2번 확진자 정보입력, 3번 종료:");
			mode = keyboard.nextInt();

			if (mode == 1) {
				System.out.println("각 건물에 출입한 사람들의 데이터 입력:\n\n");
				while (true) {
					System.out.println("Building select:1->it대학, 2->비전타워, 3->글로번센터, 4->가천홀, 5->종료");
					building_select = keyboard.nextInt();

					if (building_select == 1) {
						if (end_bit_it == 0)
							end_bit_it = itconvergence.register_person_in_building();
						else
							System.out.println("Data is full");
					} else if (building_select == 2) {
						if (end_bit_vision == 0)
							end_bit_vision = vision_Tower.register_person_in_building();
						else
							System.out.println("Data is full");
					} else if (building_select == 3) {
						if (end_bit_global == 0)
							Global_center.register_person_in_building();
						else
							System.out.println("Data is full");
					} else if (building_select == 4) {
						if (end_bit_gachon == 0)
							end_bit_gachon = Gachon_hall.register_person_in_building();
						else
							System.out.println("Data is full");
					} else
						break;
				}
			} else if (mode == 2) {
				System.out.println("감염자 데이터 입력 단계:\n\n");
				System.out.println("감염자의 유형을 입력하시오:");

				person_type = keyboard.nextLine();
				person_type = keyboard.nextLine();

				if (person_type.equals("Student")) {
					System.out.println("학번을 입력하시오:");
					unique_number = keyboard.nextInt();

					/*
					 * 1.출력함수 호출 building안에 존재하는 접촉자 정보 출력함수를 출력. 2.출력함수는 unique_number 즉 학번을
					 * 받음->building에 출입한 사람들 중 확진자와 접촉한 사람들 search->출력
					 **/
					
					
					
				} else if (person_type.equals("Professor")) {
					System.out.println("학번을 입력하시오:");
					unique_number = keyboard.nextInt();

					/*
					 * 1.출력함수 호출 building안에 존재하는 접족차 정보 출력함수를 출력. 2.출력함수는 unique_number 즉 학번을
					 * 받음->building에 출입한 사람들 중 확진자와 접촉한 사람들 search->출력
					 **/
				} else {
					System.out.println("외부인의 전화번호를 입력하시오:");
					outsider_phone_number = keyboard.nextLine();

					/*
					 * 1.출력함수 호출 building안에 존재하는 접촉자 정보 출력함수를 출력. 2.출력함수는 전화번호를 입력받음->building안에 출입한
					 * 사람들 중 확진자와 접촉한 사람들 search->출력
					 */
				}
			} else
				break;
		}
		
		itconvergence.infectedStudent(unique_number);
		vision_Tower.infectedStudent(unique_number);
		Global_center.infectedStudent(unique_number);
		Gachon_hall.infectedStudent(unique_number);
		
		
		vision_Tower.searchTime(unique_number);
		vision_Tower.searchLecture(unique_number);
		itconvergence.searchTime(unique_number);
		itconvergence.searchLecture(unique_number);
		Global_center.searchTime(unique_number);
		Global_center.searchLecture(unique_number);
		Gachon_hall.searchTime(unique_number);
		Gachon_hall.searchLecture(unique_number);

		// 입력된 데이터가 올바르게 잘 입력됬는지 확인하기 위한 용도로 작성해놨습니다.
		/*
		System.out.println("\n\n\n");

		vision_Tower.data_print_out_outsider();
		vision_Tower.data_print_out_professor();
		vision_Tower.data_print_out_student();

		System.out.println("\n\n");

		itconvergence.data_print_out_outsider();
		itconvergence.data_print_out_professor();
		itconvergence.data_print_out_student();

		System.out.println("\n\n");

		Global_center.data_print_out_outsider();
		Global_center.data_print_out_professor();
		Global_center.data_print_out_student();

		System.out.println("\n\n");

		Gachon_hall.data_print_out_outsider();
		Gachon_hall.data_print_out_professor();
		Gachon_hall.data_print_out_student();
		*/

	}

}
