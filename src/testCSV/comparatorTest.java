package testCSV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class comparatorTest {

	
	
	public comparatorTest(){
		ArrayList<ArrayList<String>> tempSheet = new ArrayList<ArrayList<String>>();
		JTable currentTable = tableui.getTable();
		int selectedCol = currentTable.getSelectedColumn();
		int nRow = currentTable.getRowCount(), nCol = currentTable.getColumnCount();
	
	for (int i = 0 ; i < nRow ; i++) {
		ArrayList<String> rowValues = new ArrayList<String>();
		for (int j = 0 ; j < nCol ; j++) {
			if((String) currentTable.getValueAt(i,j)!= null) rowValues.add((String) currentTable.getValueAt(i,j));
			else rowValues.add("");
	     }
		tempSheet.add(rowValues);
	 }
	
	Comparator<ArrayList<String>> com = new Comparator<ArrayList<String>>() {

		@Override
		public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
			
			if(arg0.get(selectedCol).length() == 0 && arg1.get(selectedCol).length() == 0 ) return 0;
			else if(arg0.get(selectedCol).length() == 0 ) return 1;
			else if(arg1.get(selectedCol).length() == 0 ) return -1;
		
			else {
			String s1 = arg0.get(selectedCol);
			String s2 = arg1.get(selectedCol);
			s1 =s1.replaceAll("\"", "");
			s1 = s1.replaceAll(",", "");
			s2 = s2.replaceAll("\"", "");
			s2 = s2.replaceAll(",", "");
			if(s1.matches("^[+-]?(([1-9][0-9]*)?[0-9](\\.[0-9]*)?|\\.[0-9]+)$") && s2.matches("^[+-]?(([1-9][0-9]*)?[0-9](\\.[0-9]*)?|\\.[0-9]+)$")) {
				double n1 = Double.parseDouble(s1);
				double n2 =  Double.parseDouble(s2);
				if (n1 > n2) return 1;
				else if (n1 < n2) return -1;
				else return 0;
			} else {
				int compareInt = s1.compareTo(s2);
				if (compareInt < 0) return -1;
				if (compareInt > 0) return 1;
			return 0;
			}
		}
		}
	};
	if (selectedCol != -1) {
		Collections.sort(tempSheet, com);
		tableui.updateValues(tempSheet, 0);
		ArrayList<String> colNames = new ArrayList<String>();
		for (int x = 0 ; x < nCol ; x++) {
			colNames.add(currentTable.getColumnName(x));
		}
		tempSheet.add(0, colNames);
		currentTable.setModel((new DefaultTableModel(tableui.getMyArray(),tempSheet.get(0).toArray())));
	}else JOptionPane.showMessageDialog(null, "No columns were selected");
	
	
	
	
	
	}
	
}
