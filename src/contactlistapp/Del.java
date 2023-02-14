package contactlistapp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Color;


public class Del {
	protected static final JOptionPane JOptionPane = null;
	JFrame frmDeleteContact;
	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnNewButton;
	JButton btnNewButton1;
	JButton btnNewButton2 ;
	JPanel panel;
	ResultSet rs;
    JTable jTable1;
	
	
	Connection con=null;
	PreparedStatement pst;
	private JLabel erlbl;
	private JLabel lblNewLabel_1;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactlistapp","root","@12344321regina_phoebe");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Del f3= new Del();
					f3.frmDeleteContact.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	

/*	 void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
		int selectedIndex=jTable1.getSelectedRow();
		
		textField.setText(model.getValueAt(selectedIndex,1).toString());
		textField_1.setText(model.getValueAt(selectedIndex,2).toString());
		textField_2.setText(model.getValueAt(selectedIndex,3).toString());
	}
	
	*/
	/**
	 * Create the frame.
	 */
	public Del() {
		connect();
		
		frmDeleteContact= new JFrame();
		frmDeleteContact.setIconImage(Toolkit.getDefaultToolkit().getImage(Del.class.getResource("/contactlistapp/PngItem_4483955.png")));
		frmDeleteContact.setTitle("Delete Contact");
		frmDeleteContact.setBounds(100, 100, 404, 340);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 62, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(108, 115, 160, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	
		 btnNewButton1 = new JButton("Delete");
		 btnNewButton1.setBackground(new Color(255, 255, 255));
		 btnNewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String tf = textField.getText();
						if(tf.isEmpty()) {
							erlbl.setText("Please enter the name of the contact**");
						}else {
						String query="DELETE FROM contacts  where name='" +tf+"'";
					    pst=con.prepareStatement(query);
					    pst.execute();;
					    JOptionPane.showMessageDialog(null, "deleted");
						IntelF f3 = new IntelF();
						//f3.setVisible(true);
						f3.frame.setVisible(true);
						frmDeleteContact.setVisible(false);
						}}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					//JOptionPane.showMessageDialog(AddC.this, "Welcome to Swing!");
					
				}
				
			});
	
		btnNewButton1.setBounds(128, 176, 127, 31);
		contentPane.add(btnNewButton1);
		
	/* btnNewButton2 = new JButton("Show All Contacts");
		btnNewButton2.setBounds(191, 290, 89, 23);
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelF f3 = new IntelF();
				//f3.setVisible(true);
				f3.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		contentPane.add(btnNewButton2);*/
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(162, 88, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		frmDeleteContact.getContentPane().add(contentPane);
		
		erlbl = new JLabel("");
		erlbl.setForeground(new Color(255, 0, 0));
		erlbl.setBounds(81, 153, 227, 14);
		contentPane.add(erlbl);
		
		lblNewLabel_1 = new JLabel("Delete Contact");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(121, 35, 140, 31);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
