package me.volunteer.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Creates a Database connector using
 * JNDI and Tomcat. For username and password
 * of the database, see web.xml
 * @author Shubham
 *
 */
public class RemoteDbConnector {
	
	DataSource ds;
	
	private static final String DBName = "volunteeringDB";
	
	/**
	 * Creates the context and sets data source
	 */
	public RemoteDbConnector(){
		InitialContext initContext = null;
		try {
			
			initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/" + DBName);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gets the SQL Connection to the remote
	 * Database. 
	 * <p/>
	 * Returns null if it can't connect.
	 * @return Connection to the Database
	 */
	public Connection getConnection(){
		
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
