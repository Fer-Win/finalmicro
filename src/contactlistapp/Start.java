package contactlistapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/contactlistapp/PngItem_4483955.png")));
		frame.getContentPane().setBackground(new Color(62, 62, 62));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start >>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntelF f1 = new IntelF();
				f1.getContentPane().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Product Sans", Font.BOLD, 14));
		btnNewButton.setBounds(162, 107, 107, 38);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		frame.setBounds(100, 100, 450, 195);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*ImageIcon img = new ImageIcon(this.getClass().getResource("PngItem_4483955.png"));
		JLabel lblNewLabel = new JLabel(img);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(2, -5, 150, 150);*/
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("PngItem_4483955.png"));
		Image image = imageIcon.getImage();
		int width = imageIcon.getIconWidth();
		int height = imageIcon.getIconHeight();
		int scaledWidth = width / 15; // set new width as half of original width
		int scaledHeight = height / 15; // set new height as half of original height
		Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(scaledImageIcon);
		frame.getContentPane().add(imageLabel);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(57, 30, 60, 60);
		
		JLabel lblNewLabel = new JLabel("My Contacts");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 27));
		lblNewLabel.setBounds(127, 43, 185, 47);
		frame.getContentPane().add(lblNewLabel);
	}
}
