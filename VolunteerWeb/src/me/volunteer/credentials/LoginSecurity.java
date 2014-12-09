package me.volunteer.credentials;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import me.volunteer.database.DbAdapter;

public class LoginSecurity {
	
	public static boolean checkCredentialsUser (String email, String password, Connection conn){
		
		DbAdapter db = new DbAdapter(conn);
		boolean result = db.checkCredentials(email, hashPassword(password),false);
		
		return result;
	}
	
	public static boolean checkCredentialsOrg (String email, String password, Connection conn){
		
		DbAdapter db = new DbAdapter(conn);
		boolean result = db.checkCredentials(email, hashPassword(password),true);
		
		return result;
	}
	
	public static String hashPassword (String password){
				 
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //Convert the byte to hex format
        
        StringBuffer hashedPassword = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
        	hashedPassword.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		return hashedPassword.toString();
		
	}
	
}
