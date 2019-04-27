package com.qltv.bll;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qltv.dal.MyConnector;

import net.proteanit.sql.DbUtils;

public class SqlCommands {
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
	
	
	public static DefaultTableModel getTableModel(String tableName, String[] columnNames) {
		DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(selectCommands("SELECT * FROM docgia"));
		model.setColumnIdentifiers(columnNames);
		return model;
	}
	public static interface tableName{
		String DOCGIA = "docgia";
		String SACH = "sach";
	}
	public static interface columnNames{
		
	}
	
}
