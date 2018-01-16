package com.vahe.web.chessPortal.services;

import java.util.List; 

import com.vahe.web.chessPortal.javaBeans.Product;

public interface ProductService {

	List<Product> getPopularProducts();
	
	Product getProduct(long id);
}
