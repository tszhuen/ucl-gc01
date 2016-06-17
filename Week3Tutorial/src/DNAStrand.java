
public class DNAStrand {
	String dna = "";
	
	//Class constructor
	public DNAStrand(String dna){
		this.dna = dna;
	}
	
	//Returns true if the DNA is valid
	public boolean isValidDNA(){

		for(int i = 0; i<dna.length(); i++){
			if (dna.charAt(i) != 'A' && dna.charAt(i) != 'T' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G') {
                return false;
			}
		}
		if(dna.length() < 1){
			return false;
		}
		else{
			return true;
		}	
	}
	
	/*Returns the Watson Crick complement, 
	which is a string representing the complementary DNA strand*/
	public String complementWC(){
		String comp = ""; 
		for(int i = 0; i<dna.length(); i++){
			if(dna.charAt(i) == 'A'){
				comp += 'T';
			}
			else if(dna.charAt(i) == 'T'){
				comp += 'A';
			}
			else if(dna.charAt(i) == 'G'){
				comp += 'C';
			}
			else{
				comp += 'G';
			}
		}
		return comp;
	}
	
	/*Returns the Watson Crick Palindrome, 
	which is the reversed sequence of the complement.*/
	public String palindromeWC(){
		return (new StringBuilder(complementWC()).reverse().toString());
	}
	
	//Returns true if the DNA contains the subsequence seq.
	public boolean containsSequence(String seq){
		return(dna.contains(seq));
	}
	
	//Returns the underlying DNA sequence string.
	public String toString(){
		return dna;
	}
}
