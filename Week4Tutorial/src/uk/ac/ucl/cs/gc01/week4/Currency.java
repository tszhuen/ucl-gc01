package uk.ac.ucl.cs.gc01.week4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Currency {
	
	static ArrayList<String> currencies = new ArrayList<String>(Arrays.asList("Select", "GDB", "USD", "YEN", "EU"));
	static double[] rates = new double[] {0, 1, (1/0.6565), (1/0.005394), 0.6564};
	static int gdb = 1;
	
    	Double numberGot;
        String output;	
        int currentCurrency;
        public File record;
    
    public void conversion(int newCur) {
    	
    	switch (currentCurrency) {
            case 1:
            	output = String.format("%.2f", numberGot * rates[newCur]);
                CurrencyConverter.converted.setText(output);
                break;
            case 2:
            	output = String.format("%.2f", ((gdb / rates[2]) * numberGot) * rates[newCur]);
                CurrencyConverter.converted.setText(output);
                break;
            case 3:
            	output = String.format("%.2f", ((gdb / rates[3]) * numberGot) * rates[newCur]);
                CurrencyConverter.converted.setText(output);
                break;
            case 4:
            	output = String.format("%.2f", ((gdb / rates[4]) * numberGot) * rates[newCur]);
                CurrencyConverter.converted.setText(output);
                break;
            default:
                System.out.println("Error");
    	}
    	printToFile(currentCurrency, numberGot, newCur, output);
    }

	public boolean onlyNumbers(String text) {
		try {
			numberGot = Double.valueOf(text);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(false);
		}
		return false; 
	}
    
    public void printToFile(int currentCurrency, Double numberGot, int newCur, String output) {
        try {
            record = new File("conversionRecord.txt");
            if (!record.exists()) {
                record.createNewFile();
            }
        } 
        catch (IOException e) {
            System.out.print("Error, cannot create file.");
            e.printStackTrace();
        }
        
        BufferedWriter doc = null;

        try {
            doc = new BufferedWriter(new FileWriter("conversionRecord.txt", true));
            doc.write("From: " + currencies.get(currentCurrency) + " Amount: " + numberGot + " To: " + currencies.get(newCur) + output + "\n");
            doc.flush();
        } 
        catch (IOException ioe) {
            System.out.println("Error, cannot write to file");
        } finally {
            if (doc != null) try {
                doc.close();
            } catch (IOException e) {};
        }

    }
}
