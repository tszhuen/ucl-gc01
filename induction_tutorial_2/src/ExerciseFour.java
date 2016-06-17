import java.util.Scanner;

public class ExerciseFour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = sc.nextLine() ;
		
			if (name.isEmpty()) {
				System.out.println("Fine, don't tell me your name. Goodbye!");
			}else if (name.length() < 2) {
				System.out.println("That doesn't look like a name.");					
			}else {
				System.out.println("Hello! I thought that your name might be "+ name + "!");
			}
			
			sc.close();

	}

}
 