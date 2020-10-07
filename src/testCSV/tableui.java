package testCSV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class tableui {
	
	static JTable table	 = null;
	static JFrame jf	 = null;
	static String[][] myArray;
	static ArrayList<ArrayList<String>> currentSheet;
	static JMenuBar	menubar 	 =  new JMenuBar();
	static JMenu[]	menu 		 = {new JMenu("File"), new JMenu("Edit")};
	static JMenuItem[] menuItems = {new JMenuItem("Open File..."),new JMenuItem("Save"), new JMenuItem("Add New Row"),new JMenuItem("Delete Selected Row"),new JMenuItem("Add Column"), new JMenuItem("Delete Selected Column"), new JMenuItem("Sort")};
	private static final String[] btnCommands = { "open", "save", "addRow", "delRow", "addCol", "delCol", "sort"};
	
	
		public tableui()  {
			updateValues(readCSV.getWholeSheet(), 1);
			createTable();
			}
	
		public static JTable getTable() {
			return table;
			}
	
	
		public static void updateValues(ArrayList<ArrayList<String>> sheet, int shift){
	
			currentSheet = sheet;
			int colNum = (sheet.get(0).size());
			
			myArray = new String[sheet.toArray().length-shift][colNum];
			
			for(int i = shift; i < sheet.toArray().length ; i++) {
			    ArrayList<String> row = new ArrayList<>();
			    row = sheet.get(i);
			    myArray[i-shift] =  row.toArray(new String[colNum]);
				} 
			}

		public static String[][] getMyArray() {
			return myArray;
		}

		public static void changedT() {
			updateValues(readCSV.getWholeSheet(), 1);
			if(table != null) {
				table.setModel((new DefaultTableModel(myArray,currentSheet.get(0).toArray())));
				}
			}
		
		public void createTable(){
		
			 jf = new JFrame();
			 jf.setSize(1080,720);
			 jf.setVisible(true);
			 jf.setTitle("table");
			 
			for (JMenu item : menu) {
		  		 menubar.add(item);
			  	}
			
		  	for (int x = 0 ; x < menuItems.length; x++) {
		  		menuItems[x].addActionListener(new MenuActionListener());
		  		menuItems[x].setActionCommand(btnCommands[x]);
		  		if (x<2)  menu[0].add(menuItems[x]);
		  		 else  	  menu[1].add(menuItems[x]);
			  	}

		  	 jf.setJMenuBar(menubar);
		  	 jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			 table = new JTable (new DefaultTableModel(myArray,currentSheet.get(0).toArray()));
			 table.setBounds(30,40,200,300);
			 JScrollPane scrollPane = new JScrollPane (table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			 jf.add(scrollPane);
			}

		class MenuActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
	
				if (e.getActionCommand() == "open") readCSV.readingCSV();
				else if (e.getActionCommand() == "save")	  new saveFile();
				else if (e.getActionCommand() == "addRow")	  new addRow();	
				else if (e.getActionCommand() == "delRow")	  new delRow();
				else if (e.getActionCommand() == "addCol") {
					String colName = JOptionPane.showInputDialog(null, "Column name:");
					if(colName != null && !colName.isEmpty()) new addCol(colName);
					}
				else if (e.getActionCommand() == "delCol")	  new delCol();
				else if (e.getActionCommand() == "sort")	  new comparatorTest();
				}
			}
	}
