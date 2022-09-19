package FinalProjPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;

public class Modify_Window {

	private JFrame frmModifyWindow;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtDltID;
	private JTextField txtDelName;
	private JTextField txtQty;
	private JTextField txtNewQty;
	private JTextField txtPrice;
	private JTextField txtNewPrice;
	private JTextField txtAddID;
	private JTextField txtAddName;
	private JTextField txtAddQty;
	private JTextField txtAddPrc;
	private JTextField txtDelQty;
	private JTextField txtDelPrc;

	/**
	 * Launch the application.
	 */
	public static void modifyWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify_Window window = new Modify_Window();
					window.frmModifyWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 static boolean isNumber(String s)
	    {
	        for (int i = 0; i < s.length(); i++)
	            if (Character.isDigit(s.charAt(i)) == false)
	                return false;
	 
	        return true;
	    }
	/**
	 * Create the application.
	 */
	public Modify_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifyWindow = new JFrame();
		frmModifyWindow.getContentPane().setBackground(new Color(255, 255, 0));
		frmModifyWindow.getContentPane().setForeground(new Color(255, 0, 0));
		frmModifyWindow.setTitle("Modify Window\r\n");
		frmModifyWindow.setBounds(100, 100, 832, 503);
		frmModifyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModifyWindow.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 222, 173), new Color(255, 228, 181), new Color(255, 228, 225), new Color(255, 240, 245)));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 41, 796, 122);
		frmModifyWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("-- Home > Modify > Modify Price & Quantity -------------------------------------------------------------");
		lblNewLabel.setBounds(10, 11, 776, 24);
		lblNewLabel.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		panel.add(lblNewLabel);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemId.setBounds(20, 46, 81, 14);
		panel.add(lblItemId);
		
		txtID = new JTextField();
		txtID.setBackground(Color.CYAN);
		txtID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ID, ItemName, Quantity, Price FROM Inventory");
				int i=0;
					while(rs.next()){
						Integer ident = rs.getInt("ID");
						String id = ident.toString();
						String name = rs.getString("ItemName");
						String qty = rs.getString("Quantity");
						int prc = rs.getInt("Price");
						String p = Integer.toString(prc);
						if(ID.equals(id)) {
						txtName.setText(name);
						txtQty.setText(qty);
						txtPrice.setText(p);
						i=0;
						break;
						}else
							i=1;
						}
					if(i==1) {
						JOptionPane.showMessageDialog(null, "Invalid ID!");
					}
					
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
			}
		});
		txtID.setBounds(108, 46, 96, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemName.setBounds(10, 77, 96, 14);
		panel.add(lblItemName);
		
		txtName = new JTextField();
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setEditable(false);
		txtName.setBounds(108, 77, 96, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCurrentQuantity = new JLabel("Current Quantity");
		lblCurrentQuantity.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblCurrentQuantity.setForeground(new Color(0, 0, 0));
		lblCurrentQuantity.setBounds(214, 46, 136, 20);
		panel.add(lblCurrentQuantity);
		
		txtQty = new JTextField();
		txtQty.setBackground(Color.LIGHT_GRAY);
		txtQty.setEditable(false);
		txtQty.setBounds(354, 46, 96, 20);
		panel.add(txtQty);
		txtQty.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New Quantity");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewLabel_2.setBounds(214, 76, 114, 17);
		panel.add(lblNewLabel_2);
		
		txtNewQty = new JTextField();
		txtNewQty.setBounds(354, 77, 96, 20);
		panel.add(txtNewQty);
		txtNewQty.setColumns(10);
		
		JButton btnNewButton = new JButton("Update Quantity");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				if(!ID.equals("") && !txtQty.getText().equals("")) {
					if(!txtNewQty.getText().equals("")) {
						if(isNumber(txtNewQty.getText())) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ID FROM Inventory");
					
					while(rs.next()){
						Integer ident = rs.getInt("ID");
						String id = ident.toString();
						if(ID.equals(id)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Inventory "+"SET Quantity=? " +"WHERE ID='"+ID+"'");
							int quantity = Integer.parseInt(txtNewQty.getText());
							
							upd.setInt(1, quantity);
							upd.executeUpdate();
							upd.close();
							txtQty.setText(String.valueOf(quantity));

							}
					}
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
					}else {
						JOptionPane.showMessageDialog(null, "Please Input a Valid Quantity");	
			        }
					}else {
						JOptionPane.showMessageDialog(null, "Please Input New Item Quantity");		
					}
					}else {
					JOptionPane.showMessageDialog(null, "Please Input Item ID");
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 10));
		btnNewButton.setBounds(672, 45, 114, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Price");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				
				if(!ID.equals("") && !txtQty.getText().equals("")) {
					if(!txtNewPrice.getText().equals("")) {
						if(isNumber(txtNewPrice.getText())) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ID FROM Inventory");
				
					while(rs.next()){
						Integer ident = rs.getInt("ID");
						String id = ident.toString();
						if(ID.equals(id)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Inventory "+"SET Price=? " +"WHERE ID='"+ID+"'");
							String prc = txtNewPrice.getText();
							int price = Integer.parseInt(prc);
							if(price>0) {
								upd.setString(1, prc);
								upd.executeUpdate();
								upd.close();
								txtPrice.setText(prc);
								}else if (price == 0){
									JOptionPane.showMessageDialog(null, "Invalid input! Price cannot be Zero!");
								}
							
						}
					}
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
						}else {
						JOptionPane.showMessageDialog(null, "Please Input a Valid Number");	
			        }
					}else {
						JOptionPane.showMessageDialog(null, "Please Input New Item Price");		
					}
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Input Item ID");
			}
				}
		});
		btnNewButton_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 10));
		btnNewButton_1.setBounds(672, 76, 114, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblCurrentPrice = new JLabel("Current Price");
		lblCurrentPrice.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblCurrentPrice.setBounds(460, 46, 105, 14);
		panel.add(lblCurrentPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(Color.LIGHT_GRAY);
		txtPrice.setEditable(false);
		txtPrice.setBounds(564, 46, 96, 20);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewPrice = new JLabel("New Price");
		lblNewPrice.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewPrice.setBounds(460, 80, 81, 14);
		panel.add(lblNewPrice);
		
		txtNewPrice = new JTextField();
		txtNewPrice.setBounds(564, 77, 96, 20);
		panel.add(txtNewPrice);
		txtNewPrice.setColumns(10);
		
		JButton btnHomeButton = new JButton("Back to Home");
		btnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModifyWindow.dispose();
				WindowBuilder.main(null);
			}
		
		});
		btnHomeButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		btnHomeButton.setBounds(689, 11, 117, 23);
		frmModifyWindow.getContentPane().add(btnHomeButton);
		
		JLabel lblHomeModify = new JLabel("Home > Modify");
		lblHomeModify.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblHomeModify.setBounds(10, 13, 202, 21);
		frmModifyWindow.getContentPane().add(lblHomeModify);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), new Color(255, 218, 185), new Color(255, 222, 173), new Color(255, 228, 181)));
		panel_1.setBounds(10, 174, 796, 127);
		frmModifyWindow.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 230, 140));
		
		JLabel lblNewLabel_1 = new JLabel("-- Home > Modify > Add Item -------------------------------------------------------------------------");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewLabel_1.setBackground(new Color(128, 0, 128));
		lblNewLabel_1.setBounds(10, 11, 763, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblItemId_2 = new JLabel("Item ID");
		lblItemId_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemId_2.setBounds(42, 52, 81, 14);
		panel_1.add(lblItemId_2);
		
		txtAddID = new JTextField();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}catch(ClassNotFoundException cn) {
			System.out.println("There was a problem in your code");
			cn.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM Inventory");
			int i=1;
			while(rs.next()){
			 i = rs.getInt("ID");
			}
			String j = String.valueOf(i+1);
			txtAddID.setText(j);;
		}catch(SQLException sql) {
			sql.printStackTrace();
	        }
		
		
		txtAddID.setEditable(false);
		txtAddID.setColumns(10);
		txtAddID.setBackground(Color.LIGHT_GRAY);
		txtAddID.setBounds(133, 52, 96, 20);
		panel_1.add(txtAddID);
		
		JLabel lblItemName_2 = new JLabel("Item Name");
		lblItemName_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemName_2.setBounds(27, 83, 96, 14);
		panel_1.add(lblItemName_2);
		
		txtAddName = new JTextField();
		txtAddName.setColumns(10);
		txtAddName.setBackground(Color.WHITE);
		txtAddName.setBounds(133, 83, 96, 20);
		panel_1.add(txtAddName);
		
		JLabel lblNewLabel_2_1 = new JLabel("Quantity");
		lblNewLabel_2_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(268, 51, 114, 21);
		panel_1.add(lblNewLabel_2_1);
		
		txtAddQty = new JTextField();
		txtAddQty.setColumns(10);
		txtAddQty.setBackground(Color.WHITE);
		txtAddQty.setBounds(345, 52, 96, 20);
		panel_1.add(txtAddQty);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblPrice.setBounds(278, 83, 81, 14);
		panel_1.add(lblPrice);
		
		txtAddPrc = new JTextField();
		txtAddPrc.setColumns(10);
		txtAddPrc.setBackground(Color.WHITE);
		txtAddPrc.setBounds(345, 83, 96, 20);
		panel_1.add(txtAddPrc);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtAddName.getText().equals("")) {
					
					if(!txtAddQty.getText().equals("")) {
						if(isNumber(txtAddQty.getText())) {
						if(!txtAddPrc.getText().equals("")) {
							if(isNumber(txtAddPrc.getText())) {
				try{ 
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					}catch(ClassNotFoundException cn) {
						System.out.println("There was a problem in your code");
						cn.printStackTrace();
					}
					try {
					String query = "INSERT INTO Inventory(ItemName, Quantity, Price) VALUES(?,?,?)"; 
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb"); 
					PreparedStatement pst = con.prepareStatement(query); 
					
					pst.setString(1, txtAddName.getText().toString()); 
					int a = Integer.parseInt(txtAddQty.getText());
					pst.setInt(2, a); 
					pst.setString(3, txtAddPrc.getText().toString()); 
						pst.execute(); 
						
					JOptionPane.showMessageDialog(null, "Item Successfully added!"); 
					txtAddName.setText(""); 
					txtAddQty.setText("");
					txtAddPrc.setText("");
					
					int i = Integer.parseInt(txtAddID.getText());
					String j = String.valueOf(i+1);
					txtAddID.setText(j);
					} catch(SQLException sql) {
						sql.printStackTrace();
					}
							}else {
								JOptionPane.showMessageDialog(null, "Please Input Valid Price!");
							}
				}else {
					JOptionPane.showMessageDialog(null, "Please Input Price!");
					}
						}else {
							JOptionPane.showMessageDialog(null, "Please Input Valid Quantity!");
						}
						
				}else {
					JOptionPane.showMessageDialog(null, "Please Input Quantity!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please Input Product Name!");
				}
				
			}
		});
		btnAddItem.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		btnAddItem.setBounds(519, 52, 107, 35);
		panel_1.add(btnAddItem);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 230, 140));
		panel_2.setBounds(10, 312, 796, 141);
		frmModifyWindow.getContentPane().add(panel_2);
		
		JLabel lblHome = new JLabel("-- Home > Modify > Delete Item  ------------------------------------------------------------------------");
		lblHome.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblHome.setBackground(new Color(0, 0, 205));
		lblHome.setBounds(10, 11, 776, 24);
		panel_2.add(lblHome);
		
		JLabel lblItemId_1 = new JLabel("Item ID");
		lblItemId_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemId_1.setBounds(26, 61, 81, 14);
		panel_2.add(lblItemId_1);
		
		txtDltID = new JTextField();
		txtDltID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtDltID.getText();
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ID, ItemName, Quantity, Price FROM Inventory");
				int i=0;
					while(rs.next()){
						Integer ident = rs.getInt("ID");
						String id = ident.toString();
						String name = rs.getString("ItemName");
						String qty = rs.getString("Quantity");
						int prc = rs.getInt("Price");
						String p = Integer.toString(prc);
						if(ID.equals(id)) {
						txtDelName.setText(name);
						txtDelQty.setText(qty);
						txtDelPrc.setText(p);
						i=0;
						break;
						}else
							i=1;
						}
					if(i==1) {
						JOptionPane.showMessageDialog(null, "Invalid ID!");
					}
					
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
			}
		});
		txtDltID.setBackground(Color.CYAN);
		txtDltID.setColumns(10);
		txtDltID.setBounds(117, 61, 96, 20);
		panel_2.add(txtDltID);
		
		JLabel lblItemName_1 = new JLabel("Item Name");
		lblItemName_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemName_1.setBounds(20, 92, 96, 14);
		panel_2.add(lblItemName_1);
		
		txtDelName = new JTextField();
		txtDelName.setBackground(Color.LIGHT_GRAY);
		txtDelName.setEditable(false);
		txtDelName.setColumns(10);
		txtDelName.setBounds(117, 92, 96, 20);
		panel_2.add(txtDelName);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Quantity");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(265, 58, 114, 21);
		panel_2.add(lblNewLabel_2_1_1);
		
		txtDelQty = new JTextField();
		txtDelQty.setBackground(Color.LIGHT_GRAY);
		txtDelQty.setEditable(false);
		txtDelQty.setColumns(10);
		txtDelQty.setBounds(349, 61, 96, 20);
		panel_2.add(txtDelQty);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblPrice_1.setBounds(265, 92, 81, 14);
		panel_2.add(lblPrice_1);
		
		txtDelPrc = new JTextField();
		txtDelPrc.setBackground(Color.LIGHT_GRAY);
		txtDelPrc.setEditable(false);
		txtDelPrc.setColumns(10);
		txtDelPrc.setBounds(349, 92, 96, 20);
		panel_2.add(txtDelPrc);
		
		JButton btnNewButton_2 = new JButton("Delete Item\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ 
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					}catch(ClassNotFoundException cn) {
						System.out.println("There was a problem in your code");
						cn.printStackTrace();
					}
					try {	
					String ID = txtDltID.getText();
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Users\\\\Cedrick Alcantara\\\\eclipse-workspace\\\\POS_System_ADETFinalProject\\\\src\\\\FinalProjPackage\\\\PoS System.accdb");
					PreparedStatement upd = con.prepareStatement("DELETE FROM Inventory "+"WHERE ID ='"+ID+"'");				
					
					int result = JOptionPane.showConfirmDialog(null, "Would you like to delete this Item?", "New Input", YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
			        if(result == JOptionPane.YES_OPTION){
			        	upd.execute(); 

						txtDelName.setText("");
						txtDelQty.setText("");
						txtDelPrc.setText("");
			        }
					JOptionPane.showMessageDialog(null, "Item Successfully Removed from the Records"); 
					} catch(SQLException sql) {
						sql.printStackTrace();
					}
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		btnNewButton_2.setBounds(516, 71, 114, 29);
		panel_2.add(btnNewButton_2);
	}
}
