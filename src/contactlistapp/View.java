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
import java.awt.Color;
import java.awt.Toolkit;

public class View {
	protected static final JOptionPane JOptionPane = null;
	JFrame frmUpdateContact;
	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnNewButton;
	JButton btnNewButton1;
	JButton btnNewButton2;
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
					View f3= new View();
					f3.frmUpdateContact.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void Fetch() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactlistapp","root","@12344321regina_phoebe");
			Statement st=con.createStatement();
			String query="select * from contacts";
			ResultSet rs=st.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++) {
				colName[i]=rsmd.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			String name,phonenumber,email;
			while(rs.next()) {
				name=rs.getString(1);
				phonenumber=rs.getString(2);
				email=rs.getString(3);
				String[] row= {name,phonenumber,email};
				model.addRow(row);
				
			}
			st.close();
		   con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	/**
	 * Create the frame.
	 */
	public View() {
		connect();
		
		frmUpdateContact= new JFrame();
		frmUpdateContact.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/contactlistapp/PngItem_4483955.png")));
		frmUpdateContact.setTitle("Update Contact");
		frmUpdateContact.setBounds(100, 100, 432, 390);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 62, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 74, 160, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 125, 160, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 167, 160, 31);
		contentPane.add(textField_2);
		
		erlbl = new JLabel("");
		erlbl.setForeground(new Color(255, 0, 0));
		erlbl.setBounds(141, 209, 160, 14);
		contentPane.add(erlbl);
		
		 btnNewButton = new JButton("Update");
		 btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tf = textField.getText();
					if(tf.isEmpty()) {
						erlbl.setText("Required fields are empt");
					}
					else {
					String query="UPDATE contacts SET name='"+tf+"' ,phonenumber='" +textField_1.getText()+"',email='"+textField_2.getText()+"' where name='" +textField.getText()+"'";
				    pst=con.prepareStatement(query);
				    pst.execute();;
				    JOptionPane.showMessageDialog(null, "updated");
					IntelF f3 = new IntelF();
					//f3.setVisible(true);
					f3.frame.setVisible(true);
					frmUpdateContact.setVisible(false);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
		
				
			}
			
		});
		 
		btnNewButton.setBounds(155, 234, 127, 31);
		contentPane.add(btnNewButton);
	/*	btnNewButton2 = new JButton("Show All Contacts");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelF f3 = new IntelF();
				//f3.setVisible(true);
				f3.frame.setVisible(true);
				frame.setVisible(false);
			}
		});*/
	//	btnNewButton2.setBounds(122, 301, 179, 39);
	//	contentPane.add(btnNewButton2);
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(59, 84, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setForeground(new Color(255, 255, 255));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(37, 133, 95, 14);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setForeground(new Color(255, 255, 255));
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId.setBounds(37, 175, 95, 14);
		contentPane.add(lblEmailId);
		
		frmUpdateContact.getContentPane().add(contentPane);
		
		lblNewLabel_1 = new JLabel("Update Contact");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(141, 21, 160, 31);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}}
