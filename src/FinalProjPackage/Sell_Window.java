package FinalProjPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.TextArea;
import java.awt.Window;

public class Sell_Window {

	private JFrame frmSalesWindow;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtAmount;
	private JTextField txtTotal;
	private JTextField txtPay;
	private JTextField txtBal;
	private JTable table;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void sellWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell_Window window = new Sell_Window();
					window.frmSalesWindow.setVisible(true);
					window.frmSalesWindow.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sell_Window() {
		initialize();
	}
	 static boolean isNumber(String s)
	    {
	        for (int i = 0; i < s.length(); i++)
	            if (Character.isDigit(s.charAt(i)) == false)
	                return false;
	 
	        return true;
	    }
	/**
	 * Initialize the contents of the frame.
	 */
	public void Bal() {
		try {
			int total = Integer.parseInt(txtTotal.getText());
			int pay = Integer.parseInt(txtPay.getText());
			
		
			int bal = pay - total;
			
			if(pay>=total)
			{
				txtBal.setText(String.valueOf(bal));
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Payment");
		}
		
		
	}
	public void print() {

		  PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName(" Print Component ");

		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum) {
		      if (pageNum > 0) return Printable.NO_SUCH_PAGE;

		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      Window component_name = null;
			component_name.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }

			public int print1(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				return 0;
			}
		  });

		  if (pj.printDialog() == false) return;

		  try {
		    pj.print();
		  } catch (PrinterException ex) {
		    // handle exception
		  }
		}
	private void initialize() {
		frmSalesWindow = new JFrame();
		frmSalesWindow.setTitle("Sales Window\r\n");
		frmSalesWindow.setResizable(false);
		frmSalesWindow.getContentPane().setBackground(new Color(138, 43, 226));
		frmSalesWindow.setBackground(Color.WHITE);
		frmSalesWindow.setBounds(100, 100, 807, 522);
		frmSalesWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalesWindow.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 536, 142);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 128), new Color(0, 0, 139), new Color(0, 0, 205), new Color(0, 0, 255)));
		panel.setBackground(new Color(123, 104, 238));
		frmSalesWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSalesProduct = new JLabel("-- Home >Sales Product ---------------------------------------------");
		lblSalesProduct.setForeground(new Color(255, 228, 196));
		lblSalesProduct.setBounds(10, 11, 516, 24);
		panel.add(lblSalesProduct);
		lblSalesProduct.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setForeground(new Color(176, 224, 230));
		lblItemId.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemId.setBounds(20, 49, 88, 17);
		panel.add(lblItemId);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblItemName.setForeground(new Color(173, 216, 230));
		lblItemName.setBounds(125, 49, 101, 17);
		panel.add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(173, 216, 230));
		lblQuantity.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblQuantity.setBounds(236, 45, 98, 24);
		panel.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(173, 216, 230));
		lblPrice.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblPrice.setBounds(335, 50, 48, 14);
		panel.add(lblPrice);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(new Color(173, 216, 230));
		lblAmount.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblAmount.setBounds(427, 50, 67, 14);
		panel.add(lblAmount);
		
		txtName = new JTextField();
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setEditable(false);
		txtName.setBounds(115, 73, 106, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		
		
		txtPrice = new JTextField();
		txtPrice.setBackground(Color.LIGHT_GRAY);
		txtPrice.setEditable(false);
		txtPrice.setBounds(310, 72, 96, 24);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			int qty = Integer.parseInt(spinner.getValue().toString());
			int price = Integer.parseInt(txtPrice.getText());
			
			int total =qty * price;
			txtAmount.setText(String.valueOf(total));
			}
			
		});
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(231, 74, 69, 22);
		panel.add(spinner);
		
		txtAmount = new JTextField();
		txtAmount.setBackground(Color.LIGHT_GRAY);
		txtAmount.setEditable(false);
		txtAmount.setBounds(416, 73, 96, 24);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				if(!ID.equals("")) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM Inventory");
				
					while(rs.next()){
						Integer ident = rs.getInt("ID");
						String id = ident.toString();
						if(ID.equals(id)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Inventory "+"SET Quantity=? " +"WHERE ID='"+ID+"'");
							String qty = spinner.getValue().toString();
							int quantity = Integer.parseInt(qty);
							int qntty = rs.getInt("Quantity");
							if(quantity <= qntty) {
							int totalqty = qntty-quantity;
							
							upd.setInt(1, totalqty);
							//upd.executeUpdate();
							upd.close();
							}
				String am = txtAmount.getText();

				if(am.equals("") || (Integer.parseInt(spinner.getValue().toString())==0)) {
					JOptionPane.showMessageDialog(null, "Please Choose Quantity");
				}else if(quantity > qntty) {
					JOptionPane.showMessageDialog(null, " Invalid Quantity");
				}

				else {	
				DefaultTableModel model = new DefaultTableModel();
				model=(DefaultTableModel)table.getModel();
				
				model.addRow(new Object[]
						{
								txtID.getText(),
								txtName.getText(),
								spinner.getValue().toString(),
								txtPrice.getText(),
								txtAmount.getText(),
						});
				
				int sum=0;
				
				for(int i=0;i<table.getRowCount();i++) {
					sum = sum+Integer.parseInt(table.getValueAt(i, 4).toString());
				}
							txtTotal.setText(Integer.toString(sum));
							txtID.setText("");
							txtName.setText("");
							txtPrice.setText("");
							txtAmount.setText("");
							txtID.requestFocus();
							
						break;
			}
						}
					}
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
				}else {
					JOptionPane.showMessageDialog(null, "Please Input Item ID");
				}
				}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(416, 107, 89, 23);
		panel.add(btnNewButton);
		
		txtID = new JTextField();
		txtID.setForeground(new Color(0, 0, 0));
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
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT ID, ItemName, Price FROM Inventory");
					int i=0;
						while(rs.next()){
							Integer ident = rs.getInt("ID");
							String id = ident.toString();
							String name = rs.getString("ItemName");
							String price = rs.getString("Price");
							if(ID.equals(id)) {
							txtName.setText(name);
							txtPrice.setText(price);
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
		txtID.setBounds(10, 73, 96, 24);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(653, 59, 48, 14);
		lblTotal.setForeground(new Color(173, 216, 230));
		lblTotal.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		frmSalesWindow.getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBackground(Color.LIGHT_GRAY);
		txtTotal.setBounds(556, 78, 225, 20);
		txtTotal.setEditable(false);
		frmSalesWindow.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back to Home");
		btnNewButton_1.setBounds(658, 11, 123, 23);
		frmSalesWindow.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		
		JLabel lblPay = new JLabel("Payment\r\n");
		lblPay.setBounds(642, 100, 71, 23);
		lblPay.setForeground(new Color(173, 216, 230));
		lblPay.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		frmSalesWindow.getContentPane().add(lblPay);
		
		txtPay = new JTextField();
		txtPay.setBounds(556, 122, 225, 20);
		frmSalesWindow.getContentPane().add(txtPay);
		txtPay.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(642, 153, 59, 14);
		lblBalance.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblBalance.setForeground(new Color(173, 216, 230));
		frmSalesWindow.getContentPane().add(lblBalance);
		
		txtBal = new JTextField();
		txtBal.setBackground(Color.LIGHT_GRAY);
		txtBal.setBounds(556, 171, 225, 20);
		txtBal.setEditable(false);
		frmSalesWindow.getContentPane().add(txtBal);
		txtBal.setColumns(10);
		
		TextArea txtBill = new TextArea();
		txtBill.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 14));
		txtBill.setEditable(false);
		txtBill.setBounds(556, 231, 225, 241);
		frmSalesWindow.getContentPane().add(txtBill);
		
		JButton btnNewButton_2 = new JButton("Bill");
		btnNewButton_2.setBounds(556, 202, 108, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTotal.getText().equals("")) {	
				if(!txtPay.getText().equals("")) {
					Bal();
					if(isNumber(txtPay.getText())){
						if(Integer.parseInt(txtPay.getText())>=Integer.parseInt(txtTotal.getText())) {

							String total = txtTotal.getText();
							String pay = txtPay.getText();
							String bal = txtBal.getText();
							int ttl = Integer.parseInt(total);
							int paymnt = Integer.parseInt(pay);
							
				DefaultTableModel model = new DefaultTableModel();
				model=(DefaultTableModel)table.getModel();
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
					String add = "INSERT INTO Refund(CustomerID, ItemID, Quantity, Price, Subtotal, Payment) VALUES(?,?,?,?,?,?)"; 
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
					Statement stmt = con.createStatement();
					
					
					int payment = Integer.parseInt(pay);
					
					for(int i =0; i<model.getRowCount();i++) {
						String IID = (String) model.getValueAt(i, 0);
						int iid = Integer.parseInt(IID);		

						
						String QTY = (String) model.getValueAt(i, 2);
						int qty = Integer.parseInt(QTY);
						String PRC = (String) model.getValueAt(i, 3);
						int prc = Integer.parseInt(PRC);
						int sbt = qty*prc;
						ResultSet rs = stmt.executeQuery("SELECT CustomerID FROM Refund");
						ResultSet xs = stmt.executeQuery("SELECT Quantity FROM Inventory WHERE ID='"+iid+"'");	
						PreparedStatement upd = con.prepareStatement("UPDATE Inventory "+"SET Quantity=? " +"WHERE ID='"+iid+"'");
						PreparedStatement pst = con.prepareStatement(add); 
					
						if(!(rs.next())) {
							while(xs.next()) {
							int qntty = xs.getInt("Quantity");
								int totqty = qntty-qty;
								upd.setInt(1, totqty);
								upd.executeUpdate();
								upd.close();
							}
						pst.setInt(1, 1000);
						pst.setInt(2, iid);
						pst.setInt(3, qty);
						pst.setInt(4, prc);
						pst.setInt(5, sbt);
						pst.setInt(6, payment);
						pst.execute();	
						pst.close();
						rs.close();
					}
					else {
						ResultSet as = stmt.executeQuery("SELECT CustomerID FROM Refund");
						ResultSet ys = stmt.executeQuery("SELECT Quantity FROM Inventory WHERE ID='"+iid+"'");
						PreparedStatement ast = con.prepareStatement(add); 
						PreparedStatement updt = con.prepareStatement("UPDATE Inventory "+"SET Quantity=? " +"WHERE ID='"+iid+"'");
						
					while(as.next() ){
						int id = as.getInt("CustomerID");
							if(as.isLast()) {
								while(ys.next()) {
								int qtty = ys.getInt("Quantity");
									int totqty = qtty-qty;
									updt.setInt(1, totqty);
									updt.executeUpdate();
								}
								ast.setInt(1, id);
								ast.setInt(2, iid);
								ast.setInt(3, qty);
								ast.setInt(4, prc);
								ast.setInt(5, sbt);
								ast.setInt(6, payment);
								ast.execute();	
								}
					}
					updt.close();
					ast.close();		
					as.close();
					}
					}
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }

				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Cedrick Alcantara\\eclipse-workspace\\POS_System_ADETFinalProject\\src\\FinalProjPackage\\PoS System.accdb");
				String add = "INSERT INTO Refund(CustomerID, ItemID, Quantity, Price, Subtotal, Payment) VALUES(?,?,?,?,?,?)"; 
					Statement stmt = con.createStatement();
					ResultSet cs = stmt.executeQuery("SELECT CustomerID FROM Refund");
					PreparedStatement cst = con.prepareStatement(add); 
				while(cs.next()) {
					
					if(cs.isLast()) {
						int id = cs.getInt("CustomerID");				
						txtBill.setText("Customer ID: "+id+"\n");
						cst.setInt(1, id+10);
						cst.setInt(2, 0);
						cst.setInt(3, 0);
						cst.setInt(4, 0);
						cst.setInt(5, 0);
						cst.setInt(6, 0);
						cst.execute();	
				}
				}
				cs.close();
				
				}catch(SQLException sql) {
					sql.printStackTrace();
			        }
				txtBill.setText(txtBill.getText()+ "************************************\n");
				txtBill.setText(txtBill.getText()+ "*    	Point of Sale         *\n");
				txtBill.setText(txtBill.getText()+ "************************************\n");
						
				txtBill.setText(txtBill.getText()+ "Product"+"\t"+"Price"+"\t"+"Amount \n");
				
				
				for(int i=0; i<model.getRowCount();i++) {
					String name = (String)model.getValueAt(i, 1);
					String qty = (String)model.getValueAt(i, 2);
					String price = (String)model.getValueAt(i, 3);
					String amount = (String)model.getValueAt(i, 4);
					
					txtBill.setText(txtBill.getText()+name+"x"+qty+" \t"+price+"\t"+amount+"\n");
				}	
					txtBill.setText(txtBill.getText()+"\n");
				
					txtBill.setText(txtBill.getText()+"\t\t"+"Total: "+ total+"\n");
					txtBill.setText(txtBill.getText()+"\t\t"+"Payment: "+ pay+"\n");
					txtBill.setText(txtBill.getText()+"\t\t"+"Balance: "+ bal+"\n");					
					
					txtBill.setText(txtBill.getText()+ "************************************\n");
					txtBill.setText(txtBill.getText()+ "*  THANK YOU, COME AGAIN!   *\n");
				}else {
					JOptionPane.showMessageDialog(null, "Insufficient Payment");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Payment");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Please Input Payment");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Please Make Transaction First");
				}
				
			}	
		});
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		frmSalesWindow.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 536, 308);
		frmSalesWindow.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Quantity", "Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			print();
			}
			});
		btnPrint.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		btnPrint.setForeground(new Color(0, 0, 128));
		btnPrint.setBounds(674, 202, 107, 23);
		frmSalesWindow.getContentPane().add(btnPrint);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSalesWindow.dispose();
				sellWindow();
			}
		});
		btnNew.setForeground(new Color(0, 0, 128));
		btnNew.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		btnNew.setBounds(556, 11, 89, 23);
		frmSalesWindow.getContentPane().add(btnNew);
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSalesWindow.dispose();
				WindowBuilder.main(null);
			}
		});
	}
}
