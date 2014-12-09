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
	
	private static final String DBName = "volunteeringdb";
	
	/**
	 * Creates the context and sets data source
	 */
	public RemoteDbConnector(){

		try {
			
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/" + DBName);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		if (ds == null){
			//throw new NullPointerException();
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
			throw new NullPointerException(e.toString());
		}
		
		/*
		if (conn == null){
			System.out.println("No connection");
			throw new NullPointerException();
		}
		*/
		return conn;
	}
	
}
