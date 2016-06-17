import java.util.Calendar;

public class CreditCard {
	Calendar now = Calendar.getInstance();
	private int expiryMonth = 0;
	private int expiryYear = 0;
	private String firstName = "";
	private String lastName = "";
	private String ccNumber = "";
	
	public CreditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber){
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ccNumber = ccNumber;
	}
	
	//Return the expiry date (month and year) in the format 'MM/YY'. 
	public String formatExpiryDate(){
		return(expiryMonth+"/"+expiryYear);
	}
	
	//Return the full name of the account holder in the format 'firstName lastName'.
	public String formatFullName(){
		return(firstName + " " + lastName);
	}
	
	/*Return the credit card number as a four- block string, 
	where blocks are separated by a single whitespace.*/
	public String formatCCNumber(){
		String fccn = ccNumber.substring(0,4) + " " + ccNumber.substring(4,8) + " " + ccNumber.substring(8,12) + " " + ccNumber.substring(12,16);
		return fccn;
	}
	
	/*Returns true if the expiry date of the credit card
	 is later than the current value provided by the Calendar utility.*/
	public boolean isValid(){
		int currentMonth = now.get(Calendar.MONTH)+1;
		int currentYear = now.get(Calendar.YEAR);
		if((expiryYear > currentYear) || ((expiryYear == currentYear && expiryMonth >= currentMonth))){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	public String toString(){
		return ("Number: " + formatCCNumber() + " \nExpiry date: " + formatExpiryDate() + " \nAccount holder: " + formatFullName() + " \nIs valid: " + isValid());
	}
}
