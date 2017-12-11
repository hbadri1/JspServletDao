package com.appdesign.dao;

import java.sql.Connection;

import com.appdesign.dao.exceptions.DAOException;

public interface DAO {
	Connection getConnection() throws DAOException;
}
