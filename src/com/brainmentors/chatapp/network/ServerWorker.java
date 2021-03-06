package com.brainmentors.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
	
	private Socket clientSocket;
	
	private InputStream in;
	private OutputStream out;
	private Server server;
	
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		this.server = server; //here comes all the information of clients through server , which we use to broadcast a message to these all
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream(); //read client data
		out = clientSocket.getOutputStream(); //write client data
		System.out.println("New Client Comes.");
	}
	@Override
	public void run() {
		//read data from client and broadcast to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in)); //it reads data line by line and return it into string form
		String line;

		try {
		while(true) { //read data until we are recieving the data
			
				line = br.readLine(); //we have taken the data
				System.out.println("Line Read "+ line);
				if(line.equalsIgnoreCase("quit")) {
					break; //client chat ended if he says quit
				}
//				out.write(line.getBytes()); //client send    through this the message is going to only one client 
				//now for sending the message to all clients i.e broadcast the message 
				
				for(ServerWorker serverWorker : server.workers) { //through server.workers we are getting all the workers from servers
					
					line = line + "\n";
					serverWorker.out.write(line.getBytes()); //now it is broadcasting the message to all clients
				}
			} 
		}
		catch (IOException e) {
			
			e.printStackTrace();
		
		} 
		finally {
			
			try {
			if(br != null) {
				br.close();
			}
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
			if(clientSocket != null){
				clientSocket.close();
			}
			
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
































//public class ServerWorker implements Runnable { //through runnable we are creating a job  ----------- 1-way to create thread

//public class ServerWorker extends Thread{
//	
//	@Override
//	public void run() { //through run we are creating the job logic
//		//logic
//		for(int i = 1; i <=5; i++) {
//			System.out.println("Run " + i + Thread.currentThread());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public static void main(String args []) {
//		
//		ServerWorker job = new ServerWorker();
//		job.start();
//		
//		//Assign a job to a thread
////		Thread worker = new Thread(job); 1Part
////		worker.start(); //starts the worker internally it calls run()  , through this a stack created paralaly of worker (parallel to main thread stack)
//		for(int j = 1; j <=5; j++) {
//			System.out.println("Main " + j + Thread.currentThread());
//		}
//	}
//	
//}
