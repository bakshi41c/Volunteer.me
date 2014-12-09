package me.volunteer.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import me.volunteer.entity.User;

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
	
	public static final String COLUMN_USER_ID = "idUsers";
	public static final String COLUMN_USER_EMAIL = "email";
	public static final String COLUMN_USER_PASSWORD = "password";
	public static final String COLUMN_USER_NAME = "name";
	public static final String COLUMN_USER_DOB = "dob";
	public static final String COLUMN_USER_GENDER = "gender";
	public static final String COLUMN_USER_PS = "personalStatement";
	public static final String COLUMN_USER_IMAGE = "imageLink";
	public static final String COLUMN_USER_ADMIN = "isAdmin";
	
	public static final String COLUMN_ORG_ID = "idOranizations";
	public static final String COLUMN_ORG_NAME = "name";
	public static final String COLUMN_ORG_PHONE = "phone";
	public static final String COLUMN_ORG_ADDRESS = "address";
	public static final String COLUMN_ORG_EMAIL = "email";
	public static final String COLUMN_ORG_ABOUT = "about";
	public static final String COLUMN_ORG_IMAGE = "imageLink";

	public static final String COLUMN_OPP_ID = "idOppurtunities";
	public static final String COLUMN_OPP_TITLE = "title";
	public static final String COLUMN_OPP_DESC = "description";
	public static final String COLUMN_OPP_DURATION = "duration";
	public static final String COLUMN_OPP_ADDRESS = "address";
	public static final String COLUMN_OPP_ORGID = "organizationID";
	public static final String COLUMN_OPP_DATE = "postDate";
	public static final String COLUMN_OPP_APPROVED = "approved";
	
	public static final String COLUMN_APPLICATION_id = "idApplications";
	public static final String COLUMN_APPLICATION_DATE = "date";
	public static final String COLUMN_APPLICATION_USERID = "userID";
	public static final String COLUMN_APPLICATION_OPPID = "oppurtunityID";
	
	
	
	/**
	 * 
	 * @param connection
	 */
	public DbAdapter (Connection connection){
		
		this.connection = connection;
	}
	
	public void getUser(String email){
		
		String sql = "select * from users where email=?";
		ArrayList<Object> values = new ArrayList<Object>();
		values.add((String)email);
		
		try {
			queryDb(sql,values);
		} catch (SQLException e) {
			e.printStackTrace();
			//return null;
		}
		
	}
	
	public void createUser(User user){
		
		String sql = "INSERT INTO `volunteeringdb`.`users` (`password`, `name`, `email`, `dob`, `gender`, `personalStatement`, `imageLink`, `isAdmin`) VALUES (?, ?, ?, null, null, null, null, '0');";
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(user.getHashedPassword());
		values.add(user.getName());
		values.add(user.getEmail());
		
		
		try {
			updateDb(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean checkCredentials(String email, String password){
		
		String sql = "select count(*) as count from users where email=? and password=?";
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(email);
		values.add(password);
		
		ResultSet rs = null;
		try {
			rs = queryDb(sql,values);
			int count;
			
			if (rs.next()){
				count = rs.getInt("count");
			}else{
				return false;
			}
			
			if (count == 0){
				return false;
			}else{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	private ResultSet queryDb(String sql, ArrayList<Object> parameters) throws SQLException{
		
	
		PreparedStatement stmt = prepareStatement(sql, parameters);
		return stmt.executeQuery();
		
	}
	
	private int updateDb(String sql, ArrayList<Object> parameters) throws SQLException{
		
		PreparedStatement stmt = prepareStatement(sql, parameters);
		return stmt.executeUpdate();
	
	}
	
	private PreparedStatement prepareStatement(String sql, ArrayList<Object> parameters) throws SQLException{
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		

		for (int i = 0; i < parameters.size(); i++){
			
			
			if (parameters.get(i) instanceof Integer){
				
				stmt.setInt(i+1, (Integer) parameters.get(i));
				
			}else if(parameters.get(i) instanceof Calendar){
				
				Calendar cal =  ((Calendar)parameters.get(i));
				
                stmt.setDate(i+1, new java.sql.Date(cal.getTimeInMillis()));
                
            }else if(parameters.get(i) instanceof Boolean){
            	
            	stmt.setBoolean(i+1, (Boolean)parameters.get(i));
                
            }else if(parameters.get(i) instanceof String){
            	
            	stmt.setString(i+1, (String)(parameters.get(i)));
            }
			
			
		}
		

		
		return stmt;
		
	}
	
}
