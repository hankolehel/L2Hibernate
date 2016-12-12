package edu.ubb.cs.idde.SQLListingGUI.GUIElements;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


//import edu.ubb.cs.idde.SQLDataHibernate.DAO.DAOFactory;

import edu.ubb.cs.idde.SQLDataCollecting.DAO.CarDAO;
import edu.ubb.cs.idde.SQLDataCollecting.DAO.DAOFactory;
import edu.ubb.cs.idde.SQLDataCollectingHibernate.Model.CarData;

public class MyJFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String[] availableLanguages = {"English", "Hungarian", "Bosnian"};
	private JComboBox boxOfLanguages = new JComboBox();
	
	public MyJPanel panel1, btnPanel, boxPanel;
	public JPanel container = new JPanel();
	public JButton b1;
	//public ConnectionQuery conn;
	private String username;
	private String password;
	private JTable table = new JTable();
	private ResourceBundle language;
	private Locale[] locales ={
			new Locale("en","EN"),
			new Locale("hu","HU"),
			new Locale("bo","BO")
	};
	
	/*public MyJFrame(){
		this("default");
	}
	*/
	public MyJFrame() {
		super("Feladat");

		for(int i=0;i < availableLanguages.length; i++)
			boxOfLanguages.addItem(availableLanguages[i]);
		
		boxOfLanguages.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		
		panel1 = new MyJPanel(0, 0, 600, 800,3);

		
		this.setMinimumSize(new Dimension(600, 400));

		
		


		btnPanel = new MyJPanel(0,0,200,200,1);
		//btnPanel.add(b1);
		
		boxPanel = new MyJPanel(0,0,200,200,2);
		boxPanel.add(boxOfLanguages);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.add(scrollPane);

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		//container.add(b1);
		container.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.setAlignmentY(Component.CENTER_ALIGNMENT);
		container.add(panel1);
		container.add(boxPanel);

		this.add(container);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			System.out.println("b1");
		}else{
	        language = ResourceBundle.getBundle("lang", locales[((JComboBox) e.getSource()).getSelectedIndex()]);
		}
		CarDAO mySQL = DAOFactory.getInstance().getCarDAO();
		List<CarData> cars = mySQL.getAllCars();

		String[] colNames = {
				language.getString("brand"), 
				language.getString("model"),
				language.getString("FabYear"), 
				language.getString("CilCap")
		};
		
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0); 
		table.setModel(model);
		
		for(int i = 0; i < cars.size(); i++){
			model.addRow(new Object[] {cars.get(i).getBrand(), cars.get(i).getModel(), cars.get(i).getFabYear(), cars.get(i).getCilCap()});
		}
		
		
	}

}