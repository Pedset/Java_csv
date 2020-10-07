package testCSV;

import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class saveFile {
	
	public saveFile(){
		try {
			PrintWriter pw = new PrintWriter(new File ("javatable.csv"));
			StringBuilder sb = new StringBuilder();
			DefaultTableModel dtm = (DefaultTableModel) tableui.getTable().getModel();
			int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
			for (int x = 0 ; x < nCol ; x++) {
				sb.append(dtm.getColumnName(x));
				if (x != nCol-1) sb.append(",");
			}
			sb.append(System.getProperty("line.separator"));
			for (int i = 0 ; i < nRow ; i++) {
				for (int j = 0 ; j < nCol ; j++) {
					if(dtm.getValueAt(i,j) != null) sb.append(dtm.getValueAt(i,j));
					else sb.append(" ");
					if (j != nCol-1) sb.append(",");
					}
				sb.append(System.getProperty("line.separator"));
				
			}
		        pw.write(sb.toString());
		        pw.flush();
		        pw.close();
		        JOptionPane.showMessageDialog(null, "File saved successfully!");
		        System.out.println("file saved");
		        
			
		}catch(Exception e) {
			System.out.println("Something went wrong trying to save the file /n" + e);
			JOptionPane.showMessageDialog(null, "Something went wrong trying to save the file!",
				      "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
