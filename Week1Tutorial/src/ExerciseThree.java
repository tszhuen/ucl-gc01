
public class ExerciseThree {

	public static void main(String[] args) {
		int numbers[] = new int [20];
		numbers[0] = 1;
		System.out.println(numbers[0]);
		
		for(int i = 1; i < 20; i++){
			numbers[i] = 2*numbers[i-1];
			System.out.println(numbers[i]);
		}
		
		double mean[] = new double [20];
		mean[0] = 1;
		System.out.println(mean[0]);
		
		for (int j = 1; j < 19; j++){
			mean[j] = (numbers[j-1] + numbers[j+1]) / 2.0;
			System.out.println(mean[j]);
		}
		mean[19] = numbers[19];
		System.out.println(mean[19]);
	}

}
