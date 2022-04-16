package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	InputStream in;
	OutputStream out;
	ClientWorker worker; //creating instance of clientWorker
	JTextArea textArea;
	
	
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		 socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		 out = socket.getOutputStream();
		 in = socket.getInputStream();
		 this.textArea = textArea;
		 readMessages();
//		 System.out.println("Client Comes...");
//		 System.out.println("Enter the message to send..");
//		 Scanner scanner = new Scanner(System.in);
//		 String message = scanner.nextLine();
//		 //now for sending this message
//		 OutputStream out = socket.getOutputStream(); //write bytes on network
//		 out.write(message.getBytes());
//		 System.out.println("Message sent to the server");
//		 scanner.close(); 
//		 out.close();
//		 socket.close();
	}
	
	public void sendMessage(String message) throws IOException {
		out.write(message.getBytes());
	}
	
	public void readMessages() {
		worker = new ClientWorker(in, textArea);   //clientWorker is creating a thread for reading data ,so we are making use of it here
		worker.start(); //trigger run of clientWorker 
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		// TODO Auto-generated method stub
//		Client client = new Client();
//		
//	}

}
