import java.util.Random;

class Robot1{
	private double batteryCharge = 5.0; // instance variable
	
	public void batteryReCharge(double c){
		this.batteryCharge = batteryCharge + c;
		System.out.println("Battery charge is: " + batteryCharge);
	}
	
	public void move(int distance){
		int position = 1;
		while(batteryCharge > 0 && distance != 0){
			batteryCharge -= 0.5;
			distance--;
		System.out.print("[" + position + "] ");
		position++;
		}
		if(batteryCharge == 0)
			System.out.println("Out of power!");
	}
}

public class Robot2 extends Robot1{
	
	String[] sayings = new String[0];
	Random random = new Random();
	
	public void setSayings(String[] u){
		this.sayings = u;
	}
	
	public void speak(){
		int number = random.nextInt(sayings.length);
		System.out.println(sayings[number]);
	}
}
