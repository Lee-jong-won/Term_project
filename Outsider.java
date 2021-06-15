import java.util.Scanner;

public class Outsider extends Person {

	Scanner keyboard = new Scanner(System.in);

	public Outsider() {
		Person_type = "Outsider";
	}

	@Override
	public void input_data() {
		// TODO Auto-generated method stub
		System.out.println("input outsider's name:");
		Name = keyboard.nextLine();
		System.out.println("\n");

		System.out.println("input entering time:");
		Entering_time = keyboard.nextLine(); // 시:분:초 형식으로 입력하지 않으면 예외를 발생시키는 defensive coding 필요
		System.out.println("\n");

		System.out.println("input outsider's phone_number");
		phone_number = keyboard.nextLine();
		/* 외부인이므로 file io를 통한 데이터 입력은 불필요하다. */
	}

}
