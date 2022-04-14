package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		 socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		 System.out.println("Client Comes...");
		 System.out.println("Enter the message to send..");
		 Scanner scanner = new Scanner(System.in);
		 String message = scanner.nextLine();
		 //now for sending this message
		 OutputStream out = socket.getOutputStream(); //write bytes on network
		 out.write(message.getBytes());
		 System.out.println("Message sent to the server");
		 scanner.close();
		 out.close();
		 socket.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		
	}

}
