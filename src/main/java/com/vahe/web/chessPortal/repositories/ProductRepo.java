package com.vahe.web.chessPortal.repositories;

import java.util.List;  

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import com.vahe.web.chessPortal.javaBeans.Product;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ProductRepo {

	@PersistenceContext(unitName = "ChessPU")
	private EntityManager em;
	
	public Product find(@NotNull Long id) {
		return em.find(Product.class, id);
	}
	@Transactional(REQUIRED)
	public Product create(@NotNull Product product) {
		em.persist(product);
		return product;
	}
	@Transactional(REQUIRED)
	public void Delete(@NotNull Long id) {
		em.remove(em.getReference(Product.class, id));
	}
	
	public List<Product> findAll(){
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p ORDER BY p.name DESC", Product.class);
		return query.getResultList();
	}
	
	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
		return query.getSingleResult();
	}
}
