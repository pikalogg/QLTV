package com.qltv.dal;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qltv.bll.SqlCommands;

import net.proteanit.sql.DbUtils;

public class testCon extends JFrame{
	private static final long serialVersionUID = 1L;
	public testCon() {
		setTitle("Main");
		setSize(514, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jTable = new JTable();
		jScrollPane = new JScrollPane(jTable);
		
		getContentPane().add(jScrollPane);
		jScrollPane.setBounds(0, 0, 500, 400);
		DefaultTableModel data = (DefaultTableModel) DbUtils.resultSetToTableModel(SqlCommands.selectCommands("SELECT * FROM docgia"));
		String[] columnNames = {
		        "21 21", "21 12", "1", "ews","Gender","4","54","rgw"
		    };
		data.setColumnIdentifiers(columnNames);
		jTable.setModel(data);
	}
	public static void main(String[] args) {
		new testCon().setVisible(true);
	}
	JScrollPane jScrollPane;
	JTable jTable;
}
