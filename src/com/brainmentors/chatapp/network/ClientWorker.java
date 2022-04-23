package com.brainmentors.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

//creating thread for reading the data
public class ClientWorker extends Thread {
	private InputStream in;
	private JTextArea textArea; //for showing the message on a text area through swing
	
	public ClientWorker(InputStream in , JTextArea textArea) {
		this.in = in;
		this.textArea = textArea;
	}

	@Override
	public void run() { //for job logic
		 BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 String line;
		
		 try {
		while(true) {
			line = br.readLine(); //data has come
			textArea.setText(textArea.getText() +line );  
			// getText() is for previous message , line is for current message
			// "\n" is added so that on new message send it will show on a new line
		}
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 finally {
			 if( in != null) {
				 try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 }
	}
}
