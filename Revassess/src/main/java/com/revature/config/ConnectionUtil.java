package com.revature.config;

import java.sql.*;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://revature-project0.chbhk7uwz5xg.us-west-2.rds.amazonaws.com:5432/revasses";
	// add your jdbc username
	public static final String USERNAME = "veitej";
	// add your jdbc password
	public static final String PASSWORD = "Diablos96";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "custom_sequence";

	// implement this method to connect to the db and return the connection object
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value) throws SQLException {

		Connection c=connect();


		String sql = "{?= call abs(?)}";
		CallableStatement cs = c.prepareCall(sql);

		cs.setLong(1, value);

		cs.registerOutParameter(1, Types.LONGVARCHAR);
		
		cs.execute();

		return cs.getLong(1);
	}

	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
