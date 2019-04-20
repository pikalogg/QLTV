package com.qltv.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Mydata {
	private static Connection con = new MyConnector().connect();
	public static PreparedStatement runSqlCommands(String sql) {
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}	
	public static ResultSet selectCommands(String sql) {
		ResultSet rs = null;
		try {
			rs = runSqlCommands(sql).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
