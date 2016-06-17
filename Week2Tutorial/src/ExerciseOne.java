import java.util.Scanner;

public class ExerciseOne {

	public static void main(String[] args) {
		System.out.println("Give me a number.\n" + "I will check if this number is a multiple of 2");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		boolean check = false;
		check = isEven(number);
		System.out.println(check);
		sc.close();
		
	}
	
	/* part1
	public static boolean isEven(int number){
		if (number % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	/* part2
	public static boolean isEven (int number){
		boolean isEven = false;
		if (number % 2 == 0){
			isEven = true;
		}
		else{
			isEven = false;
		}
		return isEven;
	}*/

	/* part3
	public static boolean isEven(int number){
		boolean isEven = (number % 2 == 0) ? true : false; //if (statement) true, =true, else false
		return isEven;
	}*/
	//final version
	public static boolean isEven(int number){
		return (number %2 == 0);
	}
}
