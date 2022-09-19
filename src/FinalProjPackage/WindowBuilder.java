package FinalProjPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowBuilder {

	private JFrame frmRetailPointOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frmRetailPointOf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetailPointOf = new JFrame();
		frmRetailPointOf.setForeground(new Color(0, 128, 0));
		frmRetailPointOf.setBackground(new Color(255, 250, 250));
		frmRetailPointOf.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		frmRetailPointOf.setResizable(false);
		frmRetailPointOf.setTitle("Retail Point of Sale System\r\n");
		frmRetailPointOf.getContentPane().setBackground(new Color(85, 107, 47));
		frmRetailPointOf.setBounds(100, 100, 811, 512);
		frmRetailPointOf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRetailPointOf.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(240, 230, 140), 5, true));
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(113, 80, 560, 206);
		frmRetailPointOf.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblP = new JLabel("Retail Point of Sale System");
		lblP.setForeground(new Color(240, 230, 140));
		lblP.setBounds(80, 90, 422, 43);
		panel.add(lblP);
		lblP.setFont(new Font("Californian FB", Font.BOLD, 37));
		
		JButton btnNewButton = new JButton("Modify Inventory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRetailPointOf.dispose();
				Modify_Window.modifyWindow();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 17));
		btnNewButton.setBounds(154, 362, 177, 41);
		frmRetailPointOf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell Item\r\n");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRetailPointOf.dispose();
				Sell_Window.sellWindow();
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 20));
		btnNewButton_1.setBounds(154, 305, 177, 39);
		frmRetailPointOf.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Check Inventory");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRetailPointOf.dispose();
				Inventory.Inventory();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		btnNewButton_2.setBounds(457, 307, 177, 39);
		frmRetailPointOf.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_2 = new JButton("Refund");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRetailPointOf.dispose();
				Refund_Window.refund();
			}
		});
		btnNewButton_2_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2_2.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		btnNewButton_2_2.setBounds(457, 363, 177, 39);
		frmRetailPointOf.getContentPane().add(btnNewButton_2_2);
	}
}
