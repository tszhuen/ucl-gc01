import java.util.Scanner;
public class ExerciseThree {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your first name?");
		
		// save user's input in a String variable called 'name'
		String firstname = scanner.nextLine();
		
		System.out.println("What is your Last name?");
		String lastname = scanner.nextLine();
		
		//print welcome message on screen including the saved input
		System.out.println("Hello! I thought that your name might be " + firstname + " " +lastname + "!");
		
		scanner.close();
	}

}
