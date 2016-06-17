import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ExerciseFour {

	public static void main(String[] args) {
		System.out.println("Please give me some numbers, separate them using ' '\nType 0 if you have reached the end of the list.");
		Scanner sc = new Scanner(System.in);
		String newNumber = sc.nextLine();
		
		String[] arr = newNumber.split(" ");
		String[] arr2 = newNumber.split(" 0");
		String arr3 = arr2[0];
		String[] arr4 = arr3.split(" ");
		
		if(arr.length < 50 && !newNumber.contains(" 0")){
			Vector<String> numbers = new Vector<String>(Arrays.asList(arr));
			Collections.sort(numbers);
			System.out.println(numbers);
		}
		else if(newNumber.contains(" 0")){
			Vector<String> numbers = new Vector<String>(Arrays.asList(arr4));
			Collections.sort(numbers);
			System.out.println(numbers);
		}
		sc.close();
	}
}
