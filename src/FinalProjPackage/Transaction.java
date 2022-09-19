package FinalProjPackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Transaction {

	private JFrame Transaction;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;

	public static void Transaction() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction window = new Transaction();
					window.Transaction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transaction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Transaction = new JFrame();
		Transaction.getContentPane().setBackground(new Color(0, 255, 255));
		Transaction.setTitle("Transaction Window\r\n");
		Transaction.setBounds(100, 100, 792, 502);
		Transaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Transaction.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 43, 756, 409);
		Transaction.getContentPane().add(scrollPane_1);
		
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
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
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://PoS System.accdb");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CustomerID, ItemID, Quantity, Price, Subtotal, Payment FROM Refund WHERE ItemID != '0'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			btnNewButton = new JButton("Back to Home");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Transaction.dispose();
				WindowBuilder.main(null);
				}
			});
			btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
			btnNewButton.setBounds(643, 9, 123, 23);
			Transaction.getContentPane().add(btnNewButton);
			
			JLabel lblHomeTransaction = new JLabel("Home > Transaction -----------------------------------------------------------");
			lblHomeTransaction.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblHomeTransaction.setBounds(10, 14, 651, 14);
			Transaction.getContentPane().add(lblHomeTransaction);
		}catch(SQLException sql) {
			sql.printStackTrace();
	        }
	}
}
