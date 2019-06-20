package com.gezhi.teamone.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource ds;
	static {
		ds = new ComboPooledDataSource();		
	}
	public static Connection getCon() throws SQLException {
		// TODO Auto-generated method stub
		return ds.getConnection();
	}
	public static void closeAll(ResultSet rs , PreparedStatement psta,Connection con) {
		// TODO Auto-generated method stub
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}	
}
