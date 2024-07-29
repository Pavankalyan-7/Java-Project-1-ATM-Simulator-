package bms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DepositSuccess extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DepositSuccess() {
		getContentPane().setBackground(Color.WHITE);
		setSize(600,600);
		setTitle("SUCCESS PAGE");
		setLocation(300, 10);
		
		JLabel amount = new JLabel("amount deposited successfully");
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DepositSuccess();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
