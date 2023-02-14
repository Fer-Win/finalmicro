package contactlistapp;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
public class IntelF extends JFrame{

	//private JFrame frame;
	JFrame frame;
	JTable jTable1;
	JLabel l;
	JButton btnNewButton;
	JButton btnNewButton1;
	JButton btnNewButton2;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JLabel tmlbl;
	 public Timer timer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*IndiF frame = new IndiF();
			frame.setVisible(true);*/
					IntelF window = new IntelF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	//	String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		//UIManager.setLookAndFeel(str);
	}

	/**
	 * Create the application.
	 */
	public IntelF() {
		initialize();
		Fetch();
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

	private void updateTime() {
    Calendar calendar = new GregorianCalendar();
    Date currentDate = calendar.getTime();
    tmlbl.setText(currentDate.toString());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 frame = new JFrame("My Contacts");
		 frame.setResizable(false);
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(IntelF.class.getResource("/contactlistapp/PngItem_4483955.png")));
		frame.getContentPane().setBackground(new Color(62, 62, 62));
		frame.setForeground(new Color(62, 62, 62));
		frame.setBackground(new Color(62, 62, 62));
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 0, 0, (Color) new Color(0, 128, 255)));
		panel.setBounds(10, 73, 398, 343);
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		scrollPane.setBounds(0,0,398,342);
		panel.add(scrollPane);
		
		jTable1=new JTable();
		scrollPane.setViewportView(jTable1);
		
		btnNewButton1 = new JButton("Delete");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Product Sans", Font.BOLD, 14));
		btnNewButton1.setBounds(452, 302, 114, 46);
		btnNewButton1.setBackground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton1);
		btnNewButton2 = new JButton("Edit");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Product Sans", Font.BOLD, 14));
		btnNewButton2.setBounds(452, 217, 114, 46);
		btnNewButton2.setBackground(new Color(0, 153, 255));
		frame.getContentPane().add(btnNewButton2);
		
				btnNewButton = new JButton("Add");
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Product Sans", Font.BOLD, 14));
				btnNewButton.setBounds(452, 132, 114, 46);
				btnNewButton.setSelectedIcon(null);
				btnNewButton.setBackground( new Color(0, 153, 255));
				frame.getContentPane().add(btnNewButton);
				JLabel lblNewLabel = new JLabel("Contacts :");
				lblNewLabel.setBounds(10, 48, 100, 14);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 20));
				frame.getContentPane().add(lblNewLabel);
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
				   LocalDateTime now = LocalDateTime.now();
				
				tmlbl = new JLabel("");
				tmlbl.setForeground(new Color(255, 255, 255));
				tmlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
				tmlbl.setBounds(434, 11, 190, 28);
				frame.getContentPane().add(tmlbl);
				//Calendar calendar = new GregorianCalendar();
			    //Date currentDate = calendar.getTime();
			    //tmlbl.setText(currentDate.toString());
				 
				timer = new Timer(1000, e -> updateTime());
			    timer.start();
			    
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddC f2 = new AddC();
						f2.frmAddContact.setVisible(true);
						frame.setVisible(false);
					}
				});
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View f3 = new View();
				f3.frmUpdateContact.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Del f4 = new Del();
					f4.frmDeleteContact.setVisible(true);
					frame.setVisible(false);
					//JOptionPane.showMessageDialog(AddC.this, "Welcome to Swing!");
					
				}
				
			});
		

		
		
	}

}
