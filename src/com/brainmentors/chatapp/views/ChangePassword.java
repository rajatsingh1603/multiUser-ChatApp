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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JButton btnNewButton;
	private JLabel lblConfirmPassword;
	private JPasswordField newpass;
	private JPasswordField changepass;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
	
	public void chngPswd() throws NoSuchAlgorithmException, ClassNotFoundException, SQLException {
		
		try {
		String userId = userid.getText();
		char [] np = newpass.getPassword();
		char [] cp = changepass.getPassword();
		
		if(new String(np).equals(new String(cp))){
			int ans = UserDAO.changePassword(userId , np);
			if(ans == 1) {
				JOptionPane.showMessageDialog(this, "Password changed");
				setVisible(false);
				UserScreen userScreen = new UserScreen();
				
			}
			else {
				JOptionPane.showMessageDialog(this, "UserId do not Exist");
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Password doesn't matched");
		}
		
		
		}
		
		catch(SQLException e ){
			e.printStackTrace();
		}
		catch(ClassNotFoundException cn) {
			cn.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	public static void main(String[] args) {
		
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Id ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(136, 84, 193, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewPassword.setBounds(136, 165, 193, 38);
		contentPane.add(lblNewPassword);
		
		userid = new JTextField();
		userid.setBounds(351, 89, 187, 38);
		contentPane.add(userid);
		userid.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					chngPswd();
				} catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(301, 306, 127, 36);
		contentPane.add(btnNewButton);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(136, 232, 193, 38);
		contentPane.add(lblConfirmPassword);
		
		newpass = new JPasswordField();
		newpass.setBounds(351, 170, 187, 38);
		contentPane.add(newpass);
		
		changepass = new JPasswordField();
		changepass.setBounds(351, 237, 187, 38);
		contentPane.add(changepass);
	}
}
