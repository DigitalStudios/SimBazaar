package com.simbaazar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simbaazar.bean.AddressBean;
import com.simbaazar.utility.ConnectionUtility;

public class AddressDao {
	
	private Connection connection;
	
	public AddressDao() {
		connection = ConnectionUtility.getConnection();
}

	public void save(AddressBean addressBean) throws SQLException
	{
		String sql = "INSERT INTO `address`(`address_line1`,`address_line2`,`pincode`)VALUES";
		String values = "('"+addressBean.getAddressLineOne()+"','"+addressBean.getAddressLineTwo()+"','"+addressBean.getPincode()+"')";
		
		
		PreparedStatement stmt = connection.prepareStatement(sql+values);
		stmt.execute();
		System.out.println("Insert successful");
	}
	
	public AddressBean getAddress (int addressId) throws SQLException
	{
		AddressBean addressBean = new AddressBean();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = connection.prepareStatement("Select * from Address where address_id = ?");
			pstmt.setInt(1, addressId);
			
			rs = pstmt.executeQuery();
					
			while(rs.next())
			{
				addressBean.setAddress_id(rs.getInt("address_id"));
				addressBean.setAddressLineOne(rs.getString("address_line1"));
				addressBean.setAddressLineTwo(rs.getString("address_line2"));
				addressBean.setPincode(rs.getLong("pincode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			pstmt.close();
			connection.close();
		}
		
		return addressBean;
		}
		
		
	public static void main(String[] args) throws SQLException {
System.out.println(new AddressDao().getAddress(1));
	}
	
}
