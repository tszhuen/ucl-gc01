import java.util.Scanner;

public class ExerciseTwo {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Simple calculator. Please choose an operation:\n	1. Add\n	2. Subtract\n	3. Multiply\n	4. Divide\n	5. Factorial\n	6. Exit");
		int x = scanner.nextInt();
		double res = 0;
		
		while (x >=1 && x <= 4){
			System.out.println("Please give me first number");
			int a = scanner.nextInt();
			System.out.println("Please give me second number");
			int b = scanner.nextInt();
			
			if(x==1){
				res = add(a,b);
			    System.out.println(res);
			}
			
			else if(x==2){
				res = subtract(a,b);
				System.out.println(res);
			}
			
			else if(x==3){
				res = multiply(a,b);
				System.out.println(res);
			}
			
			else if(x==4){
				res = divide(a,b);
				System.out.println(res);
			}
		}	
		
		while (x==5){
			System.out.println("Please give me a number");
			int a = scanner.nextInt();
				res = fact(a);
				System.out.println(res);
		}
		
		if(x==6){
			System.out.println("Bye");
			System.exit(0);
		}
		scanner.close();
	}
			
		public static int add(int a, int b){	
			int result = a+b;
			return result;
		}
	
		public static int subtract(int a, int b){
			int result = a-b;
			return result;
		}
	
		public static int multiply(int a, int b){
			int result = a*b;
			return result;
		}
	
		public static double divide(double a, double b){
			double result = a/b;
			return result;
		}
		
		public static int fact(int a){
			int result;
			
			if(a==1)
				return 1;
			
			result = fact(a-1) * a;
		    	return result;
		}
}