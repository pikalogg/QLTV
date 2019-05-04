package com.qltv.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnector {
	private final String classname = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/";
	private final String user = "root";
	private final String pass = "";
	private Connection connection;
	// connect to database
	public Connection Connect(String databaseName) {
		try {
			Class.forName(classname);
			String myUrl = url.concat(databaseName).concat("?useUnicode=yes&characterEncoding=UTF-8");
			connection = DriverManager.getConnection(myUrl, user, pass);
		} catch (SQLException e) {
			System.out.println("Error connection!");
		} catch (ClassNotFoundException e) {
			System.out.println("class not pika!");
		}
		return connection;
	}
	public static void main(String[] args) {
		new MyConnector().Connect("quanlythuvien");
	}
}
