
public class CreditCardTester {

	public static void main(String[] args) {
		
		CreditCard cc1 = new CreditCard(10, 2014, "Bob", "Jones", "1234567890123456");
		System.out.println(cc1.toString() +"\n");
		
		CreditCard cc2 = new CreditCard(12, 2016, "Lily", "Lui", "1234567890987654");
		System.out.println(cc2.toString());
	}

}
