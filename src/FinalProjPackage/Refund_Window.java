package FinalProjPackage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.YES_NO_OPTION;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class Refund_Window {

	private JFrame frmRefundWindow;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JLabel lblCustomerId;
	private JTextField txtRefund;
	private JTextField txtPrice;
	/**
	 * Launch the application.
	 */
	public static void refund() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refund_Window window = new Refund_Window();
					window.frmRefundWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Refund_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRefundWindow = new JFrame();
		frmRefundWindow.getContentPane().setBackground(new Color(255, 69, 0));
		frmRefundWindow.getContentPane().setForeground(new Color(255, 69, 0));
		frmRefundWindow.setTitle("Refund Window\r\n");
		frmRefundWindow.setBounds(100, 100, 800, 557);
		frmRefundWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRefundWindow.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 756, 412);
		frmRefundWindow.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Customer ID", "Item ID", "Quantity", "Price", "Subtotal", "Payment"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}catch(ClassNotFoundException cn) {
			System.out.println("There was a problem in your code");
			cn.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CustomerID, ItemID, Quantity, Price, Subtotal, Payment FROM Refund WHERE ItemID != '0'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(SQLException sql) {
			sql.printStackTrace();
	        }
			btnNewButton = new JButton("Back to Home");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmRefundWindow.dispose();
				WindowBuilder.main(null);
				}
			});
			btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
			btnNewButton.setBounds(643, 9, 123, 23);
			frmRefundWindow.getContentPane().add(btnNewButton);
			
			JLabel lblHomeTransaction = new JLabel("Home > Refund ---------------------------------------------------------------------");
			lblHomeTransaction.setForeground(new Color(0, 128, 0));
			lblHomeTransaction.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblHomeTransaction.setBounds(10, 14, 634, 14);
			frmRefundWindow.getContentPane().add(lblHomeTransaction);
			
			lblCustomerId = new JLabel("Customer ID");
			lblCustomerId.setForeground(new Color(0, 128, 128));
			lblCustomerId.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblCustomerId.setBounds(10, 39, 116, 23);
			frmRefundWindow.getContentPane().add(lblCustomerId);
			
			JComboBox IDCB = new JComboBox();
			JTextField CIDCB = new JTextField();
			
			IDCB.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						
					}catch(ClassNotFoundException cn) {
						System.out.println("There was a problem in your code");
						cn.printStackTrace();
					}
					try {
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
						Statement stmt = con.createStatement();
						String id = IDCB.getSelectedItem().toString();
						ResultSet rs = stmt.executeQuery("SELECT Price FROM Inventory WHERE ID = '"+id+"'");
						
						while(rs.next()){
						String prc = String.valueOf(rs.getInt("Price"));
						txtPrice.setText(prc);
						}
	
					}catch(SQLException sql) {
						sql.printStackTrace();
				        }
				}
			});
			IDCB.setBackground(new Color(192, 192, 192));
			IDCB.setBounds(150, 62, 116, 22);
			frmRefundWindow.getContentPane().add(IDCB);
			
			
			
			CIDCB.setBackground(Color.CYAN);
			CIDCB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						
					}catch(ClassNotFoundException cn) {
						System.out.println("There was a problem in your code");
						cn.printStackTrace();
					}
					try {
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
						Statement stmt = con.createStatement();
						String CIDfromCB = CIDCB.getText();
						ResultSet rs = stmt.executeQuery("SELECT DISTINCT CustomerID FROM Refund WHERE ItemID != '0'");
						ResultSet as = stmt.executeQuery("SELECT DISTINCT ItemID FROM Refund WHERE CustomerID = '"+CIDfromCB+"' AND ItemID !='0'");
						int i=0;
						while(rs.next()){
						String cidforcb = String.valueOf(rs.getInt("CustomerID"));
						
						if(CIDfromCB.equals(cidforcb)) {
							IDCB.removeAllItems();
							while(as.next()) {
							IDCB.addItem(String.valueOf(as.getInt("ItemID")));	
							}i=0;
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
			CIDCB.setBounds(10, 62, 116, 22);
			frmRefundWindow.getContentPane().add(CIDCB);
			
			JLabel lblItemId = new JLabel("Item ID");
			lblItemId.setForeground(new Color(0, 128, 128));
			lblItemId.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblItemId.setBounds(174, 39, 116, 23);
			frmRefundWindow.getContentPane().add(lblItemId);
			
			JLabel lblQuantity = new JLabel("Quantity");
			lblQuantity.setForeground(new Color(0, 128, 128));
			lblQuantity.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblQuantity.setBounds(409, 39, 96, 23);
			frmRefundWindow.getContentPane().add(lblQuantity);
			
		
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					int price = Integer.parseInt(txtPrice.getText());
					
					int total =qty * price;
					txtRefund.setText(String.valueOf(total));
				}
			});
			spinner.setBounds(409, 64, 86, 20);
			frmRefundWindow.getContentPane().add(spinner);
			
			JLabel lblTotalRefund = new JLabel("Total Refund\r\n");
			lblTotalRefund.setForeground(new Color(0, 128, 128));
			lblTotalRefund.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblTotalRefund.setBounds(509, 39, 116, 23);
			frmRefundWindow.getContentPane().add(lblTotalRefund);
			
			txtRefund = new JTextField();
			txtRefund.setBackground(Color.LIGHT_GRAY);
			txtRefund.setEditable(false);
			txtRefund.setBounds(505, 63, 120, 20);
			frmRefundWindow.getContentPane().add(txtRefund);
			txtRefund.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Refund");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{ 
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						}catch(ClassNotFoundException cn) {
							System.out.println("There was a problem in your code");
							cn.printStackTrace();
						}
						try {	
							
							Object itemA = IDCB.getSelectedItem();
							String ID;
							if(itemA!=null) {
								ID= itemA.toString();
							}else {
								ID="69";
							}
							int idd = Integer.parseInt(ID);
							int i=0;
							int cid=Integer.parseInt(CIDCB.getText());
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
						Statement stmt = con.createStatement();
						PreparedStatement del = con.prepareStatement("DELETE FROM Refund "+"WHERE ItemID ='"+idd+"' AND CustomerID='"+cid+"'");	
						ResultSet rs = stmt.executeQuery("SELECT ItemID, Quantity FROM Refund WHERE ItemID='"+idd+"' AND CustomerID='"+cid+"'");
						ResultSet as = stmt.executeQuery("SELECT Quantity FROM Inventory WHERE ID='"+idd+"'");
					
						
						PreparedStatement updi = con.prepareStatement("UPDATE Inventory "+"SET Quantity=? WHERE ID='"+idd+"'");
						PreparedStatement updr = con.prepareStatement("UPDATE Refund "+"SET Quantity=? WHERE ItemID='"+idd+"'");
						
						String qty = spinner.getValue().toString();
						int quantity = Integer.parseInt(qty);
						while(rs.next()&&as.next()) {
						
						int qntty = rs.getInt("Quantity");
						int ident = rs.getInt("ItemID");
						if(idd==ident) {
								if(quantity == qntty) {
								int result = JOptionPane.showConfirmDialog(null, "Would you like to Refund this Item?", "New Input", YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
								if(result == JOptionPane.YES_OPTION){
									int qtty = as.getInt("Quantity");
									int total = qtty+quantity;
									updi.setInt(1, total);
									updi.execute();
									del.execute();
									i=1;
									break;
									}
								}else if(quantity > qntty) {
									JOptionPane.showMessageDialog(null, "Invalid Quantity!"); 
									i=0;
							
								}else if (quantity < qntty) {
									int result = JOptionPane.showConfirmDialog(null, "Would you like to Refund this Item?", "New Input", YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
									if(result == JOptionPane.YES_OPTION){
									int total1 = qntty-quantity;
									int qtty = as.getInt("Quantity");
									int total = qtty+quantity;
									updi.setInt(1, total);
									updi.execute();
									updr.setInt(1, total1);
									updr.execute();
									i=1;
									break;
									}
								}
							}else if(idd==69){
								JOptionPane.showMessageDialog(null, "Please Input Customer ID!s"); 
							}
						}
						if(i==1) {
						JOptionPane.showMessageDialog(null, "Item Successfully Refunded!"); 
						frmRefundWindow.dispose();
						refund();
						}
						
						
						} catch(SQLException sql) {
							sql.printStackTrace();
						}		
				}
			});
			btnNewButton_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
			btnNewButton_1.setBounds(635, 50, 131, 34);
			frmRefundWindow.getContentPane().add(btnNewButton_1);
			
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setForeground(new Color(0, 128, 128));
			lblPrice.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblPrice.setBounds(310, 39, 116, 23);
			frmRefundWindow.getContentPane().add(lblPrice);
			
			txtPrice = new JTextField();
			txtPrice.setBackground(Color.LIGHT_GRAY);
			txtPrice.setEditable(false);
			txtPrice.setBounds(276, 63, 123, 20);
			frmRefundWindow.getContentPane().add(txtPrice);
			txtPrice.setColumns(10);
		
	}
}
