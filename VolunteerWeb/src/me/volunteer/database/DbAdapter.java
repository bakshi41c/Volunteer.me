package me.volunteer.database;

import java.sql.Connection;

/**
 * Provides an adapter to modify the
 * database.
 * <p/>
 * This class directly interacts
 * with the database using MySQL.
 * @author Shubham
 *
 */
public class DbAdapter {
	
	Connection connection;
	
	/**
	 * 
	 * @param connection
	 */
	public DbAdapter (Connection connection){
		
		this.connection = connection;
	}
	
	
	
}
