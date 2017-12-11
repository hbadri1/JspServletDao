package com.appdesign.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.appdesign.dao.exceptions.DAOException;

public class DAOBase implements DAO {

	/**
	 * 
	 */
	@Override
	public Connection getConnection() throws DAOException {
		DataSource dataSource = DataSourceCache.getInstance().getDataSource();
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	/**
	 * 
	 * @param resultSet
	 * @param stmnt
	 * @param con
	 */
	public void closeDBObjects(ResultSet resultSet, Statement stmnt, Connection con) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}
		if (stmnt != null) {
			try {
				stmnt.close();
			} catch (Exception e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

}
