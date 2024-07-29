package bms;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
public class Deposit extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JButton deposit, back; 
	JLabel newImage, text;
	JTextField amountField;
	String pin,cardNumber;
	
	
	public Deposit(String pin, String cardNumber) {
		
		this.pin = pin;
		this.cardNumber = cardNumber;
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("DEPOSIT SCREEN");
		setSize(800,800);
		setLocation(300, 10);
		
		ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
		Image image = imgIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(image);
		
		newImage = new JLabel(img);
		newImage.setBounds(0, 0, 800, 800);
		add(newImage);
		
		text = new JLabel("Enter the amount you want to deposit:");
		text.setBounds(150, 300, 280, 30);
		text.setFont(new Font("System",Font.BOLD, 14));
		text.setForeground(Color.WHITE);
		newImage.add(text);
		
		amountField = new JTextField();
		amountField.setBounds(150, 340, 300, 25);
		newImage.add(amountField);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(360, 433, 100, 25);
		deposit.addActionListener(this);
		newImage.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(360, 463, 100, 25);
		back.addActionListener(this);
		newImage.add(back);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == deposit) {
			String amount = amountField.getText();
			Date date = new Date();
			
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			} 
			try {
				
				Conn con = new Conn();
				String query = "insert into bank values ('"+cardNumber+"','"+pin+"','Deposit','"+amount+"', '"+date+"')";
				con.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, amount+" deposited successfully.");
				setVisible(false);
				new Transactions(pin, cardNumber).setVisible(true);
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		} else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pin, cardNumber).setVisible(true);
		}
		
		
	}
	public static void main(String[] args) {
		new Deposit("","");
	}

}
