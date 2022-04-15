package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	public Server() throws IOException{
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server started & waiting for client connection....");
		Socket socket = serverSocket.accept(); //handshaking
		System.out.println("Client joins the server");
		InputStream in = socket.getInputStream(); //read bytes from the netowrk
		byte arr[] = in.readAllBytes();
		String str = new String(arr); //bytes to string conversion
		System.out.println("Message Recieved : " + str);
		in.close();
		
		
		socket.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Server server = new Server();
	}

}
