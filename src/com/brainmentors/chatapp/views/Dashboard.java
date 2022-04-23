package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//					Dashboard frame = new Dashboard();
//					frame.setVisible(true);
//				
//	}

	/**
	 * Create the frame.
	 */
	public Dashboard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1217, 609);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu chatmenu = new JMenu("Chat");
		menuBar.add(chatmenu);
		
		JMenuItem startChat = new JMenuItem("Start Chat");
		startChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ClientChatScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		chatmenu.add(startChat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/iStock-1219032156.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton logout = new JButton("LogOut");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserScreen userScreen = new UserScreen();
				setVisible(false);
				
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(logout, BorderLayout.SOUTH);
	}

}
