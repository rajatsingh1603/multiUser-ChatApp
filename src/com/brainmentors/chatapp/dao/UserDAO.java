package com.brainmentors.chatapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.Encryption;

public class UserDAO {
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		
		System.out.println("Rec : " + userDTO.getUserId() + " " + userDTO.getPassword());
		
		//inserting it into database
		Connection connection = null; 
		
		//for query
		Statement stmt = null;
		
		try { //guarded region
		//establising connection
 		connection = CommanDAO.createConnection(); //step-1 connection created
 		
 		//step-2 query 
 		stmt = connection.createStatement();
 		int record = stmt.executeUpdate("insert into users (userid, password) values('" + userDTO.getUserId() + "' , '" + Encryption.passwordEncrypt( new String(userDTO.getPassword())) + "')"); //insert , delete , update
 		
		return record;   // 0 or 1
		}
		
		finally { //always execute (resource clenup)
			if(stmt != null) {
				stmt.close();
			}
			
			if(connection != null) {
				connection.close();
			}
		}
	}
}
