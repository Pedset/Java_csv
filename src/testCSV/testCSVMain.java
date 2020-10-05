package testCSV;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class testCSVMain {
	
	public static void main(String[] args) {
		
		try {
			readCSV.loadCSV(new Scanner(new File("sample.csv")));
			}catch (FileNotFoundException e) {
			System.out.println("Failed to load file from Main/n" + e);
			}
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	new tableui();
		    }
		});
	}
}
