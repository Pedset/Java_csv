package testCSV;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class delCol {
	
	public delCol(){
		JTable currentTable = tableui.getTable();
	    int[] colsToDelete = currentTable.getSelectedColumns();
	    if(colsToDelete.length == 0) JOptionPane.showMessageDialog(null, "No columns were selected");
	    int nRow = currentTable.getRowCount(), nCol = (currentTable.getColumnCount()-colsToDelete.length);
	    Object[][] newTableData = new Object[nRow][nCol];
	    String[] colnames = new String[currentTable.getColumnCount()-colsToDelete.length];
	    int colCounter = 0;
	    for (int x = 0 ; x < currentTable.getColumnCount() ; x++) {
	    	boolean hit = false;
	    	for (int l = 0 ; l < colsToDelete.length ; l++) {
				if (x == colsToDelete[l]) hit = true;
				}
	    		if (hit) continue;
	    		colnames[colCounter] =(currentTable.getColumnName(x));
	    	colCounter++;
	    }
	    for (int i = 0 ; i < nRow ; i++) {
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
	    currentTable.setModel((new DefaultTableModel(newTableData,colnames)));
	}
}
