package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MiniStatement extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cardNumber,pin;
	JLabel number, title, card, amount, balanceAmount, miniStmt;
	int balance = 0;
	public MiniStatement(String pin, String cardNumber) {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(400,900);
		setTitle("Mini Statement");
		setLocation(20, 20);
		int balance = 0;
		
		title = new JLabel("Indian Bank");
		title.setBounds(80, 40, 120, 25);
		title.setFont(new Font("Raleway", Font.BOLD, 20));
		add(title);
		
		card = new JLabel("Card No:");
		card.setBounds(30, 90, 60, 20);
		card.setFont(new Font("System", Font.BOLD, 12));
		add(card);
		
		
		miniStmt = new JLabel();
		miniStmt.setBounds(30, 130, 400, 20);
		add(miniStmt);
		
		try {
			
			Conn con = new Conn();
			number = new JLabel(cardNumber.substring(0,4) + "XXXXXXXX" + cardNumber.substring(12));
			number.setBounds(90, 90, 200, 20);
			number.setFont(new Font("System", Font.PLAIN, 12));
			add(number);
			
			ResultSet res = con.stmt.executeQuery("select * from bank where card_number = '"+cardNumber+"'  and pin = '"+pin+"' ");
			while(res.next()) {
				//setText does overide NOT append
				miniStmt.setText(miniStmt.getText() + "<html>" +  res.getString("date") + "&nbsp;&nbsp;&nbsp;"+ res.getString("type") + "&nbsp;&nbsp;&nbsp;"+ res.getString("amount")+ "<br>"+ "</html>");
			}
			
			ResultSet rs = con.stmt.executeQuery("select * from bank where card_number = '"+cardNumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		amount = new JLabel("Amount: ");
		amount.setBounds(30, 500, 60, 20);
		add(amount);
		
		balanceAmount = new JLabel("" + balance);
		balanceAmount.setBounds(90, 500, 100, 20);
		balanceAmount.setFont(new Font("System", Font.PLAIN, 12));
		add(balanceAmount);
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		new MiniStatement("","");
	}

}
