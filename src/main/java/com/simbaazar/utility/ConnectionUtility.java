package com.simbaazar.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
	private static String username = "root";
	
	private static String password = "root";
	
	private static String url = "jdbc:mysql://localhost:3306/simbazaar";
	
public static Connection getConnection(){
	Connection connection = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return connection;
}
/*public static void main(String[] args) throws SQLException {
	Connection conn = getConnection();
	PreparedStatement pstmt = conn.prepareStatement("Select * from sim_details");
	ResultSet resultSet = pstmt.executeQuery();
	while(resultSet.next())
	{
		System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" ");
	}
}*/
}
