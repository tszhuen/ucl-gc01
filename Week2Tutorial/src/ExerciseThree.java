import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ExerciseThree {

	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 100; i++){
			aList.add(rand.nextInt(100));
		}
		System.out.println(aList);
		int sum = 0;
		
		for(int i = 0; i < aList.size(); i++){
			int checkEven = (int) aList.get(i);
			if(checkEven % 2 == 0){
				sum = sum + checkEven;
			}
			else{
				oddList.add(checkEven);
				aList.remove(i);
			}
		}
		System.out.println(sum);
		for(int j = 0; j < oddList.size(); j++){
			int odd = (int) oddList.get(j);
			aList.add(odd);
		}
		System.out.println(aList);
		Integer[] array = new Integer[aList.size()];
		aList.toArray(array);
		System.out.println("Array contains: " + Arrays.toString(array)); 
	}
}
