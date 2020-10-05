package testCSV;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class readCSV {
	
	private static String COMMA_DELIMITER 	= ",";
	private static String currentString 	= "";
	private static boolean weHaveQuotation 	= false;
	private static ArrayList<ArrayList<String>> wholeSheet = null;
	
	public static ArrayList<ArrayList<String>> getWholeSheet() {
		return wholeSheet;
	}
	
	public static void readingCSV() {
		
		try {  
			JFileChooser fc = 	null;
			File theFile 	= 	null;
			
			fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files (*csv)", "csv");
            fc.setFileFilter(filter);
            File workingDirectory = 		 new File(System.getProperty("user.dir"));
            fc.setCurrentDirectory(workingDirectory);
            fc.setDialogTitle("Select csv file");
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            	theFile = fc.getSelectedFile();
            	}
				Scanner scanner = new Scanner(new File(theFile.toString()));
				loadCSV(scanner);
			}catch(Exception e) {
			   System.out.println("Something went wrong with readingCSV /n" + e);
		   	}
		}

	public static void loadCSV(Scanner scanner) {
		
		wholeSheet = new ArrayList<ArrayList<String>>();
		try {
			while (scanner.hasNext()) {
				wholeSheet.add(getRows(scanner.nextLine()));
				}
			}catch(Exception e) {
				e.printStackTrace();
				}
		scanner.close();
		tableui.changedT();
		}

	private static ArrayList<String> getRows(String row) {
		ArrayList<String> rowValues = new ArrayList<String>();
		
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				currentString+= rowScanner.next();
					if (!currentString.isEmpty()) {
						if(currentString.charAt(0) == '"') 							weHaveQuotation = true;
						if(currentString.charAt(currentString.length()-1) == '"') 	weHaveQuotation = false;
						}
					if (!weHaveQuotation) {
						rowValues.add(currentString);
						currentString="";
						continue;
						}
				currentString+=",";
			}
			return rowValues;
		}

	}



	
	
	

}
