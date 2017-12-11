package com.appdesign.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appdesign.action.GetProductsAction;
import com.appdesign.action.SaveProductAction;
import com.appdesign.form.ProductForm;
import com.appdesign.model.Product;
import com.appdesign.validation.ProductValidator;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(description = "Take user input and save product in db.", urlPatterns = { "/product_input", "/product_save",
		"/product_list" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 10048L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		int lastUriIndex = uri.lastIndexOf("/"); // The format is /context_name/resource
		String action = uri.substring(lastUriIndex + 1);
		System.out.println(">>>> " + action);
		String dispatchUrl = null;
		List<String> errors = new ArrayList<>();
		ProductForm productFrom = new ProductForm(request.getParameter("name"), request.getParameter("description"),
				request.getParameter("price"));

		if (action.equals("product_input")) {
			// Nothing to be done
			dispatchUrl = "/jsp/ProductForm.jsp";
		} else if (action.equals("product_save")) {

			errors = new ProductValidator().validate(productFrom);
			if (errors.isEmpty()) {
				// Create the model
				Product product = new Product(productFrom.getName(), productFrom.getDescription(),
						Float.parseFloat(productFrom.getPrice()));

				// Execute action method
				new SaveProductAction().save(product);

				// Store the model in a scope variable for the view
				request.setAttribute("product", product);
				dispatchUrl = "/jsp/ProductDetails.jsp";
			} else {
				request.setAttribute("errors", errors);
				request.setAttribute("form", productFrom);
				dispatchUrl = "/jsp/ProductForm.jsp";
			}
		} else  {
			//The welcome page
			List<Product> products = new GetProductsAction().getProducts();
			request.setAttribute("products", products);
			dispatchUrl = "/jsp/ProductList.jsp";
		}

		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
