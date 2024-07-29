package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalancedEnquiry extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String cardNo, pin;
	JLabel image, money;
	JButton back;
	BalancedEnquiry(String pin, String cardNo) {
		this.cardNo = cardNo;
		this.pin = pin;
		
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(900, 900);
		setTitle("Balance Enquiry");
		setLocation(300, 0);
		
		
		ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
		Image img = atm.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(img);
		
		image = new JLabel(newImg);
		image.setBounds(0, 0, 900, 900);
		add(image);
		int balance = 0;
		try {
			
			Conn con = new Conn();
			String query = "select * from bank where pin = '"+pin+"' and card_number = '"+cardNo+"'";
			ResultSet res = con.stmt.executeQuery(query);
			
			while(res.next()) {
				if(res.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(res.getString("amount"));
				} else {
					balance -= Integer.parseInt(res.getString("amount"));
				}
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		money = new JLabel("Your account balance is Rs " + balance);
		money.setBounds(190, 400, 300, 20);
		money.setFont(new Font("Raleway", Font.BOLD, 18));
		money.setForeground(Color.WHITE);
		image.add(money);
		
		
		back = new JButton("Back");
		back.setBounds(410, 486, 100, 30);
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.addActionListener(this);
		image.add(back);
		
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			setVisible(false);
			new Transactions(pin, cardNo).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new BalancedEnquiry("","");
	}

}
