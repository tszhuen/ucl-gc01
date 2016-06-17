
public class ExerciseTwo {

	public static void main(String[] args) {
		String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ", "over ", "the ", "lazy ", "dog."};
		arr = remElement(arr, 7);
	}
	
	public static String[] remElement(String[] string, int i){
		int length = string.length;
		String[] newString = new String[length-1];
		for(int j = 0; j<newString.length; j++){
			if(j<i){
				newString[j]=string[j];
			}
			else{
				newString[j]=string[j+1];
			}
			System.out.print(newString[j]);
		}
		return newString;
		
	}

}
