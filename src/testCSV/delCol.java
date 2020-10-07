package testCSV;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class delCol {
	
	public delCol(){
		JTable currentTable = tableui.getTable();
	    int[] colsToDelete = currentTable.getSelectedColumns();
	    int nRow = currentTable.getRowCount(), nCol = (currentTable.getColumnCount()-colsToDelete.length);
	    Object[][] newTableData = new Object[nRow][nCol];
	    int colCounter = 0;
	    for (int x = 0 ; x < currentTable.getColumnCount() ; x++) {
	    	boolean hit = false;
	    	for (int l = 0 ; l < colsToDelete.length ; l++) {
				if (x == colsToDelete[l]) hit = true;
				}
	    		if (hit) continue;
	    	newTableData[0][colCounter] =(currentTable.getColumnName(x));
	    	colCounter++;
	    }
	    for (int i = 1 ; i < nRow ; i++) {
	    	colCounter = 0;
	    	for (int j = 0 ; j < currentTable.getColumnCount() ; j++) {
	    		boolean hit = false;
		    	for (int l = 0 ; l < colsToDelete.length ; l++) {
					if (j == colsToDelete[l]) hit = true;
					}
		    		if (hit) continue;
		    		newTableData[i][colCounter] = currentTable.getValueAt(i,j);
		    		colCounter++;
	    		} 
	    	}
	    currentTable.setModel((new DefaultTableModel(newTableData,newTableData[0])));
	}
}

