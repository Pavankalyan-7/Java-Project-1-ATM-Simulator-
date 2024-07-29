package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pin, cardNumber;
	JLabel image, oldPin, newPin, confirmNewPin;
	JPasswordField oldPinField, newPinField, confirmNewPinField;
	JButton change, back;
	
	PinChange(String pin, String cardNumber) {
		this.pin = pin;
		this.cardNumber = cardNumber;
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(900, 900);
		setTitle("PIN CHANGE SCREEN");
		setLocation(300, 0);
		
		
		ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
		Image img = atm.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(img);
		
		image = new JLabel(newImg);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel info = new JLabel("Change your PIN");
		info.setBounds(225, 290, 400, 30);
		info.setFont(new Font("Oswald", Font.BOLD, 24));
		info.setForeground(Color.white);
		image.add(info);
		
		oldPin = new JLabel("ENTER OLD PIN:");
		oldPin.setBounds(200, 350, 200,20);
		oldPin.setForeground(Color.WHITE);
		oldPin.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(oldPin);
		
		oldPinField = new JPasswordField();
		oldPinField.setBounds(350, 350, 120, 20);
		image.add(oldPinField);
		
		
		newPin = new JLabel("NEW PIN:");
		newPin.setBounds(200, 380, 200,20);
		newPin.setForeground(Color.WHITE);
		newPin.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(newPin);
		
		
		newPinField = new JPasswordField();
		newPinField.setBounds(350, 380, 120, 20);
		image.add(newPinField);
		
		confirmNewPin = new JLabel("CONFIRM PIN:");
		confirmNewPin.setBounds(200, 410, 200,20);
		confirmNewPin.setForeground(Color.WHITE);
		confirmNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(confirmNewPin);
		
		confirmNewPinField = new JPasswordField();
		confirmNewPinField.setBounds(350, 410, 120, 25);
		image.add(confirmNewPinField);
		
		change = new JButton("Change");
		change.setBounds(210, 480, 120, 30);
		change.setFont(new Font("Raleway", Font.BOLD, 16));
		change.setForeground(Color.WHITE);
		change.setBackground(Color.GRAY);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(345, 480, 120, 30);
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.GRAY);
		back.addActionListener(this);
		image.add(back);
		
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String newPIN = newPinField.getText();
		String confirmNEWPIN = confirmNewPinField.getText();
		if(e.getSource() == change) {
			
			if(!newPIN.equals(confirmNEWPIN)) {
				JOptionPane.showMessageDialog(null, "New PIN and Confirm NEW PIN are not matched. Please enter the correct PIN");
				return;
			}
			if(newPIN.isBlank() || newPIN.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the PIN atleast 4 characters");
				return;
			}
			try {
				
				Conn con = new Conn();
//				String query = "update login set pin = '"+newPIN+"' where pin = '"+pin+"'";
				con.stmt.executeUpdate("update login set pin = '"+newPIN+"' where card_number = '"+cardNumber+"'");
				con.stmt.executeUpdate("update signupthree set pin_number = '"+newPIN+"' where card_number = '"+cardNumber+"' ");
				con.stmt.executeUpdate("update bank set pin = '"+newPIN+"' where card_number = '"+cardNumber+"' ");
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				
				setVisible(false);
				new Login().setVisible(true);
				
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		} else if(e.getSource() == back) {
			setVisible(false);
			new Transactions(newPIN, cardNumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new PinChange("", "");
	}

}
