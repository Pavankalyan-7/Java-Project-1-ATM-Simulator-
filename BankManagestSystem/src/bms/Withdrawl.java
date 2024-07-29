package bms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

import javax.swing.JFrame;

public class Withdrawl extends JFrame implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		JButton withdraw, back; 
		JLabel newImage, text;
		JTextField amountField;
		String pin, cardNumber;
		
		Withdrawl(String pin, String cardNumber) {
			
			this.pin = pin;
			this.cardNumber = cardNumber;
			setLayout(null);
			getContentPane().setBackground(Color.WHITE);
			setTitle("WITHDRAW SCREEN");
			setSize(800,800);
			setLocation(300, 10);
			
			ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
			Image image = imgIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
			ImageIcon img = new ImageIcon(image);
			
			newImage = new JLabel(img);
			newImage.setBounds(0, 0, 800, 800);
			add(newImage);
			
			text = new JLabel("Enter the amount you want to withdraw:");
			text.setBounds(150, 300, 280, 30);
			text.setFont(new Font("System",Font.BOLD, 14));
			text.setForeground(Color.WHITE);
			newImage.add(text);
			
			amountField = new JTextField();
			amountField.setBounds(150, 340, 300, 25);
			newImage.add(amountField);
			
			withdraw = new JButton("Withdrawl");
			withdraw.setBounds(360, 433, 100, 25);
			withdraw.addActionListener(this);
			newImage.add(withdraw);
			
			back = new JButton("Back");
			back.setBounds(360, 463, 100, 25);
			back.addActionListener(this);
			newImage.add(back);
			
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == withdraw) {
				String amount = amountField.getText();
				Date date = new Date();
				
				if(amount.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
				} 
				try {
					
					Conn con = new Conn();
					String query = "insert into bank values ('"+cardNumber+"','"+pin+"','Withdrawl',  '"+amount+"', '"+date+"')";
					con.stmt.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, amount+" withdrawn successfully.");
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
			new Withdrawl("","");
		}
}
