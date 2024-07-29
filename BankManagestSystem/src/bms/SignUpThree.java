package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel accountDetails, accountType, cardNumber, cardDesc, cardNumberFormat, pin, pinDesc, pinNumberFormat, services ; 
	JCheckBox atmCard, internetBanking, mobileBanking, emailAndSmsAlerts, chequeBook, eStatement, declaration;
	JRadioButton savingsAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
	JButton submit, cancel;
	String formNumber;
	SignUpThree(String formNumber) {
		
		this.formNumber = formNumber;
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 800);
		setTitle("NEW ACCOUNT APPLICATION  - PAGE 3");
		setLocation(300, 10);
		setLayout(null);
		
		accountDetails = new JLabel("Page 3: Account Details");
		accountDetails.setBounds(250, 30, 600, 40);
		accountDetails.setFont(new Font("Osward", Font.BOLD, 24));
		add(accountDetails);
		
		
		accountType = new JLabel("Account Type");
		accountType.setBounds(100, 100, 400, 30);
		accountType.setFont(new Font("Osward", Font.BOLD, 20));
		add(accountType);
		
		savingsAccount = new JRadioButton("Savings Account");
		savingsAccount.setBounds(100, 140, 200, 22);
		savingsAccount.setFont(new Font("Raleway",Font.BOLD,16));
		savingsAccount.setBackground(Color.WHITE);
		savingsAccount.setForeground(Color.BLACK);
		add(savingsAccount);
		
		fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
		fixedDepositAccount.setBounds(400, 140, 300, 22);
		fixedDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
		fixedDepositAccount.setBackground(Color.WHITE);
		fixedDepositAccount.setForeground(Color.BLACK);
		add(fixedDepositAccount);
		
		
		currentAccount = new JRadioButton("Current Account");
		currentAccount.setBounds(100, 180, 200, 22);
		currentAccount.setFont(new Font("Raleway",Font.BOLD,16));
		currentAccount.setBackground(Color.WHITE);
		currentAccount.setForeground(Color.BLACK);
		add(currentAccount);
		
		
		recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
		recurringDepositAccount.setBounds(400, 180, 300, 22);
		recurringDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
		recurringDepositAccount.setBackground(Color.WHITE);
		recurringDepositAccount.setForeground(Color.BLACK);
		add(recurringDepositAccount);
		
		
		ButtonGroup accountTypeGroup = new ButtonGroup();
		accountTypeGroup.add(currentAccount);
		accountTypeGroup.add(fixedDepositAccount);
		accountTypeGroup.add(savingsAccount);
		accountTypeGroup.add(recurringDepositAccount);
		
		
		cardNumber = new JLabel("Card Number");
		cardNumber.setBounds(100, 225, 400, 30);
		cardNumber.setFont(new Font("Osward", Font.BOLD, 22));
		add(cardNumber);
		cardDesc = new JLabel(" Your 16 Digit Card Number");
		cardDesc.setBounds(100, 250, 600, 14);
		cardDesc.setFont(new Font("Osward", Font.BOLD, 10));
		add(cardDesc);
		
		cardNumberFormat = new JLabel("XXXX-XXXX-XXXX-1234");
		cardNumberFormat.setBounds(400, 225, 400, 30);
		cardNumberFormat.setFont(new Font("Osward", Font.BOLD, 22));
		add(cardNumberFormat);
		
		
		pin = new JLabel("PIN:");
		pin.setBounds(100, 280, 400, 30);
		pin.setFont(new Font("Osward", Font.BOLD, 22));
		add(pin);
		pinDesc = new JLabel("Your 4 Digit Password");
		pinDesc.setBounds(100, 310, 600, 12);
		pinDesc.setFont(new Font("Osward", Font.BOLD, 10));
		add(pinDesc);
		
		pinNumberFormat = new JLabel("XXXX");
		pinNumberFormat.setBounds(400, 280, 400, 30);
		pinNumberFormat.setFont(new Font("Osward", Font.BOLD, 22));
		add(pinNumberFormat);
		
		
		services = new JLabel("Services Required: ");
		services.setBounds(100, 340, 400, 30);
		services.setFont(new Font("Osward", Font.BOLD, 22));
		add(services);
		
		
		atmCard = new JCheckBox("ATM CARD");
		atmCard.setBounds(100, 380, 200, 30);
		atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
		atmCard.setBackground(Color.WHITE);
		atmCard.setForeground(Color.BLACK);
		add(atmCard);
		
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setBounds(100, 430, 200, 30);
		mobileBanking.setBackground(Color.WHITE);
		mobileBanking.setForeground(Color.BLACK);
		add(mobileBanking);
		
		chequeBook = new JCheckBox("ChequeBook");
		chequeBook.setBounds(100, 480, 200, 30);
		chequeBook.setBackground(Color.WHITE);
		chequeBook.setForeground(Color.BLACK);
		add(chequeBook);
		
		
		internetBanking = new JCheckBox("Internet Banking");
		internetBanking.setBounds(400, 380, 200, 30);
		internetBanking.setBackground(Color.WHITE);
		internetBanking.setForeground(Color.BLACK);
		add(internetBanking);
		
		

		emailAndSmsAlerts = new JCheckBox("EMAIL & SMS Alerts");
		emailAndSmsAlerts.setBounds(400, 430, 200, 30);
		emailAndSmsAlerts.setBackground(Color.WHITE);
		emailAndSmsAlerts.setForeground(Color.BLACK);
		add(emailAndSmsAlerts);
		

		eStatement = new JCheckBox("E-Statement");
		eStatement.setBounds(400, 480, 200, 30);
		eStatement.setBackground(Color.WHITE);
		eStatement.setForeground(Color.BLACK);
		add(eStatement);
		
		
		declaration = new JCheckBox("I here by declare that provided information is correct and is up to my knowledge and consent.");
		declaration.setBounds(100, 550, 700, 30);
		declaration.setBackground(Color.WHITE);
		declaration.setForeground(Color.BLACK);
		add(declaration);
		
		
		submit = new JButton("Submit");
		submit.setBounds(150, 600, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(400, 600, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SignUpThree("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == submit) {
			String nAccountType = null;
//			savingsAccount, fixedDepostAccount, currentAccount, recurringDepositAccount;
			
			if(savingsAccount.isSelected()) {
				nAccountType = "Savings Account";
			} 
			else if(fixedDepositAccount.isSelected()) {
				nAccountType = "Fixed Deposit Account";
			}
			else if(currentAccount.isSelected()) {
				nAccountType = "Current Account";
			}
			else if(recurringDepositAccount.isSelected()) {
				nAccountType = "Recurring Deposit Account";
			}
			
			
			Random random = new Random();
			String cardNo = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L); 
			String pinNo = "" + Math.abs(random.nextLong() % 9000L + 1000L);
			

//			atmCard, internetBanking, mobileBanking, emailAndSmsAlerts, chequeBook, eStatement, declaration;
			
			String serviceList = "";
			
			if(atmCard.isSelected()) {
				serviceList = serviceList + " ATM Card";
			} 
			else if(internetBanking.isSelected()) {
				serviceList = serviceList + " Internet Banking";
			}
			else if(mobileBanking.isSelected()) {
				 serviceList = serviceList + " Mobile Banking";
			}
			else if(emailAndSmsAlerts.isSelected()) {
				serviceList = serviceList + " Email & SMS Alerts";
			}
			
			else if(chequeBook.isSelected()) {
				serviceList = serviceList + " Cheque Book";
			}
			else if(eStatement.isSelected()) {
				serviceList = serviceList + " E-Statement";
			}
			
			
			try {
				
				if(nAccountType.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				}
				if(!declaration.isSelected())
					JOptionPane.showMessageDialog(null, "Please tick the Declaration");
				else {
					
					Conn c = new Conn();
					String query = "insert into signupthree values('"+formNumber+"','"+nAccountType+"','"+cardNo+"', '"+pinNo+"' , '"+serviceList+"')";
					c.stmt.executeUpdate(query);
					
					String query2 = "insert into login values('"+formNumber+"','"+cardNo+"', '"+pinNo+"')";
					c.stmt.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+ cardNo + "\n Pin: " + pinNo);
					
					System.exit(0);
				}
				
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			
			setVisible(false);
			new Deposit(pinNo,cardNo).setVisible(true); // Zero account not possible
		} 
			
		else if(e.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}

}
