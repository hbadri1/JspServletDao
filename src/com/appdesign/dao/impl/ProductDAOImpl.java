package com.appdesign.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appdesign.dao.DAOBase;
import com.appdesign.dao.ProductDAO;
import com.appdesign.dao.exceptions.DAOException;
import com.appdesign.model.Product;

public class ProductDAOImpl extends DAOBase implements ProductDAO {

	private static final String GET_PRODUCTS_SQL = "SELECT name, description, price FROM products";
	private static final String INSERT_PRODUCT_SQL = "INSERT INTO products(name, description, price) VALUES (?,?,?)";

	@Override
	public List<Product> getProduct() throws DAOException {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet res = null;
		con = this.getConnection();
		try {
			pStmt = con.prepareStatement(GET_PRODUCTS_SQL);
			res = pStmt.executeQuery();
			while (res.next()) {
				Product product = new Product(res.getString("name"), res.getString("description"),
						res.getFloat("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw new DAOException("Error fetching products: " + e.getMessage());
		} finally {
			this.closeDBObjects(res, pStmt, con);
		}
		return products;
	}

	@Override
	public void insert(Product product) throws DAOException {
		Connection con = null;
		PreparedStatement pStmt = null;
		con = this.getConnection();

		try {
			pStmt = con.prepareStatement(INSERT_PRODUCT_SQL);
			pStmt.setString(1, product.getName());
			pStmt.setString(2, product.getDescription());
			pStmt.setFloat(3, product.getPrice());

			pStmt.execute();

		} catch (SQLException e) {
			throw new DAOException("Error adding product: " + e.getMessage());
		} finally {
			this.closeDBObjects(null, pStmt, con);
		}
	}

}
