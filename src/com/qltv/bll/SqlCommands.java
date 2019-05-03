package com.qltv.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.qltv.dal.MyConnector;

import net.proteanit.sql.DbUtils;

public class SqlCommands {
	private static Connection con = new MyConnector().Connect("quanlythuvien");

	public static ResultSet SelectCommands(String sql) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps =  con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet SelectCommands(String sql , String[] data) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			for (int i =0; i<data.length; i++)
				ps.setString(i+1, data[i]);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static DefaultTableModel GetTableModel(ResultSet rs, String[] columnNames) {
		DefaultTableModel datamodel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
		Vector<String> columnvector = new Vector<String>();
		for (String name : columnNames)
			columnvector.add(name);
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(datamodel.getDataVector(),columnvector){ 
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
			    return false; 
			} 
			};
		return model;
	}
	//// MT
	public static ResultSet SelectPM_mdg(int mathe) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUMUON + " WHERE mathe = ?";
		try {
			ps = con.prepareStatement(mysql);
			
			ps.setInt(1, mathe);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return rs;
	}
	public static ResultSet SelectSach_ms(int masach) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.SACH + " WHERE masach = ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setInt(1, masach);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
