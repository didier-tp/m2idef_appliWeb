package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MyJdbcUtil {
	
	public static Connection seConnecter() {
		Connection cn=null;
		try {
			ResourceBundle ressources = ResourceBundle.getBundle("myDatabase") ; 
			// myDatabase.properties
			String jdbcDriver = ressources.getString("jdbcDriver"); 
			String dbUrl = ressources.getString("dbUrl");
			String username = ressources.getString("username"); 
			String password = ressources.getString("password");
			Class.forName(jdbcDriver);
			cn=DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public static Long getAutoIncrPk(Statement st) {
		Long pk=null;
		try {
			ResultSet rsKeys = st.getGeneratedKeys();
			if(rsKeys.next())
				pk = rsKeys.getLong(1);
			rsKeys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	//fonction utilitaire/réutilisable de fermeture cachant le try/catch obligatoire
		public static void closeCn(Connection cn) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
