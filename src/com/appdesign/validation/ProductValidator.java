package com.appdesign.validation;

import java.util.ArrayList;
import java.util.List;

import com.appdesign.form.ProductForm;

public class ProductValidator {
	/**
	 * Validate the product form fields
	 * @param productForm
	 * @return
	 */
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<>();

		String name = productForm.getName();
		if (name == null || name.trim().equals("")) {
			errors.add("Product must have a name");
		}

		String price = productForm.getPrice();
		if (price == null || "".equals(productForm.getPrice().trim())) {
			errors.add("Product must have a price!");
		} else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("Invalid price value");
			} finally {
			}
		}
		return errors;
	}
}
