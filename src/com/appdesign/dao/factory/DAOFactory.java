package com.appdesign.dao.factory;

import com.appdesign.dao.ProductDAO;
import com.appdesign.dao.impl.ProductDAOImpl;

public class DAOFactory {
	
	public static ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}
}
