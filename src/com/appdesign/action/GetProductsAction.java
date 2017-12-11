package com.appdesign.action;

import java.util.ArrayList;
import java.util.List;

import com.appdesign.dao.ProductDAO;
import com.appdesign.dao.exceptions.DAOException;
import com.appdesign.dao.factory.DAOFactory;
import com.appdesign.model.Product;

public class GetProductsAction {
	public List<Product> getProducts() {
		ProductDAO productDAO = DAOFactory.getProductDAO();
		List<Product> products = new ArrayList<>();
		try {
			products = productDAO.getProduct();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return products;
	}
}
