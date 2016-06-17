import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseFive {
	public static void printPascalTriangle(int numRows) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		System.out.println(aList);
		for(int i = 1; i<numRows; i++){
			ArrayList<Integer> bList = new ArrayList<Integer>();
			bList.add(1);
				for(int j = 1; j<i; j++){
					bList.add((aList.get(j-1)) + (aList.get(j)));
				}
			bList.add(1);
			System.out.println(bList);
			aList = bList;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("How many rows do you want the triangle to have?");
		int numRows = sc.nextInt();
		printPascalTriangle(numRows);
		sc.close();
	}

}
