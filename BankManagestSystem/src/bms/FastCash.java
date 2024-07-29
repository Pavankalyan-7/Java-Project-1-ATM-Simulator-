package bms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel image, info;
	JButton hundredRs, fiveHundRs, thousandRs, twoThousandRs, fiveThousandRs, tenThousandRs, back;
	String pinNumber, cardNumber;
	FastCash(String pinNumber, String cardNumber) {
		
		this.pinNumber = pinNumber;
		this.cardNumber = cardNumber;
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(900, 900);
		setTitle("Transactions Home Page");
		setLocation(300, 0);
		
		
		ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
		Image img = atm.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(img);
		
		image = new JLabel(newImg);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		info = new JLabel("SELECT WITHDRAWL AMOUNT");
		info.setBounds(200, 300, 600, 30);
		info.setFont(new Font("Osward", Font.BOLD, 18));
		info.setForeground(Color.WHITE);
		image.add(info);
		
		hundredRs = new JButton("Rs 100");
		hundredRs.setBounds(170, 417, 140, 30);
		hundredRs.setFont(new Font("Raleway", Font.BOLD, 12));
		hundredRs.addActionListener(this);
		image.add(hundredRs);
		
		
		fiveHundRs = new JButton("Rs 500");
		fiveHundRs.setBounds(170, 450, 140, 30);
		fiveHundRs.setFont(new Font("Raleway", Font.BOLD, 12));
		fiveHundRs.addActionListener(this);
		image.add(fiveHundRs);
		
		thousandRs = new JButton("Rs 1000");
		thousandRs.setBounds(170, 484, 140, 30);
		thousandRs.setFont(new Font("Raleway", Font.BOLD, 12));
		thousandRs.addActionListener(this);
		image.add(thousandRs);
		
		
		twoThousandRs = new JButton("Rs 2000");
		twoThousandRs.setBounds(360, 417, 140, 30);
		twoThousandRs.setFont(new Font("Raleway", Font.BOLD, 12));
		twoThousandRs.addActionListener(this);
		image.add(twoThousandRs);
		
		fiveThousandRs = new JButton("Rs 5000");
		fiveThousandRs.setBounds(360, 450, 140, 30);
		fiveThousandRs.setFont(new Font("Raleway", Font.BOLD, 12));
		fiveThousandRs.addActionListener(this);
		image.add(fiveThousandRs);
		
		tenThousandRs = new JButton("Rs 10000");
		tenThousandRs.setBounds(360, 484, 140, 30);
		tenThousandRs.setFont(new Font("Raleway", Font.BOLD, 12));
		tenThousandRs.addActionListener(this);
		image.add(tenThousandRs);
		
		back = new JButton("Back");
		back.setBounds(360, 518, 140, 30);
		back.setFont(new Font("Raleway", Font.BOLD, 12));
		back.addActionListener(this);
		image.add(back);
		
		
//		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FastCash("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber, cardNumber).setVisible(true);
		} else {
		
			String amount = ((JButton)e.getSource()).getText().substring(3);
			try {
				Conn con = new Conn();
				int balance = 0;
				ResultSet res = con.stmt.executeQuery("select * from bank where card_number = '"+cardNumber+"' and pin = '"+pinNumber+"' ");
				while(res.next()) {
					if(res.getString("type").equals("Deposit"))
						balance += Integer.parseInt(res.getString("amount"));
					else balance -= Integer.parseInt(res.getString("amount"));
				}
				
				if(e.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values ('"+cardNumber+"','"+pinNumber+"', 'Withdrawl','"+amount+"' , '"+date+"')";
				con.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount + " debited successfully");
				
				
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}
}
