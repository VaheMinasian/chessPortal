package com.vahe.web.chessPortal.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.vahe.web.chessPortal.javaBeans.Product;

public class ProductRepo {

	@PersistenceContext(unitName = "ChessPU")
	private EntityManager em;
	
	public Product find(Long id) {
		return em.find(Product.class, id);
	}
	
	public Product create(Product product) {
		em.persist(product);
		return product;
	}
	
	public void Delete(Long id) {
		em.remove(em.getReference(Product.class, id));
	}
}
