package bms;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long random;
	JTextField nameField,fNameField, emailField, addrField,cityField, pinField, stateField;
	JButton next;
	JLabel formNo, personalDetails, name, fatherName, dob, gender, email, status, addr, state, city, pincode;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser dobField;

	SignUpOne() {
		
		//creation of frame
		setSize(800, 800);
		setLocation(300, 10);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		getContentPane().setBackground(Color.WHITE);
		
		
		setLayout(null);
		
		Random ran = new Random();
		
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		formNo = new JLabel("Application Form No: " + random);
		formNo.setBounds(200, 20, 600, 40);
		formNo.setFont(new Font("Raleway", Font.BOLD, 30));
		add(formNo);
		
		
		personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setBounds(280, 80, 350, 28);
		personalDetails.setFont(new Font("Raleway", Font.PLAIN, 22));
		add(personalDetails);
		
		
		name = new JLabel("Name: ");
		name.setBounds(100, 180, 150, 25);
		name.setFont(new Font("Raleway",Font.BOLD,20));
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(300, 180, 380, 25);
		add(nameField);
		
		
		fatherName = new JLabel("Father's Name: ");
		fatherName.setBounds(100, 220, 150, 25);
		fatherName.setFont(new Font("Raleway",Font.BOLD,20));
		add(fatherName);
		
		fNameField = new JTextField();
		fNameField.setBounds(300, 220, 380, 25);
		add(fNameField);
		
		

		dob = new JLabel("Date of Birth: ");
		dob.setBounds(100, 260, 150, 25);
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		add(dob);
		
		dobField = new JDateChooser();
		dobField.setBackground(Color.WHITE);
		dobField.setForeground(Color.BLACK);
		dobField.setBounds(300, 260, 380, 25);
		add(dobField);
		

		gender = new JLabel("Gender: ");
		gender.setBounds(100, 300, 150, 25);
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 300, 120, 25);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 300, 120, 25);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		

		email = new JLabel("Email Address: ");
		email.setBounds(100, 340, 150, 25);
		email.setFont(new Font("Raleway",Font.BOLD,20));
		add(email);
		
		emailField = new JTextField();
		emailField.setBounds(300, 340, 380, 25);
		add(emailField);

		status = new JLabel("Marital Status: ");
		status.setBounds(100, 380, 150, 25);
		status.setFont(new Font("Raleway",Font.BOLD,20));
		add(status);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 380, 120, 25);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 380, 120, 25);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(600, 380, 120, 25);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		addr = new JLabel("Address: ");
		addr.setBounds(100, 420, 150, 25);
		addr.setFont(new Font("Raleway",Font.BOLD,20));
		add(addr);
		
		addrField = new JTextField();
		addrField.setBounds(300, 420, 380, 25);
		add(addrField);

		city = new JLabel("City: ");
		city.setBounds(100, 460, 150, 25);
		city.setFont(new Font("Raleway",Font.BOLD,20));
		add(city);
		
		cityField = new JTextField();
		cityField.setBounds(300, 460, 380, 25);
		add(cityField);
		

		pincode = new JLabel("Pincode: ");
		pincode.setBounds(100, 500, 150, 25);
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		add(pincode);
		
		pinField = new JTextField();
		pinField.setBounds(300, 500, 380, 25);
		add(pinField);
		

		state = new JLabel("State: ");
		state.setBounds(100, 540, 150, 25);
		state.setFont(new Font("Raleway",Font.BOLD,20));
		add(state);
		
		stateField = new JTextField();
		stateField.setBounds(300, 540, 380, 25);
		add(stateField);
		
		next = new JButton("Next");
		next.setBounds(580, 590, 100, 28);
		next.setFont(new Font("Raleway",Font.BOLD,20));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignUpOne();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formNumber = "" + random;
		String name = nameField.getText();
		String fatherName = fNameField.getText();
		String dob = dobField.getDateFormatString();
		String gender = null;
		
		if(male.isSelected()) gender = "Male";
		else if(female.isSelected()) gender = "Female";
		
		String email = emailField.getText();
		
		
		String maritalStatus = null;
		
		if(married.isSelected()) {
			maritalStatus = "Married";
		} else if(unmarried.isSelected()) {
			maritalStatus = "Unmarried";
		} else {
			maritalStatus = "Other";
		}
		
		String address = addrField.getText();
		String city = cityField.getText();
		String state = stateField.getText();
		String pincode = pinField.getText();

		
		try {
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('"+formNumber+"','"+name+"','"+fatherName+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.stmt.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formNumber).setVisible(true);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
