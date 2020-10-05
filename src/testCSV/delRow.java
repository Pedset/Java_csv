package testCSV;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class delRow {
	
		public delRow(){
			
			JTable table = tableui.getTable();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int[] rows = table.getSelectedRows();
			for(int i=0;i<rows.length;i++){
				model.removeRow(rows[i]-i);
				}
			}
}
