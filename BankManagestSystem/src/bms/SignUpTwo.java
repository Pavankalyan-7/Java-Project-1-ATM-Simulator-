package bms;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel addDetails, religion, category, income, educationalQualification, occupation, panNumber, aadharNumber, seniorCitizen, existingAccount; 
	JTextField panNumberField, aadharNumberField;
	JRadioButton scYes, scNo, eaYes, eaNo; 
	JButton next;
	JComboBox religionField, incomeField, categoryField,educationField, occupationField;
	String formNumber;
	
	SignUpTwo(String formNumber) {
		
		this.formNumber = formNumber;
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 800);
		setLocation(300, 10);
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		addDetails = new JLabel("Page 2: Additional Details");
		addDetails.setBounds(280, 80, 350, 28);
		addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		add(addDetails);
		
		religion = new JLabel("Religion: ");
		religion.setBounds(100, 180, 200, 25);
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		add(religion);
		
		String[] varReligion = {"Hindu", "Muslim", "Christian", "Sikkism", "Jainism", "Other"}; 
		
		religionField = new JComboBox(varReligion);
		religionField.setBounds(300, 180, 380, 25);
		religionField.setBackground(Color.WHITE);
		religionField.setForeground(Color.BLACK);
		add(religionField);
		
		
		category = new JLabel("Category: ");
		category.setBounds(100, 220, 200, 25);
		category.setFont(new Font("Raleway",Font.BOLD,20));
		add(category);
		
		String categories[] = {"OC", "BC", "SC", "ST", "Others"};
		categoryField = new JComboBox(categories);
		categoryField.setBounds(300, 220, 380, 25);
		categoryField.setBackground(Color.WHITE);
		categoryField.setForeground(Color.BLACK);
		add(categoryField);
		
		

		income = new JLabel("Income: ");
		income.setBounds(100, 260, 200, 25);
		income.setFont(new Font("Raleway",Font.BOLD,20));
		add(income);
		
		
		String[] incomeTypes = {"0", "5L", "  7L ", "12L","15L", "Above 15" }; 
		
		incomeField = new JComboBox(incomeTypes);
		incomeField.setBackground(Color.WHITE);
		incomeField.setForeground(Color.BLACK);
		incomeField.setBounds(300, 260, 380, 25);
		add(incomeField);
		

		educationalQualification = new JLabel("Educational Qualification: ");
		educationalQualification.setBounds(100, 300, 200, 25);
		educationalQualification.setFont(new Font("Raleway",Font.BOLD,20));
		add(educationalQualification);
		
		
		String[] qualifications = {"B-tech", "B.Sc", "M.Sc", "M-Tech", "Other"};
		educationField = new JComboBox(qualifications);
		educationField.setBounds(300, 300, 380, 25);
		educationField.setBackground(Color.WHITE);
		educationField.setForeground(Color.BLACK);
		add(educationField);
		
		occupation = new JLabel("Occupation");
		occupation.setBounds(100, 340, 200, 25);
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		add(occupation);
		
		
		String[] occupations = {"Carpenter", "GoldSmith", "BusinessMan", "Doctor", "IT", "Other"};
		occupationField = new JComboBox(occupations);
		occupationField.setBounds(300, 340, 380, 25);
		occupationField.setBackground(Color.WHITE);
		occupationField.setForeground(Color.BLACK);
		add(occupationField);

		panNumber = new JLabel("PAN Number: ");
		panNumber.setBounds(100, 380, 200, 25);
		panNumber.setFont(new Font("Raleway",Font.BOLD,20));
		add(panNumber);
		
		
		panNumberField = new JTextField();
		panNumberField.setBounds(300, 380, 380, 25);
		panNumberField.addActionListener(this);
		add(panNumberField);
		
		aadharNumber = new JLabel("Aadhar Number: ");
		aadharNumber.setBounds(100, 420, 200, 25);
		aadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
		add(aadharNumber);
		
		aadharNumberField = new JTextField();
		aadharNumberField.setBounds(300, 420, 380, 25);
		add(aadharNumberField);

		seniorCitizen = new JLabel("Senior Citizen: ");
		seniorCitizen.setBounds(100, 460, 200, 25);
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
		add(seniorCitizen);
		
		
		scYes = new JRadioButton("Yes");
		scYes.setBounds(300, 460, 50, 25);
		scYes.setBackground(Color.WHITE);
		scYes.setForeground(Color.BLACK);
		add(scYes);
		
		scNo = new JRadioButton("No");
		scNo.setBounds(400, 460, 50, 25);
		scNo.setBackground(Color.WHITE);
		scNo.setForeground(Color.BLACK);
		add(scNo);
		
		ButtonGroup seniorBtnGrp = new ButtonGroup();
	
		seniorBtnGrp.add(scYes);
		seniorBtnGrp.add(scNo);

		existingAccount = new JLabel("Existing Account: ");
		existingAccount.setBounds(100, 500, 200, 25);
		existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
		add(existingAccount);

		eaYes = new JRadioButton("Yes");
		eaYes.setBounds(300, 500, 50, 25);
		eaYes.setBackground(Color.WHITE);
		eaYes.setForeground(Color.BLACK);
		add(eaYes);
		
		eaNo = new JRadioButton("No");
		eaNo.setBounds(400, 500, 50, 25);
		eaNo.setBackground(Color.WHITE);
		eaNo.setForeground(Color.BLACK);
		add(eaNo);
		
		ButtonGroup exisingAcntBtnGrp = new ButtonGroup();
		
		exisingAcntBtnGrp.add(eaYes);
		exisingAcntBtnGrp.add(eaNo);
		
		
		next = new JButton("Next");
		next.setBounds(500, 590, 180, 28);
		next.setFont(new Font("Raleway",Font.BOLD,20));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SignUpTwo("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nReligion = religionField.getSelectedItem().toString();
		String nCategory = categoryField.getSelectedItem().toString();
		String nIncome = incomeField.getSelectedItem().toString();
		String nEducation = educationField.getSelectedItem().toString();
		String nOccupation = occupationField.getSelectedItem().toString();
		String pan  = panNumberField.getText(); 
		String aadhar = aadharNumberField.getText();
		
		String seniorCitizen = null;
		
		if(scYes.isSelected())
			seniorCitizen = "Yes";
		else seniorCitizen = "No";
		
		String existingAccount = null;
		
		if(eaYes.isSelected()) existingAccount = "Yes";
		else existingAccount = "No";
		
		
		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formNumber+"','"+nReligion+"','"+nCategory+"','"+nIncome+"','"+nEducation+"','"+nOccupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
			c.stmt.executeUpdate(query);
			
			setVisible(false);
			new SignUpThree(formNumber).setVisible(true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
