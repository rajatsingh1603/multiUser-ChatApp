package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField cityField;
	private JTextField phoneField;
	

	

	
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}
	
	UserDAO userDAO = new UserDAO();
	
	
	private void clearField() {
		
		
		textField.setText("");
		passwordField.setText("");
		emailField.setText("");
		cityField.setText("");
		phoneField.setText("");
	}
	
	private void changePassword() {
		ChangePassword changePassword = new ChangePassword();
		changePassword.setVisible(true);
		
	}
	
	private void doLogin() {
		
		String userId = textField.getText();
		char [] password = passwordField.getPassword(); //getpassword for not showing password on console
		
		
		UserDTO userDTO = new UserDTO(userId, password );
		try {
			String message = "";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome " + userId;
				UserInfo.USER_NAME = userId;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose(); //removes from memory
				Dashboard dashboard = new Dashboard(message); 
				dashboard.setVisible(true);
			}
			else {
				message = "Invalid userId or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			
//			JOptionPane.showMessageDialog(this, message);
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void register() {
		String userId = textField.getText();
		char [] password = passwordField.getPassword();  //getpassword for not showing password on console
		String email = emailField.getText();
		String city = cityField.getText();
		String phone = phoneField.getText();
		System.out.println(userId + " " + " " + password.toString() + email + city + phone);
		
		
		
		UserDTO userDTO = new UserDTO(userId, password,email,city,phone);
		
		try {
		int result = userDAO.add(userDTO); //passing address through add(userDTO) , which is a light weight process
		if(result > 0) {
//			System.out.println("Record Added...");
			JOptionPane.showMessageDialog(this, "Registration Success."); //this for in which class component you want to show , so this indicates the current class
		}
		else {
//			System.out.println("Record Not Added...");
			JOptionPane.showMessageDialog(this, "Registration Failed.");
		}
		}
		
		catch(ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue...");
			ex.printStackTrace(); //for printing the issue also where is the issue
		}
		
		catch(Exception ex) {
			System.out.println("Generic exception");
			ex.printStackTrace(); //where is the issue
		}
//		System.out.println(userId + " " + password + " " + password.toString() + email + city + phone);
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(438, 40, 231, 75);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(550, 135, 231, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel userlbl = new JLabel("UserId");
		userlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		userlbl.setBounds(390, 138, 113, 28);
		getContentPane().add(userlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		pwdlbl.setBounds(390, 214, 113, 28);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(550, 211, 231, 42);
		getContentPane().add(passwordField);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginbtn.setBounds(305, 516, 136, 42);
		getContentPane().add(loginbtn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(477, 516, 136, 42);
		getContentPane().add(btnRegister);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(390, 297, 113, 28);
		getContentPane().add(lblEmail);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCity.setBounds(390, 366, 113, 28);
		getContentPane().add(lblCity);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setColumns(10);
		emailField.setBounds(550, 283, 231, 42);
		getContentPane().add(emailField);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityField.setColumns(10);
		cityField.setBounds(550, 359, 231, 42);
		getContentPane().add(cityField);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(390, 442, 113, 28);
		getContentPane().add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phoneField.setColumns(10);
		phoneField.setBounds(550, 431, 231, 42);
		getContentPane().add(phoneField);
		
		JButton chngPswd = new JButton("Change Pass");
		chngPswd.setFont(new Font("Tahoma", Font.BOLD, 15));
		chngPswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		chngPswd.setBounds(645, 518, 136, 42);
		getContentPane().add(chngPswd);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});
		clear.setFont(new Font("Tahoma", Font.BOLD, 20));
		clear.setBounds(812, 516, 136, 42);
		getContentPane().add(clear);
		setSize(1186, 667);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
