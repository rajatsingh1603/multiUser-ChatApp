package com.brainmentors.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter;
	public UserView() {
		counter = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on close it will close from everywhere
		setSize(500,500); //setting size of the window
		setResizable(false);
		setTitle("Login");
		setLocationRelativeTo(null);
//		setLocation(500,150);
		
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		
		//adding to screen logic
		Container container = this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(100,70,200,60);
		container.add(welcome);
		
		//adding button
		JButton button = new JButton("Count");
		
		//adding event listener to the onclick of button
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				counter++;
				welcome.setText("Count : " + counter);
				
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		
		setVisible(true);  //sets the visibility to true
	}
	public static void main(String args[]) {
		UserView userView = new UserView();
	}
}
