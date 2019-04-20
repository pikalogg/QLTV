package com.qltv.dal;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MyConnector {
	private final String url = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
	private final String user = "root";
	private final String pass = "";
	private Connection connection;
	// connect to database
	public Connection connect() {
		try {
			connection = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("Connect success!");
		} catch (SQLException e) {
			System.out.println("Error connection!");
		}
		return connection;
	}
}
