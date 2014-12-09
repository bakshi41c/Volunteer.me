package me.volunteer.credentials;

import java.sql.Connection;
import java.sql.ResultSet;

import me.volunteer.database.DbAdapter;

public class LoginController {
	
	public static boolean checkCredentials (String email, String password, Connection conn){
		
		DbAdapter db = new DbAdapter(conn);
		boolean result = db.checkCredentials(email, password);
		
		return result;
	}
	
}
