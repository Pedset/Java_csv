package testCSV;

import javax.swing.table.DefaultTableModel;

public class addRow {
	
	public addRow() {
		DefaultTableModel model = (DefaultTableModel) tableui.getTable().getModel();
		int row = tableui.getTable().getSelectedRow();
		if(row == -1) 	model.addRow(new Object[] {});
		else 			model.insertRow((row+1), new Object[] {});
	}

}
