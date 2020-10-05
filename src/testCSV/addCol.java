package testCSV;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class addCol {
	
		public addCol(String title) {
				JTable table = tableui.getTable();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addColumn(title);
			}
}
