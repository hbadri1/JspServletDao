package com.appdesign.dao;

import java.util.List;

import com.appdesign.dao.exceptions.DAOException;
import com.appdesign.model.Product;

public interface ProductDAO extends DAO {

	List<Product> getProduct() throws DAOException;

	void insert(Product product) throws DAOException;
}
