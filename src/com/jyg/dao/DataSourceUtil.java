package com.jyg.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DataSourceUtil {

	private static DataSource dataSource = null;
	private static Logger logger = LogManager.getLogger(DataSourceUtil.class);  
	 
	public static Connection getConnection() throws NamingException, SQLException{
		if(dataSource == null){
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/TAXDB");
		}
		return dataSource.getConnection();
	}
	
	public boolean isConnectedOK(){
		boolean ok = false;
		Connection conn = null;
		SQLException ex = null;
		try{
			conn = dataSource.getConnection();
			if(! conn.isClosed()){
				ok = true;
			}
		} catch(SQLException e){
			ex = e;
		} finally{
			if( conn != null){
				try{
					conn.close();
				} catch(SQLException e){
					if(ex == null){
						ex = e;
					}
				}
			}
		}
		
		if(ex != null){
			throw new RuntimeException(ex);
		}
		return ok;
	}
}
