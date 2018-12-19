package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyJdbcUtil {
	private static DataSource ds =null;
	
	public static DataSource initDataSource() {
		 //plein de variantes : avec ou sans pool/recyclage
		 //      via lookup JNDI et serveur JEE ou via techno et paramétrage de l'appli
		if(ds==null) {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			try{ cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); }catch(Exception e) { e.printStackTrace();}
		    cpds.setJdbcUrl("jdbc:mysql://localhost:3306/baseprod?serverTimezone=UTC");
			cpds.setUser("root");	cpds.setPassword("");
		    // Optional Settings:
		   	cpds.setInitialPoolSize(2);		   	cpds.setMinPoolSize(2);		   	cpds.setMaxPoolSize(10);
		   	System.out.println("cpds="+cpds.toString());
		    ds=cpds;
		}
		return ds;
	}
	
	public static /* ou pas static*/ Connection seConnecter() {
		DataSource datasource = initDataSource();
		Connection cn = null;
		try {
			cn = datasource.getConnection(); //appel simple sans aucun paramètre à fournir
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	
	//ancien nom : seConnecter() , nouveau nom seConnecterSansPool()
	public static Connection seConnecterSansPool() {
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
