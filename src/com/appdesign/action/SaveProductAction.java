package com.appdesign.action;

import com.appdesign.dao.ProductDAO;
import com.appdesign.dao.exceptions.DAOException;
import com.appdesign.dao.factory.DAOFactory;
import com.appdesign.model.Product;

public class SaveProductAction {

	/**
	 * 
	 * @param product
	 */
	public void save(Product product) {
		ProductDAO productDAO = DAOFactory.getProductDAO();
		try {
			productDAO.insert(product);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
