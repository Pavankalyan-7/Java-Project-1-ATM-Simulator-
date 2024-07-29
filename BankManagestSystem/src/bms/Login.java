package bms;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JButton login, clear, signUp;
	JTextField cardTextField;
	JPasswordField pinTextField;
	String cardNumber, pin;
	
	Login() {
		// To create a frame we need to use Swing.
		//JFrame class is used to create a frame.(Package:: javax.swing.JFrame)
		setTitle("AUTOMATED TELLER MACHINE");
		
		setSize(800, 480);
		setLocation(100, 100);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		//Adding components over frame
		ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("./icons/logo.jpg"));
		
		//To scale images
		//Image -- available in java.awt package.
		Image img = imgIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		
		//converting img (Image to ImageIcon type)
		ImageIcon imgIcon2 = new ImageIcon(img);
		
		JLabel logoLabel = new JLabel(imgIcon2);
		logoLabel.setBounds(70, 10, 100, 100);
		add(logoLabel);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200, 10, 400, 100);
		text.setFont(new Font("Osward", Font.BOLD, 38));
		add(text);
		
		
		JLabel cardNo = new JLabel("Card No: ");
		cardNo.setBounds(100, 150, 150, 30);
		cardNo.setFont(new Font("Raleway", Font.BOLD, 25));
		
		JLabel pin = new JLabel("PIN: ");
		pin.setBounds(100, 200, 100, 30);
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		
		add(cardNo);
		add(pin);
		
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 155, 250, 30);
		cardTextField.setFont(new Font("Roboto", Font.BOLD, 16));
		add(cardTextField);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 205, 250, 30);
//		jFrame.setBounds(300, 100, 800, 480);
	
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 260, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Osward", Font.BOLD, 16));
		login.addActionListener(this);
		
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(450, 260, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Osward", Font.BOLD, 16));
		clear.addActionListener(this);
		
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(300, 300, 250, 30);
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		signUp.setFont(new Font("Osward", Font.BOLD, 16));
		signUp.addActionListener(this);
		add(signUp);	
		
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == clear) {
			 
			cardTextField.setText("");
			pinTextField.setText("");
			
		} else if(e.getSource() == login) {
			try {
				Conn con = new Conn();
				String cardNo = cardTextField.getText();
				String pinNo = pinTextField.getText();
				
				String query = "select * from login where card_number = '"+cardNo+"' and pin = '"+pinNo+"'";
				ResultSet res = con.stmt.executeQuery(query); //DDL command
				if(res.next()) {
					setVisible(false);
					new Transactions(pinNo, cardNo).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
	
		} else if(e.getSource() == signUp) {
			setVisible(false);
			new SignUpOne().setVisible(true); 
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
}