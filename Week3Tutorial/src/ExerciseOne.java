
public class ExerciseOne {

	public static void main(String[] args) {
		Robot1 r = new Robot1(); 	//start off with a well- charged battery
		r.move(11);					//move around and use up the charge
		r.batteryReCharge(2.5);		//get a new charge
		r.batteryReCharge(0.5);		//add a bit more
		r.move(5);					//move some more
	}

}
