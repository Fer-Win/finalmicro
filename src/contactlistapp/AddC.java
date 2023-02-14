package contactlistapp;

import java.awt.EventQueue;
import java.sql.*;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import contactlistapp.AddC;
import java.awt.Color;
import java.awt.Toolkit;
//import contactlistapp.Main;
public class AddC extends JFrame {

	protected static final JOptionPane JOptionPane = null;
	JFrame frmAddContact;
	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Connection con;
	PreparedStatement pst;
	
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
					AddC f2 = new AddC();
					f2.frmAddContact.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddC() {
		connect();
		frmAddContact= new JFrame();
		frmAddContact.setTitle("Add Contact");
		frmAddContact.setIconImage(Toolkit.getDefaultToolkit().getImage(AddC.class.getResource("/contactlistapp/PngItem_4483955.png")));
		frmAddContact.setBounds(100, 100, 433, 391);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 62, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	//	setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(155, 82, 196, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 124, 196, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 166, 196, 31);
		contentPane.add(textField_2);
		
		JLabel errorlbl = new JLabel("");
		errorlbl.setFont(new Font("Tahoma", Font.ITALIC, 12));
		errorlbl.setForeground(new Color(255, 0, 0));
		errorlbl.setBounds(133, 217, 248, 14);
		contentPane.add(errorlbl);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(255, 255, 255));
		/*JButton btnNewButton2 = new JButton("Show All Contacts");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelF f3 = new IntelF();
				//f3.setVisible(true);
				f3.frame.setVisible(true);
				frame.setVisible(false);
			}
		});*/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main m=new Main();
				
				//super("AddC");
				String name=textField.getText();
				String phonenumber=textField_1.getText();
				String email=textField_2.getText();
				
				try {
					pst=con.prepareStatement("INSERT INTO contacts (name,phonenumber,email)VALUES(?,?,?)");
					if(name.isEmpty() || phonenumber.isEmpty() || email.isEmpty()) {
						errorlbl.setText("Please fill out all the fields**");
					}else {
						errorlbl.setText("");
				    pst.setString(1, name);
				    pst.setString(2, phonenumber);
				    pst.setString(3, email);
					
				    int k=pst.executeUpdate();
				 //   m.Fetch();
				    if(k==1) {
				    	
				    	JOptionPane.showMessageDialog(AddC.this, "Contact added successfully");
				    	
				    	
				    	textField.setText(" ");
				    	textField_1.setText(" ");
				    	textField_2.setText(" ");
				    	
				    	IntelF f3 = new IntelF();
						//f3.setVisible(true);
						f3.frame.setVisible(true);
						frmAddContact.setVisible(false);
				    }else {
				    	JOptionPane.showMessageDialog(AddC.this, "Contact failed to add");
				    }
				    
				}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(AddC.this, "Welcome to Swing!");
				
			}
		});
		btnNewButton.setBounds(155, 242, 127, 31);
		contentPane.add(btnNewButton);
	//	btnNewButton2.setBounds(118, 299, 179, 39);
	//contentPane.add(btnNewButton2);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(80, 84, 49, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblMobileNo = new JLabel("Mobile No. :");
		lblMobileNo.setForeground(new Color(255, 255, 255));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(50, 130, 95, 14);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmailId = new JLabel("Email ID :");
		lblEmailId.setForeground(new Color(255, 255, 255));
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId.setBounds(63, 172, 66, 14);
		contentPane.add(lblEmailId);
		
		frmAddContact.getContentPane().add(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Add Contact");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(155, 24, 118, 31);
		contentPane.add(lblNewLabel_1);
		
	
		
	}
}
