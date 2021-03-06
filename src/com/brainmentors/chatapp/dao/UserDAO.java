package com.brainmentors.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.Encryption;

public class UserDAO {
	
	public static int changePassword(String userId , char [] np ) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		int rs = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		
		final String SQL = "UPDATE users set password=? WHERE userid=?";
		
		con = CommanDAO.createConnection();
		pstmt = con.prepareStatement(SQL);
		String encryptedPwd = Encryption.passwordEncrypt(new String(np));
		pstmt.setString(1, encryptedPwd);
		pstmt.setString(2, userId);
		rs = pstmt.executeUpdate();
		return rs;
		}
		
		finally {
			if( con != null) {
				con.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
	}
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			
			 con = CommanDAO.createConnection();
			 pstmt = con.prepareStatement(SQL);
			 pstmt.setString(1, userDTO.getUserId());
			 String encryptedPwd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			 pstmt.setString(2, encryptedPwd);
			 rs = pstmt.executeQuery();
			  
			 return rs.next();
//			 if(rs.next()) { //rs.next() will check is rs is true
//				 return true;
//			 }
//			 else {
//				 return false;
//			 }
		}
		
		finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		
//		System.out.println("Rec : " + userDTO.getUserId() + " " + userDTO.getPassword() + " " + userDTO.getEmail() + " " + userDTO.getCity() + " " + userDTO.getPhone());
		
		//inserting it into database
		Connection connection = null; 
		
		//for query
		Statement stmt = null;
		
		try { //guarded region
		//establising connection
 		connection = CommanDAO.createConnection(); //step-1 connection created
 		
 		//step-2 query 
 		stmt = connection.createStatement();
 		int record = stmt.executeUpdate("insert into users (userid, password,email,city,phone)  values('" + userDTO.getUserId() + "' , '" + Encryption.passwordEncrypt( new String(userDTO.getPassword())) + "' , '" +  userDTO.getEmail() + "' , '"  +  userDTO.getCity() + "' , '" + userDTO.getPhone() + "') "); //insert , delete , update
 		
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
