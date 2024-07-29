package bms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel image, info;
	JButton deposit, fastCash, cashWithdrawl, pinChange, miniStatement, balanceEnquiry, exit;
	String pinNumber, cardNumber;
	public Transactions(String pinNumber, String cardNumber) {
		
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
		
		info = new JLabel("Please select your Transaction");
		info.setBounds(200, 300, 600, 30);
		info.setFont(new Font("Osward", Font.BOLD, 18));
		info.setForeground(Color.WHITE);
		image.add(info);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 417, 140, 30);
		deposit.setFont(new Font("Raleway", Font.BOLD, 12));
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 450, 140, 30);
		fastCash.setFont(new Font("Raleway", Font.BOLD, 12));
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170, 484, 140, 30);
		pinChange.setFont(new Font("Raleway", Font.BOLD, 12));
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		
		cashWithdrawl = new JButton("Cash Withdrawl");
		cashWithdrawl.setBounds(360, 417, 140, 30);
		cashWithdrawl.setFont(new Font("Raleway", Font.BOLD, 12));
		cashWithdrawl.addActionListener(this);
		image.add(cashWithdrawl);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(360, 450, 140, 30);
		miniStatement.setFont(new Font("Raleway", Font.BOLD, 12));
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(360, 484, 140, 30);
		balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 12));
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(360, 518, 140, 30);
		exit.setFont(new Font("Raleway", Font.BOLD, 12));
		exit.addActionListener(this);
		image.add(exit);
		
		
//		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Transactions("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}
		
		else if(e.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinNumber,cardNumber).setVisible(true);
		}
		else if(e.getSource() == cashWithdrawl)  {
			setVisible(false);
			new Withdrawl(pinNumber, cardNumber).setVisible(true);
		}
		
		else if(e.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pinNumber, cardNumber).setVisible(true);
		} else if(e.getSource() == pinChange) {
			setVisible(false);
			new PinChange(pinNumber, cardNumber).setVisible(true);
		} else if(e.getSource() == balanceEnquiry) {
			setVisible(false);
			new BalancedEnquiry(pinNumber, cardNumber).setVisible(true);
		} else if(e.getSource() == miniStatement) {
//			setVisible(false);
			new MiniStatement(pinNumber, cardNumber).setVisible(true);
		}
	}
}
