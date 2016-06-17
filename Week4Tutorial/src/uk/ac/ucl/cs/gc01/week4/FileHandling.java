package uk.ac.ucl.cs.gc01.week4;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileHandling {
	public final static void main (String[] args){
		String[] filename = {"file1.txt","file2.txt"};
		String[] path = {
				"/Users/Lily/Documents/OneDrive/UCL/GC01/workspace/Week4Tutorial/src/uk/ac/ucl/cs/gc01/week4/file1.txt",
				"/Users/Lily/Documents/OneDrive/UCL/GC01/workspace/Week4Tutorial/src/uk/ac/ucl/cs/gc01/week4/file2.txt"
		};
		try {
			for(int i = 0; i<path.length; i++){
				System.out.println(filename[i] + " has: ");
				countLines(path[i]);
			}
		} 
		catch (IOException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
		}
		
		
	}
	public static int countLines(String filename) throws IOException{
		LineNumberReader lineReader = new LineNumberReader(new FileReader(filename)); 
		int count = 0; 
		while (lineReader.readLine() != null){
			count++;
		}
		//count = lineReader.getLineNumber() +1;
		lineReader.close();
		System.out.println(count + " rows\n");
		return count;
	}
}
