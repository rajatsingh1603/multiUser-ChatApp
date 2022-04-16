package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.network.Client;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
					ClientChatScreen frame = new ClientChatScreen();
					frame.setVisible(true);
				
	}
	
	private void sendMessage() {
		//extract the message 
		String message = textArea.getText();
		try {
			client.sendMessage(message);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//now we want this message will go to the server
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client = new Client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 792, 357);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea.setBounds(10, 24, 713, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(10, 394, 655, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sendButton.setBounds(675, 394, 127, 49);
		contentPane.add(sendButton);
		
		
	}
}
