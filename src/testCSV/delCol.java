package testCSV;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class delCol {
	
	
	public Object[][] getTableData (JTable table) {
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int x = 0 ; x < nCol ; x++) {
	    	tableData[0][x] =(dtm.getColumnName(x));
		}
	    for (int i = 1 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
	}
	
	public delCol(){
		
		JTable table = tableui.getTable();
		
		int[] cols = table.getSelectedColumns();
		
		Object[][] obTable = getTableData(tableui.getTable());
		
		if (cols.length > 0) {
			Object[][] newTableData = new Object[obTable.length][(obTable[0].length-cols.length)];
			
				for (int y = 0 ; y < obTable.length ; y++) {
					int counter = 0;
					for (int z = 0; z < obTable[0].length; z++) {
						boolean hit = false;
						for (int l = 0 ; l < cols.length ; l++) {
							if (z == cols[l]) {
							 hit = true;
								}
							}
						if (hit) {
							continue;
							}
						newTableData[y][counter] = obTable[y][z];
						counter++;
					}
				}
			
			table.setModel((new DefaultTableModel(newTableData,newTableData[0])));
		}
	}
}
