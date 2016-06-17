import java.util.Scanner;


public class ExerciseFour {

	public static void main(String[] args){
		final String[] UNITS = {"B","KB","MB","GB"};
		double x[] = new double [UNITS.length];
		
		System.out.println("Enter file size in bytes");
		Scanner scanner = new Scanner(System.in);
		
		x[0] = scanner.nextInt();		
		for(int i = 1; i < UNITS.length; i++){
			x[i] = (x[i-1]/Math.pow(2,10));
		}
		
		for(int i = 0; i < UNITS.length; i++){
			System.out.println(x[i] +" "+ UNITS[i]);
		}
		
		
		scanner.close();
	}	

		
	
	
}
