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

public class Inventory {

	private JFrame Inventory;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JLabel lblHomeInventory;

	/**
	 * Launch the application.
	 */
	public static void Inventory() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();
					window.Inventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Inventory = new JFrame();
		Inventory.getContentPane().setBackground(new Color(0, 128, 128));
		Inventory.setTitle("Inventory Window\r\n");
		Inventory.setBounds(100, 100, 792, 502);
		Inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Inventory.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 43, 756, 409);
		Inventory.getContentPane().add(scrollPane_1);
		
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Product ID", "Item Name", "Quantity", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Inventory");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			btnNewButton = new JButton("Back to Home");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Inventory.dispose();
				WindowBuilder.main(null);
				}
			});
			btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
			btnNewButton.setBounds(643, 9, 123, 23);
			Inventory.getContentPane().add(btnNewButton);
			
			lblHomeInventory = new JLabel("Home > Inventory ------------------------------------------------------------------");
			lblHomeInventory.setForeground(new Color(0, 255, 255));
			lblHomeInventory.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			lblHomeInventory.setBounds(10, 14, 634, 23);
			Inventory.getContentPane().add(lblHomeInventory);
		}catch(SQLException sql) {
			sql.printStackTrace();
	        }
	}
}
